package jdk.notes;

import java.security.AccessControlContext;

//    线程是程序中的执行线程。 Java 虚拟机允许应用程序同时运行多个执行线程。
//每个线程都有一个优先级。具有较高优先级的线程优先于具有较低优先级的线程执行。每个线程可能会也可能不会被标记为守护进程。当在某个线程中运行的代码创建一个新的 Thread 对象时，新线程的优先级最初设置为等于创建线程的优先级，并且当且仅当创建线程是守护进程时，它才是守护线程。
//当 Java 虚拟机启动时，通常有一个非守护线程（通常调用某个指定类的名为 main 的方法）。 Java 虚拟机继续执行线程，直到发生以下任一情况：
//已调用 Runtime 类的退出方法，并且安全管理器已允许进行退出操作。
//所有不是守护线程的线程都已经死亡，要么通过调用 run 方法返回，要么抛出传播到 run 方法之外的异常。
//有两种方法可以创建一个新的执行线程。一种是将类声明为 Thread 的子类。这个子类应该重写类 Thread 的 run 方法。然后可以分配和启动子类的实例。
class PrimeThread extends Thread {
    long minPrime;

    //初始化线程，该方法是私有的，要从系统的多个管理器来获得句柄的引用
    private PrimeThread(ThreadGroup g, Runnable target, String name,
                        long stackSize, AccessControlContext acc,
                        boolean inheritThreadLocals) {
        //
        //inheritThreadLocals具有抑制或不抑制从构造线程继承可继承线程局部变量的初始值的能力。这允许对可继承的线程局部变量进行更细粒度的控制。为 inheritThreadLocals 传递 false 值时必须小心，因为如果新线程执行期望继承特定线程局部值的代码，则可能会导致意外行为。
    }

    //该方法是在指定的线程组来创建线程，
    // 线程组是可以包含线程组和线程的树结构的对象。用于集中管理线程和守护线程
    //当且仅当创建它的线程当前被标记为守护线程时，新创建的线程最初被标记为守护线程。 方法 setDaemon 可用于更改线程是否为守护进程。
    public PrimeThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    //因为 Thread 不能被有意义地克隆。 而是构建一个新线程。所以clone方法被覆盖成protected
    protected Object clone() {
        return null;
    }

    PrimeThread(long minPrime) {
        this.minPrime = minPrime;
    }

    @Override
    public void run() {
        //compute prime
        super.run();
        Integer.parseInt("d");
    }

    //强制线程停止执行。
    //如果安装了安全管理器，则调用其 checkAccess 方法，并将 this 作为其参数。这可能会导致引发 SecurityException（在当前线程中）。
    //如果此线程与当前线程不同（即当前线程试图停止除自身之外的线程），则另外调用安全管理器的 checkPermission 方法（带有 RuntimePermission("stopThread") 参数）。同样，这可能会导致抛出 SecurityException（在当前线程中）。
    //这个线程所代表的线程被强制停止它正在做的任何异常，并抛出一个新创建的 ThreadDeath 对象作为异常
    @Deprecated(since = "1.2")
    public final void stop1() {
        //如果父类声明了方法为final，子类无法声明同样的方法
    }

    //如果该线程在 java.nio.channels.Selector 中被阻塞，则该线程的中断状态将被设置，并且它将立即从选择操作返回，可能带有非零值，就像调用了选择器的唤醒方法一样。
    //如果前面的条件都不成立，则将设置该线程的中断状态。
    //中断一个不活动的线程不需要有任何效果。
    public void interrupt() {
        //调用虚拟机的中断方法
    }

    //测试当前线程是否被中断。 通过该方法清除线程的中断状态。 换句话说，如果这个方法被连续调用两次，第二次调用将返回 false（除非当前线程再次被中断，在第一次调用清除其中断状态之后，第二次调用检查它之前）。
    //回报：
    //如果当前线程已被中断，则为 true； 否则为假。
    // 我们可能在读完字段的那一刻就被打断了，
    // 所以只有当我们看到它被设置并返回时才清除该字段
    // 真的; 否则我们可能会失去中断。
    public static boolean interrupted() {
        return !currentThread().isInterrupted();
    }

    public boolean isInterrupted() {
        return true;
    }

    //暂停此线程。
    //首先，调用该线程的 checkAccess 方法时不带任何参数。 这可能会导致抛出 SecurityException（在当前线程中）。
    //如果线程是活动的，它会被挂起并且不会继续前进，除非它被恢复。
    @Deprecated(since = "1.2", forRemoval = true)
    public final void suspend1() {
    }

