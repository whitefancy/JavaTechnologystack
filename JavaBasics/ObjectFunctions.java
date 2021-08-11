package JavaBasics;

public class ObjectFunctions {
    public static void test() {
        // toString
        // dfss 实现了toString方法
        String s1 = "dfss";
        Object o = s1;
        String s = o.toString();
        System.out.println(s);
        //JavaBasics.Person@1540e19d 没有实现toString方法 返回 类名@hashCode
        Person p = new Person("d");
        s = p.toString();
        System.out.println(s);

        // equals ==
        // 基本类型可以用==
        // 引用类型必须用equals
        String s2 = new String("hello");
        // 这里一共产生了两个字符串对象。
        // 第一个hello是直接量，在常量池里
        // 第二个使用常量池的直接量构造String对象，保存到堆里
        boolean k = s2 == "hello"; //false
        System.out.println(k);
    }
    //Note：friendly 型：如果一个类、类属变量及方法不以public,protected,private这三种修饰符来修饰，它就是friendly类型的，
    // 那么包内的任何类都可以访问它，而包外的任何类都不能访问它(包括包外继承了此类的子类)，
    // 因此，这种类、类属变量及方法对包内的其他类是友好的，开放的，而对包外的其他类是关闭的。
    //Java 8的接口，即便有了default method，还暂时无法完全替代抽象类。它不能拥有状态，只能提供公有虚方法的默认实现。Java 9的接口已经可以有非公有的静态方法了。未来的Java版本的接口可能会有更强的功能，或许能更大程度地替代原本需要使用抽象类的场景。例如说以前大家用ActionListener常常要傻乎乎地为一大堆方法提供空实现，如果 ActionListener 接口为所有方法都提供空的默认实现，就没这么蛋疼了，也不需要自己写个全部实现都是空方法的抽象类了。
    //首先呢，接口的default methods只能是public。抽象类的abstract method可以是protected。
}
