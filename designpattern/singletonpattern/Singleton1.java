package designpattern.singletonpattern;

/**
 * 确保程序中使用的全局资源只有一份
 * 管理数据库连接 或者线程池
 * 想要用的时候，是请求生成一个实例，构造方法是私有的
 * 使用静态方法getInstance（）
 */
public class Singleton1 {
    //利用一个静态变量来记录Singleton类的唯一实例
    /*
    因为是静态变量，所以这个变量只有一个实例
     */
    private static Singleton1 uniqueInstance;

    //把构造器声明为私有的，只有自Singleton类内才能调用构造器
    private Singleton1() {
    }

    /*
    如果直接对getInstance方法加synchronized关键字，每次调用都是同步的
    可是仅仅第一次生成的时候，不能并发，这样降低了性能
    同步一个方法可能造成程序 执行效率下降100倍
    所以 如果getInstance调用频繁，就要重新考虑
     */
    public static synchronized Singleton1 getInstance() {/*用getInstance（）方法 实例化对象，并返回这个实例
        如果不需要这个实例，它拥有不会产生--延迟实例化
        */
        if (Singleton1.uniqueInstance == null) {
            Singleton1.uniqueInstance = new Singleton1();
        }
        //Singleton是一个正常的嘞，具有其他实例变量和方法
        return Singleton1.uniqueInstance;
    }
}
