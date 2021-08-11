package javaconcurrent.threadpoolexecutor.handleexception;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadFactory 对线程池中线程做定制化 execute
 * 线程池
 * 常见的线程池包括newSingleThreadExecutor，newFixedThreadPool，newCachedThreadPool，
 * newScheduledThreadPool，newWorkStealingPool。线程池的几个重要参数是corePoolSize，maximumPoolSize，keepAliveTime，workQueue。
 */
public class Test3 {
    //ThreadPoolExecutor
    //明确指出线程资源必须通过线程池提供，不允许在应用中自行显示创建线程。
    //public ThreadPoolExecutor(int corePoolSize,
    //int maximumPoolSize,
    //long keepAliveTime,
    //TimeUnit unit,
    //BlockingQueue<Runnable> workQueue,
    //ThreadFactory threadFactory,
    //RejectedExecutionHandler handler)
    //* @param workQueue 等待队列，当任务提交时，如果线程池中的线程数量大于等于corePoolSize的时候，把该任务封装成一个Worker对象放入等待队列；
    //* @param threadFactory 执行者创建新线程时使用的工厂
    //ScheduledThreadPoolExecutor
    //主要用来在给定的延迟后运行任务，或者定期执行任务。
    //ScheduledThreadPoolExecutor使用的任务队列DelayQueue封装了一个PriorityQueue，PriorityQueue会对队列中的任务进行排序，执行所需时间短的放在前面先被执行(ScheduledFutureTask的time变量小的先执行)，如果执行所需时间相同则先提交的任务将被先执行(ScheduledFutureTask的squenceNumber变量小的先执行)。
    //Fork-Join框架
    //ForkJoinPool 在 Java 7 中被引入。ForkJoinPool 让我们可以很方便地把任务分裂成几个更小的任务，这些分裂出来的任务也将会提交给 ForkJoinPool。
    //假设有一个处理任务， 它可以很自然地分解为子任务，完成计算密集型任务， 如图像或视频处理。
    //需要提供一个扩展 RecursiveTaskO 的类（如果计算会生成一个类型为 T 的结果）或者提供一个扩展 RecursiveActicm 的类（如果不生成任何结果)。再覆盖 compute 方法来生成并调用子任务， 然后合并其结果。
    //在后台， fork-join 框架使用了一种有效的智能方法来平衡可用线程的工作负载，这种方法称为工作密取（work stealing)。每个工作线程都有一个双端队列 ( deque ) 来完成任务。一 个工作线程将子任务压人其双端队列的队头。
    //预订执行 ScheduledExecutorService
    //ScheduledExecutorService 接口具有为预定执行（ Scheduled Execution) 或 重 复 执 行 任务而设计的方法。
    //可以预定 Runnable 或 Callable 在初始的延迟之后只运行一次。也可以预定一个 Runnable对象周期性地运行。
    //将结果按可获得的顺序保存起来更有实际意义。可以用 ExecutorCompletionService 来进行排列。
    //可完成Future
    //它会在所有这些 future 都完成时或者其中任意一个 future 完成时结束。不会传递任何结果。
    //线程池的核心参数
    //创建线程的逻辑
    //corePoolSize：核心线程数量，线程池中应该常驻的线程数量
    //maximumPoolSize：线程池允许的最大线程数，非核心线程在超时之后会被清除
    //keepAliveTime：线程没有任务执行时可以保持的时间
    //unit：时间单位
    //以下任务提交逻辑来自ThreadPoolExecutor.execute方法：
    //如果运行的线程数 < corePoolSize，直接创建新线程，即使有其他线程是空闲的
    //如果运行的线程数 >= corePoolSize
    //2.1 如果插入队列成功，则完成本次任务提交，但不创建新线程
    //2.2 如果插入队列失败，说明队列满了
    //2.2.1 如果当前线程数 < maximumPoolSize，创建新的线程放到线程池中
    //2.2.2 如果当前线程数 >= maximumPoolSize，会执行指定的拒绝策略
    //阻塞队列的策略
    //workQueue：阻塞队列，存储等待执行的任务
    //rejectHandler：当拒绝任务提交时的策略（抛异常、用调用者所在的线程执行任务、丢弃队列中第一个任务执行当前任务、直接丢弃任务）
    //直接提交。SynchronousQueue是一个没有数据缓冲的BlockingQueue，生产者线程对其的插入操作put必须等待消费者的移除操作take。将任务直接提交给线程而不保持它们。
    //无界队列。当使用无限的 maximumPoolSizes 时，将导致在所有corePoolSize线程都忙时新任务在队列中等待。
    //有界队列。当使用有限的 maximumPoolSizes 时，有界队列（如ArrayBlockingQueue）有助于防止资源耗尽，但是可能较难调整和控制。
    //使用方法
    //execute(Runnable)：
    //无法得知被执行的 Runnable 的执行结果
    //submit(Runnable)：
    //返回一个 Future 对象，可以知道Runnable 是否执行完毕。
    //第一个 submit（Runnable） 方法返回一个奇怪样子的 Future<?>。可以使用这样一个对象来调用isDone、 cancel 或 isCancelled。但是， get 方法在完成的时候只是简单地返回 null
    //当用完一个线程池的时候， 调用 shutdown。该方法启动该池的关闭序列。被关闭的执行器不再接受新的任务。
    //submit(Callable)：
    //Callable 实例除了它的 call() 方法能够返回一个结果，通过Future可以获取。
    //invokeAny(…)：
    //传入一系列的 Callable 或者其子接口的实例对象，无法保证返回的是哪个 Callable 的结果 ，只能表明其中一个已执行结束。
    //如果其中一个任务执行结束(或者抛了一个异常)，其他 Callable 将被取消。
    //invokeAny 方法提交所有对象到一个 Callable 对象的集合中，并返回某个已经完成了的任务的结果。
    //invokeAll(…)
    //返回一系列的 Future 对象，通过它们你可以获取每个 Callable 的执行结果。invokeAll 方法提交所有对象到一个 Callable 对象的集合中，并返回一个 Future 对象的列表，代表所有任务的解决方案。
    //shutdown()
    //不会立即关闭，但它将不再接受新的任务
    //shutdownNow()
    //该池取消尚未开始的所有任务并试图中断正在运行的线程。
    //将 Runnable 对象交给线程池， 就会有一个线程调用 run 方法。 当 run 方法退出时，线程不会死亡，而是在池中准备为下一个请求提供服务。
    //使用静态工厂方法用来构建线程池
    //threadFactory：线程工厂，来创建线程
    //newCachedThreadPool
    //newFixedThreadPool
    //newSingleThreadExecutor
    //newScheduledThreadPool
    //newSingleThreadScheduledExecutor
    //Java异步调用转同步
    //同步调用：调用方在调用过程中，持续等待返回结果。
    //异步调用：调用方在调用过程中，不直接等待返回结果，而是执行其他任务，结果返回形式通常为回调函数。
    //使用wait和notify方法
    //使用条件锁
    //Future
    //使用CountDownLatch
    //使用CyclicBarrier
    public static void main(String[] args) {
        MyRunnable2 myRunnable1 = new MyRunnable2();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 9999, 9999,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        pool.setThreadFactory(new MyThreadFactoryA());
        pool.execute(myRunnable1);
    }
}
