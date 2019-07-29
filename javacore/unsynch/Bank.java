package javacore.unsynch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock transferLock = new ReentrantLock();
    private Condition sufficientFunds;// 条件对象
    private Lock intrinsicLock = new ReentrantLock();

    public Bank(int naccounts, double initialBalance) {
        sufficientFunds = transferLock.newCondition();//为同步锁增加条件对象
        accounts = new double[naccounts];
        Arrays.fill(accounts, initialBalance);
    }

    public int size() {
        return accounts.length;
    }

    public void transfer(int from, int to, double amount) {
        /*
        锁和条件的关键之处
        任何时刻只有一个线程执行被保护的代码
        锁管理试图进入被保护代码段的线程
        锁可以拥有一个或多个相关对象
        条件对象 管理 的是进入被保护代码段 但是还不能运行的线程
         */
        transferLock.lock();
        try {
            while (accounts[from] < amount) {
                System.out.println(from + " waiting...");
                sufficientFunds.await();//当账户余额不足，用户并不想取消交易，而是想等有钱了再交易 阻塞自己
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d\n", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance:%10.2f\n", getTotalBalance());
            sufficientFunds.signalAll();//解除阻塞 signal()是随机选择一个线程，解除其阻塞状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            transferLock.unlock();
        }
    }

    private synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public synchronized void method1() {
        //method body
    }

    //等价于下面，所以也可以简单地将transfer方法声明为synchronized 而不是使用一个显式地锁
    /*
    如果只有一个条件对象，比如object， 那么object.wait() 和 notifyAll 就等价于
    intrinsicCondition.await()  和  signalAll
     */
    public void method() {
        this.intrinsicLock.lock();
        try {
            //method body
        } finally {
            this.intrinsicLock.unlock();
        }
    }

    /*
    最好既不使用Lock condition 也不使用 synchronized关键字
    而是使用concurrent包提供的机制
    比如阻塞队列
    如果synchronized时候，尽量使用，除非特别需要，才使用Lock/condition
     */
    public synchronized void transfer1(int from, int to, double amount) {
//使用synchronized关键字来编写，要简洁得多
        while (accounts[from] < amount) {
            System.out.println(from + " waiting...");
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d\n", amount, from, to);
        accounts[to] += amount;
        System.out.printf("Total Balance:%10.2f\n", getTotalBalance());
        notifyAll();
    }

}
