package designpattern.singletonpattern;

/**
 * 确保程序中使用的全局资源只有一份
 * 管理数据库连接 或者线程池
 * 想要用的时候，是请求生成一个实例，构造方法是私有的
 * 使用静态方法getInstance（）
 */
public class Singleton2 {
    //利用一个静态变量来记录Singleton类的唯一实例
    /*
    因为是静态变量，所以这个变量只有一个实例
    使用“急切”创建实例，而不延迟化加载，也能改善多线程，JVM会保证它的唯一性
     */
    private static Singleton2 uniqueInstance = new Singleton2();

    //把构造器声明为私有的，只有自Singleton类内才能调用构造器
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        //Singleton是一个正常的嘞，具有其他实例变量和方法
        return Singleton2.uniqueInstance;
    }
}
