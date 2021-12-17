package designpattern.singletonpattern;

/**
 * 确保程序中使用的全局资源只有一份
 * 管理数据库连接 或者线程池
 * 想要用的时候，是请求生成一个实例，构造方法是私有的
 * 使用静态方法getInstance（）
 */
public class Singleton3 {
    //利用一个静态变量来记录Singleton类的唯一实例
    /*
    因为是静态变量，所以这个变量只有一个实例
     */
    private volatile static Singleton3 uniqueInstance;

    //把构造器声明为私有的，只有自Singleton类内才能调用构造器
    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        /*
        在null里面使用同步，则可以减少新建之后的同步加锁降低性能
        但是要把Singleton声明成volatile的，因为当初始化成实例时，多个线程要都被通知
        volatile关键字只在java5之后才是有效的双重锁
        */
        if (Singleton3.uniqueInstance != null) {
            return Singleton3.uniqueInstance;
        }
        synchronized (Singleton3.class) {
            if (Singleton3.uniqueInstance == null) {
                Singleton3.uniqueInstance = new Singleton3();
            }
        }
        //Singleton是一个正常的嘞，具有其他实例变量和方法
        return Singleton3.uniqueInstance;
    }
}