    //恢复挂起的线程。
    //首先，调用该线程的 checkAccess 方法时不带任何参数。 这可能会导致抛出 SecurityException（在当前线程中）。
    //如果线程处于活动状态但被挂起，它会被恢复并被允许在其执行中取得进展。
    //已弃用
    //此方法仅用于挂起，已被弃用，因为它容易死锁。
    @Deprecated(since = "1.2", forRemoval = true)
    public final void resume1() {
    }

    //返回当前线程的线程组及其子组中活动线程数的估计值。 递归迭代当前线程的线程组中的所有子组。
    //返回的值只是一个估计值，因为在此方法遍历内部数据结构时线程数可能会动态变化，并且可能会受到某些系统线程的存在的影响。 此方法主要用于调试和监视目的。
    //回报：
    //当前线程的线程组和以当前线程的线程组为祖先的任何其他线程组中的活动线程数的估计
    public static int activeCount() {
        return currentThread().getThreadGroup().activeCount();
    }

    //将当前线程的线程组及其子组中的每个活动线程复制到指定的数组中。 该方法只是调用当前线程的线程组的 ThreadGroup.enumerate(Thread[]) 方法。
    //应用程序可能会使用 activeCount 方法来估计数组应该有多大，但是如果数组太短而无法容纳所有线程，那么额外的线程将被忽略。 如果获取当前线程的线程组及其子组中的每个活动线程至关重要，则调用程序应验证返回的 int 值是否严格小于 tarray 的长度。
    //由于此方法中固有的竞争条件，建议仅将该方法用于调试和监视目的。
    public static int enumerate(Thread tarray[]) {
        return currentThread().getThreadGroup().enumerate(tarray);
    }

}

//创建线程的另一种方法是声明一个实现 Runnable 接口的类。 然后该类实现 run 方法。 然后可以分配一个类的实例，在创建线程时作为参数传递，然后启动。
class PrimeRun implements Runnable {
    long minPrime;

    PrimeRun(long minPrime) {
        this.minPrime = minPrime;

    }

    @Override
    public void run() {

        // compute primes
        // Java Thread sleep() 和 object wait() 的区别和联系
        //睡眠（）示例
        //synchronized(LOCK) {
        //    Thread.sleep(1000); // LOCK is held
        //}
        //等待（）示例
        //synchronized(LOCK)
        //{
        //    LOCK.wait(); // LOCK is not held
        //}
        //3.1。调用的方法
        //wait()– 调用一个对象；当前线程必须在锁对象上同步。
        //sleep()– 调用线程；总是当前正在执行的线程。
        //3.2. 同步的
        //wait()– 当同步多个线程一个一个访问同一个对象时。
        //sleep()– 当同步多个线程等待休眠线程的休眠时。
        //3.3. 锁定持续时间
        //wait()– 释放锁以使其他对象有机会执行。
        //sleep()– 如果指定超时或有人中断，至少保持锁定 t 次。
        //3.4. 唤醒状态
        //wait()– 直到从对象调用 notify()、notifyAll()
        //sleep()– 直到至少时间到期或调用中断（）。
        //3.5. 用法
        //sleep()– 用于时间同步
        //wait()– 用于多线程同步。
        synchronized (this) {
            try {
                this.wait(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
                //this.wait(1000);会报错
                //IllegalMonitorStateException: current thread is not owner
                //只有在持有对象的锁时才能调用 wait() 或 notify() —— 即，在对象的同步方法中，或在该对象上同步的块中。
            }
        }

        synchronized (this) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("run " + this.toString());
    }
}

class EventHandler {
    volatile boolean eventNotificationNotReceived;

    //
    void waitForEventAndHandleIt() {
        while (eventNotificationNotReceived) {
            // 自旋等待
            //表示调用者暂时无法继续，直到其他活动发生一个或多个动作。 通过在自旋等待循环构造的每次迭代中调用此方法，调用线程向运行时指示它正忙于等待。 运行时可能会采取措施来提高调用自旋等待循环构造的性能。
            //API 注释：
            //例如，考虑类中的一个方法，该方法在循环中旋转，直到在该方法之外设置了某个标志。 对 onSpinWait 方法的调用应该放在自旋循环内。
            //即使根本没有调用 onSpinWait 方法，上面的代码也将保持正确。 然而，在某些架构上，Java 虚拟机可能会发出处理器指令，以更有益的方式处理此类代码模式。
            java.lang.Thread.onSpinWait();
        }
        readAndProcessEvent();
    }

    void readAndProcessEvent() {
        // Read event from some source and process it
    }
}

public class ThreadNotes implements Runnable {
    public ThreadNotes() {
        stackSize = 0;
    }

    //作用是 确保 registerNatives 是 <clinit> 做的第一件事
    private static native void registerNatives();

