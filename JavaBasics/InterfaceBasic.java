package JavaBasics;

//多重继承的冲突说明：
//由于同一个方法可以从不同接口引入，自然而然的会有冲突的现象，规则如下：
//1）一个声明在类里面的方法优先于任何默认方法
//2）优先选取最具体的实现
//接口的静态方法
//接口里可以声明静态方法，并且可以实现。
//eg：
//private interface DefaulableFactory {
//// Interfaces now allow static methods
//static Defaulable create(Supplier< Defaulable > supplier ) {
//return supplier.get();
//}
//}
//当实现类实现的多个接口中，有方法签名相同的default方法时，必须重写该方法；
//default方法，也可称为Defender方法，或者虚拟拓展方法(Virtual extension methods)。
//三定律
//类优先级高于接口。如果在继承链中有方法体或抽象的方法声明，那么就可以忽略接口中定义的方法。
//子类优先级高于父类。如果一个接口继承了另一个接口，且两个接口都定义了一个默认方法，那么子类中定义的方法胜出。
//如果上面两条规则都不适用，子类要么需要实现该方法，要么将该方法声明为抽象方法。
//在接口中定义方法的诸多变化引发了一系列问题。
public interface InterfaceBasic {
    // 抽象
    // 定义了某一批嘞所需要遵守的规范
    // 不提供任何实现 体现了规范和实现分类的设计哲学

    // 接口只能继承接口，不能继承类
    // 接口支持多继承

    public abstract void test();// 只能用public abstract修饰 不能有方法体

    int max = 33;// 实际上 等同于public static final int

    public abstract void java8();

    // 允许在接口中定义默认方法
//JVM平台的接口的默认方法实现是很高效的，并且方法调用的字节码指令支持默认方法。默认方法使已经存在的接口可以修改而不会影响编译的过程。java.util.Collection中添加的额外方法就是最好的例子：stream(), parallelStream(), forEach(), removeIf()
//虽然默认方法很强大，但是使用之前一定要仔细考虑是不是真的需要使用默认方法，因为在层级很复杂的情况下很容易引起模糊不清甚至变异错误。
    public static void main(String[] args) {
//        接口是对类的一组需求描述，可以使用instanceof检查是否实现了特定接口。
//        接口中可以包含常量。接口中的方法被自动设为public，接口中的域被自动设为public static final。
//        回调 ActionListener接口
//        可以指定某个特定时间发生时应该采取的动作
//        void actionPerformed(ActionEvent event);
//        ActionListener listener = new TimePrinter();
//        Timer t = new Timer(10000, listener);
//        Comparator接口
//        sort要实现Comparable接口，给出CompareTo方法

        //Cloneable接口
        //指示一个类提供了一个安全的clone方法
        //Object.clone提供浅copy
        //建立深复制需要clone对象中可变的实例域
        //解决默认方法冲突
        //接口与超类冲突，超类优先
        //接口冲突
        //必须覆盖方法
        //程序员指定
        //Person.super.getName（）
        //Lambda表达式
        //interface的static方法
        //Java 8 对接口做了进一步的增强。
        //接口中可以定义static方法，可通过接口名称.方法名（）调用，实现类不能继承static方法；
        //a. 在接口中可以添加使用 default 关键字修饰的非抽象方法。即：默认方法（或扩展方法）
        //b. 接口里可以声明静态方法，并且可以实现。
    }
}
