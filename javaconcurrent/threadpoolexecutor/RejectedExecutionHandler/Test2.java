package javaconcurrent.threadpoolexecutor.RejectedExecutionHandler;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {
        MyRunnable1 myRunnable1 = new MyRunnable1("中国1");
        MyRunnable1 myRunnable2 = new MyRunnable1("中国2");
        MyRunnable1 myRunnable3 = new MyRunnable1("中国3");
        MyRunnable1 myRunnable4 = new MyRunnable1("中国4");
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3,
                9999L, TimeUnit.SECONDS, new SynchronousQueue<>());
        pool.setRejectedExecutionHandler(new MyRejectedExecutionHandler());
        pool.execute(myRunnable1);
        pool.execute(myRunnable2);
        pool.execute(myRunnable3);
        pool.execute(myRunnable4);
    }
}
