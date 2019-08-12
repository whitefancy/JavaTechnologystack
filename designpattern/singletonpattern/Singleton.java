package designpattern.singletonpattern;

/**
 * 确保程序中使用的全局资源只有一份
 * 管理数据库连接 或者线程池
 * 想要用的时候，是请求生成一个实例，构造方法是私有的
 * 使用静态方法getInstance（）
 */
public class Singleton {
    //利用一个静态变量来记录Singleton类的唯一实例
    /*
    因为是静态变量，所以这个变量只有一个实例
     */
    private static Singleton uniqueInstance;

    //把构造器声明为私有的，只有自Singleton类内才能调用构造器
    private Singleton() {
    }

    public static Singleton getInstance() {/*用getInstance（）方法 实例化对象，并返回这个实例
        如果不需要这个实例，它拥有不会产生--延迟实例化
        */
        if (Singleton.uniqueInstance == null) {
            Singleton.uniqueInstance = new Singleton();
        }
        //Singleton是一个正常的嘞，具有其他实例变量和方法
        return Singleton.uniqueInstance;
    }
}