    static {
        registerNatives();
    }

    //线程的基本属性
    private volatile String name;//线程名字
    private int priority;//线程优先级
    private boolean daemon = false;//是否是守护进程
    private volatile boolean interrupted;// 是否收到中断请求（保留线程状态TCB以备继续执行）是JVM直接修改值的 是同步的，为啥
    private volatile int threadStatus;
    //线程持有的对象
    /* What will be run. */
    private Runnable target;

    /* The group of this thread */
    private ThreadGroup group;

    //返回此线程的上下文 ClassLoader。 上下文 ClassLoader 由线程的创建者提供，供在该线程中运行的代码在加载类和资源时使用。 如果未设置，则默认为父线程的 ClassLoader 上下文。 原始线程的上下文 ClassLoader 通常设置为用于加载应用程序的类加载器。
    private ClassLoader contextClassLoader;

    //设置此线程的上下文 ClassLoader。 上下文类加载器可以在创建线程时设置，并允许线程的创建者在加载类和资源时通过getContextClassLoader为线程中运行的代码提供合适的类加载器。
//如果存在安全管理器，则使用 RuntimePermission("setContextClassLoader") 权限调用其 checkPermission 方法，以查看是否允许设置上下文 ClassLoader。
    public void setContextClassLoader(ClassLoader cl) {
        contextClassLoader = cl;
    }

    ;
    /* The inherited AccessControlContext of this thread */
    private AccessControlContext inheritedAccessControlContext;

    //该线程在可中断 I/O 操作中被阻塞的对象，如果有的话。 设置此线程的中断状态后，应调用阻塞器的中断方法。阻塞方法是同步的，每次只能阻塞一个方法
//    private volatile Interruptible blocker;
    private final Object blockerLock = new Object();

    //    ThreadLocal.ThreadLocalMap threadLocals = null;  与此线程有关的 ThreadLocal 值。由ThreadLocal维护
//ThreadLocalMap的hotspot的底层实现是object数组
    Thread myThread = new Thread(new PrimeRun(143));

    //两组自增的线程命名的维护
    private static int threadInitNumber;

    private static synchronized int nextThreadNum() {
        return threadInitNumber++;
    }

    private static long threadSeqNumber;

    private static synchronized long nextThreadID() {
        return ++threadSeqNumber;
    }

    //此线程请求的堆栈大小，如果创建者未指定堆栈大小，则为 0。 由虚拟机决定对这个数字做任何它喜欢的事情； 一些虚拟机会忽略它。
    private final long stackSize;//final 类型的变量，要么直接赋初值，要么在构造器中赋值。

    //向调度程序提示当前线程愿意放弃其当前对处理器的使用。 调度程序可以随意忽略此提示。
//Yield 是一种启发式尝试，旨在改善线程之间的相对进展，否则会过度使用 CPU。 它的使用应与详细的分析和基准测试相结合，以确保它实际上具有预期的效果。
//很少使用这种方法。 它对于调试或测试目的可能很有用，它可能有助于重现由于竞争条件导致的错误。 在设计并发控制结构（例如 java.util.concurrent.locks 包中的结构）时，它也可能很有用。
    public static native void yield();

    //使当前执行的线程休眠（暂时停止执行）指定的毫秒数，取决于系统计时器和调度程序的精度和准确性。 该线程不会失去任何监视器的所有权。
//参数：
//millis - 以毫秒为单位的睡眠时间长度
//抛出：
//IllegalArgumentException – 如果 millis 的值为负
//InterruptedException – 如果任何线程中断了当前线程。 抛出此异常时清除当前线程的中断状态。
    public static native void sleep(long millis);


    //系统调用此方法使线程有机会在实际退出之前进行清理。
    private void exit() {
        //手动制成null可以加快其中一些资源的释放
        target = null;
    }


