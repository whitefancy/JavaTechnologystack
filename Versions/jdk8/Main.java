package Versions.jdk8;

public class Main {
    public static void main(String[] args) {
//JDK1.8的新特性
//一、接口添加默认方法 default关键字
//Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法。
//二、Lambda 表达式 (String a, String b) -> {
//在Java 8 中你就没必要使用这种传统的匿名对象的方式了，Java 8提供了更简洁的语法，lambda表达式：
//Collections.sort(names, (String a, String b) -> {
//return b.compareTo(a);
//});
//三、函数式接口
//Lambda表达式是如何在java的类型系统中表示的呢？每一个lambda表达式都对应一个类型，通常是接口类型。而“函数式接口”是指仅仅只包含一个抽象方法的接口，每一个该类型的lambda表达式都会被匹配到这个抽象方法。因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。
//四、使用 :: 关键字来传递方法或者构造函数引用
//Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用，上面的代码展示了如何引用一个静态方法，我们也可以引用一个对象的方法：
//converter = something::startsWith;
//String converted = converter.convert("Java");
//System.out.println(converted);
//五、Lambda 作用域 直接访问标记了final的外层局部变量，或者实例的字段以及静态变量
//在lambda表达式中访问外层作用域和老版本的匿名对象中的方式很相似。你可以直接访问标记了final的外层局部变量，或者实例的字段以及静态变量。
//六、直接在lambda表达式中访问局部变量
//可以直接在lambda表达式中访问外层的局部变量：
//七、lambda内部访问对象字段与静态变量 可读又可写
//和本地变量不同的是，lambda内部对于实例的字段以及静态变量是即可读又可写。该行为和匿名对象是一致的。
//八、内建的函数式接口增加了@FunctionalInterface注解以便能用在lambda
//JDK 1.8 API包含了很多内建的函数式接口，在老Java中常用到的比如Comparator或者Runnable接口，这些接口都增加了@FunctionalInterface注解以便能用在lambda上。
//Java 8 API同样还提供了很多全新的函数式接口来让工作更加方便，有一些接口是来自Google Guava库里的，即便你对这些很熟悉了，还是有必要看看这些是如何扩展到lambda上使用的。
    }


}
