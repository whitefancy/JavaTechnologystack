package designpattern.singletonpattern;

/**
 * 单例模式
 * <p>
 * 有些对象我们只需要一个 比如 线程池 缓存 对话框 处理偏好设置和注册表的对象
 * 日志对象 充当打印机、显卡等设备的驱动程序的对象
 * <p>
 * 确保只有一个实例会被创建
 * 提供方便的全局访问点
 * 需要时再创建，没有全局变量的缺点——没用到也一开始就启动
 */
public class SingletonTest {
    /*
    多个类加载器class loader 会各自创建自己的单件实现
    因为每个类加载器有自己的命名空间
    所以要指定一个类加载器来加载，并且每次要指定同一个

    垃圾回收会吃掉 只有自己引用自己的对象，所以1.2以前 要建立单件注册表
    但单件不会，所以java1.2之后就不会有这个bug

    单件 不仅管理自己的实例，还充当角色

    因为单件的构造器是私有的，所以严格的单件是不能继承的

    全局变量可以提供全局访问，但不能确保只有一个实例，比如被别的重写了
    而且会指向很多小对象污染命名空间

    单件模式 三要素 私有的构造器 一个静态方法 一个静态变量

    根据性能和资源限制 选择实现方案
    必须认定所有的程序都是多线程的
     */
    //第 1 种：懒汉式单例
    //public class LazySingleton
    //{
    //private static volatile LazySingleton instance=null; //保证 instance 在所有线程中同步
    //private LazySingleton(){} //private 避免类在外部被实例化
    //public static synchronized LazySingleton getInstance()
    //{
    ////getInstance 方法前加同步
    //if(instance==null)
    //{
    //instance=new LazySingleton();
    //}
    //return instance;
    //}
    //}
    //  public static LoginManager getInstance() {
    //    if (instance == null) {
    //      synchronized (LoginManager.class) {
    //        if (instance == null) {
    //          instance = new LoginManager();
    //        }
    //      }
    //    }
    //    return instance;
    //  }
    //    public static LoginRepository getInstance(LoginDataSource dataSource) {
    //        if (instance == null) {
    //            instance = new LoginRepository(dataSource);
    //        }
    //        return instance;
    //    }
    //懒汉模式加锁引起的性能问题
    //解决方案一：双重检查加锁（DCL）
    //public static Singleton getInstance() {
    //if (singleton == null) {//先验证对象是否创建
    //synchronized (Singleton.class) {//只有当对象未创建的时候才上锁
    //if (singleton == null) {
    //singleton = new Singleton();
    //}
    //}
    //}
    //return singleton;
    //}
    //解决方案二：用内部类实现懒汉模式
    //public class Singleton {
    //private Singleton() {}
    //public static Singleton getInstance() {
    //return SingletonHoler.singleton;
    //}
    ////定义静态内部类
    //private static class SingletonHoler {
    ////当内部类第一次访问时，创建对象实例
    //private static Singleton singleton = new Singleton();
    //}
    //}
    //静态内部类原理：
    //当外部内被访问时，并不会加载内部类，所以只要不访问SingletonHoler 这个内部类， private static Singleton singleton = new Singleton() 不会实例化，这就相当于实现懒加载的效果，只有当SingletonHoler.singleton 被调用时访问内部类的属性，此时才会将对象进行实例化，这样既解决了恶汉模式下可能造成资源浪费的问题，也避免了了懒汉模式下的并发问题。
    //第 2 种：饿汉式单例
    //public class HungrySingleton
    //{
    //private static final HungrySingleton instance=new HungrySingleton();
    //private HungrySingleton(){}
    //public static HungrySingleton getInstance()
    //{
    //return instance;
    //}}
    //其他单例实现方式
    //只有20%左右的人能够说出7种单例的实现，只有不到1%的人能够说出7种以上的单例实现。
    //可以问到很多知识点。比如线程安全、类加载机制、synchronized的原理、volatile的原理、指令重排与内存屏障、枚举的实现、反射与单例模式、序列化如何破坏单例、CAS、CAS的ABA问题、Threadlocal等知识。
    //类加载过程的线程安全性保证
    //以上的静态内部类、饿汉等模式均是通过定义静态的成员变量，以保证单例对象可以在类初始化的过程中被实例化。
    //这其实是利用了ClassLoader的线程安全机制。ClassLoader的loadClass方法在加载类的时候使用了synchronized关键字。
    //所以， 除非被重写，这个方法默认在整个装载过程中都是线程安全的。所以在类加载过程中对象的创建也是线程安全的。
    //枚举单例的线程安全问题
    //枚举其实底层是依赖Enum类实现的，这个类的成员变量都是static类型的，并且在静态代码块中实例化的，和饿汉有点像， 所以他天然是线程安全的。
    //所以，枚举其实也是借助了synchronized的。
    //完全不使用synchronized使用CAS实现单例
    //1、锁的实现原理；2、非锁，如CAS、ThreadLocal等）CAS是一项乐观锁技术，当多个线程尝试使用CAS同时更新一个变量时，只有其中一个线程能更新成功。
    //借助CAS（AtomicReference）实现单例模式：
    //public class Singleton {
    //private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<Singleton>();
    //private Singleton() {}
    //public static Singleton getInstance() {for (;;) {
    //Singleton singleton = INSTANCE.get();
    //if (null != singleton) {return singleton;
    //}
    //singleton = new Singleton();
    //if (INSTANCE.compareAndSet(null, singleton)) {
    //return singleton;
    //}
    //}
    //}}
    //用CAS的好处在于不需要使用传统的锁机制来保证线程安全，CAS是一种基于忙等待的算法，依赖底层硬件的实现，相对于锁它没有线程切换和阻塞的额外消耗，可以支持较大的并行度。
    //CAS的一个重要缺点在于如果忙等待一直执行不成功(一直在死循环中)，会对CPU造成较大的执行开销。
    //另外，代码中，如果N个线程同时执行到 singleton = new Singleton();的时候，会有大量对象被创建，可能导致内存溢出。
    //ThreadLoacal实现单例
    //ThreadLocal会为每一个线程提供一个独立的变量副本，从而隔离了多个线程对数据的访问冲突。对于多线程资源共享的问题，同步机制(synchronized)采用了“以时间换空间”的方式，而ThreadLocal采用了“以空间换时间”的方式。
    //同步机制仅提供一份变量，让不同的线程排队访问，而ThreadLocal为每一个线程都提供了一份变量，因此可以同时访问而互不影响。
    //Q：那理论上是不是可以使用ThreadLocal来实现单例呢？A：应该也是可行的。
    //使用ThreadLocal实现单例模式：
    //public class Singleton {
    //private static final ThreadLocal<Singleton> singleton =new ThreadLocal<Singleton>() {
    //@Overrideprotected
    //Singleton initialValue() {
    //return new Singleton();
    //}
    //};
    //public static Singleton getInstance() {
    //return singleton.get();
    //}
    //private Singleton() {}}
    //破坏单例与避免
    //单例模式其实是对外隐藏了构造函数，保证用户无法主动创建对象。但是实际上我们是有办法可以破坏他的。有一个比较简单的方式，那就是反射。
    //反射破坏单例
    //反射技术给我们提供了一个后门。
    //如下代码，我们通过反射的方式获取到Singleton的构造函数，设置其访问权限，然后通过该方法创建一个新的对象：
    //import java.lang.reflect.Constructor;public class SingletonTest {
    //public static void main(String[] args) { Singleton singleton = Singleton.getSingleton(); try { Class<Singleton> singleClass = (Class<Singleton>)Class.forName("com.dev.interview.Singleton");
    //Constructor<Singleton> constructor = singleClass.getDeclaredConstructor(null);
    //constructor.setAccessible(true);
    //Singleton singletonByReflect = constructor.newInstance();
    //System.out.println("singleton : " + singleton); System.out.println("singletonByReflect : " + singletonByReflect); System.out.println("singleton == singletonByReflect : " + (singleton == singletonByReflect)); } catch (Exception e) { e.printStackTrace(); } }}
    //输出结果为：
    //singleton : com.dev.interview.Singleton@55d56113singletonByReflect : com.dev.interview.Singleton@148080bbsingleton == singletonByReflect : false
    //如上，通过发射的方式即可获取到一个新的单例对象，这就破坏了单例。
    //避免破坏单例
    //只要我们在构造函数中加一些判断就行了。
    //如下方式，我们在Singleton的构造函数中增加如下代码：
    //private Singleton() { if (singleton != null) { throw new RuntimeException("Singleton constructor is called... "); }}
    //这样，在通过反射调用构造方法的时候，就会抛出异常：
    //Caused by: java.lang.RuntimeException: Singleton constructor is called...
    //通过序列化+反序列化的方式破坏单例
    //如以下代码，我们通过先将单例对象序列化后保存到临时文件中，然后再从临时文件中反序列化出来：
    //public class SingletonTest {
    //public static void main(String[] args) { Singleton singleton = Singleton.getSingleton();
    ////Write Obj to file ObjectOutputStream oos = null; try { oos = new ObjectOutputStream(new FileOutputStream("tempFile")); oos.writeObject(singleton); //Read Obj from file File file = new File("tempFile");
    //ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)); Singleton singletonBySerialize = (Singleton)ois.readObject(); //判断是否是同一个对象
    //System.out.println("singleton : " + singleton); System.out.println("singletonBySerialize : " + singletonBySerialize); System.out.println("singleton == singletonBySerialize : " + (singleton == singletonBySerialize));
    //} catch (Exception e) { e.printStackTrace(); } }}
    //输出结果如下：
    //singleton : com.dev.interview.Singleton@617faa95singletonBySerialize : com.dev.interview.Singleton@5d76b067singleton == singletonBySerialize : false
    //如上，通过先序列化再反序列化的方式，可获取到一个新的单例对象，这就破坏了单例。
    //因为在对象反序列化的过程中，序列化会通过反射调用无参数的构造方法创建一个新的对象，所以，通过反序列化也能破坏单例。
    //避免反序列化破坏单例
    //修改下反序列化策略。只需要在Sinleton中增加readResolve方法，并在该方法中指定要返回的对象的生成策略几可以了。即序列化在Singleton类中增加以下代码即可：
    //private Object readResolve() { return getSingleton();}
    //因为反序列化过程中，在反序列化执行过程中会执行到ObjectInputStream#readOrdinaryObject方法，这个方法会判断对象是否包含readResolve方法，如果包含的话会直接调用这个方法获得对象实例。
}
