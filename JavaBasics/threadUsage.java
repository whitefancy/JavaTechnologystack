package JavaBasics;

public class threadUsage {
    //线程局部变量ThreadLocal
    //ThreadLocal在每个线程中对该变量会创建一个副本，即每个线程内部都会有一个该变量，且在线程内部任何地方都可以使用，线程之间互不影响，这样一来就不存在线程安全问题，也不会严重影响程序执行性能。
    //使用场景
    //最常见的ThreadLocal使用场景为 用来解决 数据库连接、Session管理等。
    //实现原理
    //使用ThreadLocal<UserInfo> userInfo = new ThreadLocal<UserInfo>()的方式，让每个线程内部都会维护一个ThreadLocalMap，ThreadLocalMap，这个类型是ThreadLocal类的一个内部类，里边包含若干了 Entry（K-V 键值对），每次存取都会先获取到当前线程ID，然后得到该线程对象中的Map，然后与Map交互。在每个线程Thread内部有一个ThreadLocal.ThreadLocalMap类型的成员变量threadLocals，这个threadLocals就是用来存储实际的变量副本的，键值为当前ThreadLocal变量，value为变量副本（即T类型的变量）。
    //初始时，在Thread里面，threadLocals为空，当通过ThreadLocal变量调用get()方法或者set()方法，就会对Thread类中的threadLocals进行初始化，并且以当前ThreadLocal变量为键值，以ThreadLocal要保存的副本变量为value，存到threadLocals。
    //然后在当前线程里面，如果要使用副本变量，就可以通过get方法在threadLocals里面查找。
    //ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    //ThreadLocal<String> stringLocal = new ThreadLocal<String>();
    //public void set() {
    //longLocal.set(Thread.currentThread().getId());
    //stringLocal.set(Thread.currentThread().getName());
    //}
    //常用方法
    //ThreadLocal类提供的几个方法：
    //public T get() { }
    //get()方法是用来获取ThreadLocal在当前线程中保存的变量副本，set()用来设置当前线程中变量的副本，remove()用来移除当前线程中变量的副本，initialValue()是一个protected方法，一般是用来在使用时进行重写的。
    //public void set(T value) { }
    //public void remove() { }
    //protected T initialValue() { }
}