    public static void main(String[] args) {
        Thread t = new PrimeThread(43);
        t.start();
        Thread t1 = new Thread(new PrimeRun(143));
        t1.start();
        //start使该线程开始执行； Java 虚拟机调用该线程的 run 方法。
        //结果是两个线程同时运行：当前线程（从对 start 方法的调用返回）和另一个线程（执行其 run 方法）。
        //多次启动一个线程是不合法的。 特别是，线程一旦完成执行就可能不会重新启动。
        //t1.start();
        //t.start();线程的start方法只能被执行一次，不管是成功了还是失败了，都不能再执行了
        new Thread(new PrimeRun(143)).start();
        new Thread(new PrimeRun(143)).start();
        new Thread(new PrimeRun(143)).start();
        new Thread(new PrimeRun(143)).start();
        //最多等待几毫秒让该线程终止。 超时 0 意味着永远等待。
        //此实现使用以 this.isAlive 为条件的 this.wait 调用循环。 当线程终止时，将调用 this.notifyAll 方法。 建议应用程序不要在 Thread 实例上使用 wait、notify 或 notifyAll。
        try {
            //等待这个线程死掉。
            //此方法的调用与调用的行为方式完全相同
            t1.join(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //将当前线程的堆栈跟踪打印到标准错误流。 此方法仅用于调试。
        Thread.dumpStack();
        //确定当前运行的线程是否有权修改该线程。
        //如果有一个安全管理器，它的 checkAccess 方法会以这个线程作为它的参数被调用。 这可能会导致抛出 SecurityException。
        t1.checkAccess();
        //当且仅当当前线程持有指定对象上的监视器锁时才返回 true。
        //此方法旨在允许程序断言当前线程已经持有指定的锁：
        Thread.holdsLock(t1);
        //返回表示此线程的堆栈转储的堆栈跟踪元素数组。如果此线程尚未启动、已启动但尚未被系统调度运行或已终止，则此方法将返回一个长度为零的数组。如果返回的数组长度非零，则数组的第一个元素表示堆栈的顶部，这是序列中最近的方法调用。数组的最后一个元素表示堆栈的底部，它是序列中最近的方法调用。
        //如果有一个安全管理器，并且这个线程不是当前线程，那么使用一个 RuntimePermission("getStackTrace") 权限调用安全管理器的 checkPermission 方法，看看是否可以获取堆栈跟踪。
        //在某些情况下，某些虚拟机可能会从堆栈跟踪中省略一个或多个堆栈帧。在极端情况下，允许没有关于该线程的堆栈跟踪信息的虚拟机从该方法返回一个长度为零的数组。
        //调用private static native StackTraceElement[][] dumpThreads(Thread[] threads);实现
        t1.getStackTrace();
        //返回所有活动线程的堆栈跟踪映射。 映射键是线程，每个映射值是一个 StackTraceElement 数组，表示相应线程的堆栈转储。 返回的堆栈跟踪采用为 getStackTrace 方法指定的格式。
        //调用此方法时线程可能正在执行。 每个线程的堆栈跟踪仅代表一个快照，并且每个堆栈跟踪可能在不同的时间获得。
        Thread.getAllStackTraces();
        //线程状态。 线程可以处于以下状态之一：
        //NEW 尚未启动的线程处于此状态。
        //RUNNABLE 在 Java 虚拟机中执行的线程处于此状态。可运行线程的线程状态。 处于可运行状态的线程正在 Java 虚拟机中执行，但它可能正在等待来自操作系统的其他资源，例如处理器。
        //BLOCKED 阻塞等待监视器锁的线程处于此状态。 线程阻塞等待监视器锁的线程状态。 处于阻塞状态的线程正在等待监视器锁进入同步块/方法或调用 Object.wait 后重新进入同步块/方法。
        //WAITING 无限期等待另一个线程执行特定操作的线程处于此状态。
        //等待线程的线程状态。 由于调用以下方法之一，线程处于等待状态：
        //Object.wait 没有超时
        //没有超时的 Thread.join
        //LockSupport.park
        //处于等待状态的线程正在等待另一个线程执行特定操作。 例如，一个对对象调用 Object.wait() 的线程正在等待另一个线程对该对象调用 Object.notify() 或 Object.notifyAll()。 已调用 Thread.join() 的线程正在等待指定线程终止。
        //TIMED_WAITING 等待另一个线程执行操作达指定等待时间的线程处于此状态。
        //TERMINATED 已退出的线程处于此状态。 已终止线程的线程状态。 线程已完成执行。
        //一个线程在给定的时间点只能处于一种状态。 这些状态是不反映任何操作系统线程状态的虚拟机状态。

        //设置当线程由于未捕获的异常而突然终止时调用的默认处理程序，并且没有为该线程定义其他处理程序。
        //未捕获的异常处理首先由线程控制，然后由线程的 ThreadGroup 对象控制，最后由默认的未捕获异常处理程序控制。 如果线程没有明确的未捕获异常处理程序集，并且线程的线程组（包括父线程组）没有专门化其 uncaughtException 方法，则将调用默认处理程序的 uncaughtException 方法。
        //通过设置默认的未捕获异常处理程序，应用程序可以更改那些已经接受系统提供的任何“默认”行为的线程处理未捕获异常的方式（例如记录到特定设备或文件）。
        //请注意，默认的未捕获异常处理程序通常不应遵循线程的 ThreadGroup 对象，因为这可能导致无限递归。
        Thread.setDefaultUncaughtExceptionHandler(null);
    }

    @Override
    public void run() {

    }
}
