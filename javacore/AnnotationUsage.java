package javacore;

import java.lang.annotation.*;

public class AnnotationUsage {
    //Java 注解（Annotation）
    //Java 注解（Annotation）又称 Java 标注，是 JDK5.0 引入的一种注释机制。
    //Java 语言中的类、方法、变量、参数和包等都可以被标注。和 Javadoc 不同，Java 标注可以通过反射获取标注内容。在编译器生成类文件时，标注可以被嵌入到字节码中。Java 虚拟机可以保留标注内容，在运行时可以获取到标注内容 。 当然它也支持自定义 Java 标注。
    //内置的注解
    //Java 定义了一套注解，共有 7 个，3 个在 java.lang 中，剩下 4 个在 java.lang.annotation 中。
    //作用在代码的注解是
    //@Override
    //检查该方法是否是重写方法。如果发现其父类，或者是引用的接口中并没有该方法时，会报编译错误。
    //@Deprecated
    //- 标记过时方法。如果使用该方法，会报编译警告。
    //@SuppressWarnings
    //- 指示编译器去忽略注解中声明的警告。
    //作用在其他注解的注解(或者说 元注解)是:
    //@Retention
    //- 标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问。
    //@Documented
    //- 标记这些注解是否包含在用户文档中。
    //@Target
    //标记这个注解应该是哪种 Java 成员。
    //@Inherited
    //标记这个注解是继承于哪个注解类(默认 注解并没有继承于任何子类)
    //从 Java 7 开始，额外添加了 3 个注解:
    //@SafeVarargs
    //- Java 7 开始支持，忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告。
    //@FunctionalInterface
    //Java 8 开始支持，标识一个匿名函数或函数式接口。
    //函数式接口注解，这个是 Java 1.8 版本引入的新特性。函数式编程很火，所以 Java 8 也及时添加了这个特性。
    //函数式接口 (Functional Interface) 就是一个具有一个方法的普通接口。
    //比如
    //@FunctionalInterface
    //public interface Runnable {
    ///**
    //* When an object implementing interface <code>Runnable</code> is used
    //* to create a thread, starting the thread causes the object's
    //* <code>run</code> method to be called in that separately executing
    //* thread.
    //* <p>
    //* The general contract of the method <code>run</code> is that it may
    //* take any action whatsoever.
    //*
    //* @see java.lang.Thread#run()
    //*/
    //public abstract void run();
    //}
    //1
    //我们进行线程开发中常用的 Runnable 就是一个典型的函数式接口，上面源码可以看到它就被 @FunctionalInterface 注解。
    //可能有人会疑惑，函数式接口标记有什么用，这个原因是函数式接口可以很容易转换为 Lambda 表达式。
    //@Repeatable
    //Java 8 开始支持，标识某注解可以在同一个声明上使用多次。

    /**
     * 自定义的Annotation。     自定义注解
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface Inheritable {
    }

    @Inheritable
    class InheritableFather {
        public InheritableFather() {
// InheritableBase是否具有 Inheritable Annotation
            System.out.println("InheritableFather:" + InheritableFather.class.isAnnotationPresent(Inheritable.class));
        }
    }
//注解的定义
//注解通过 @interface 关键字进行定义。
//public @interface TestAnnotation {
//}
//1
//它的形式跟接口很类似，不过前面多了一个 @ 符号。上面的代码就创建了一个名字为 TestAnnotaion 的注解。
//你可以简单理解为创建了一张名字为 TestAnnotation 的标签。
//注解的应用
//上面创建了一个注解，那么注解的的使用方法是什么呢。
//@TestAnnotation
//public class Test {
//}
//1
//创建一个类 Test,然后在类定义的地方加上 @TestAnnotation 就可以用 TestAnnotation 注解这个类了。
//你可以简单理解为将 TestAnnotation 这张标签贴到 Test 这个类上面。
//所有的注解类型都继承自这个普通的接口（Annotation）
//这句话有点抽象，但却说出了注解的本质。我们看一个 JDK 内置注解的定义：
//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.SOURCE)
//public @interface Override {
//}
//这是注解 @Override 的定义，其实它本质上就是：
//public interface Override extends Annotation{
//}
//解的本质就是一个继承了 Annotation 接口的接口。有关这一点，你可以去反编译任意一个注解类，你会得到结果的。

    //元注解
    //元注解是什么意思呢？
    //元注解是可以注解到注解上的注解，或者说元注解是一种基本注解，但是它能够应用到其它的注解上面。
    //如果难于理解的话，你可以这样理解。元注解也是一张标签，但是它是一张特殊的标签，它的作用和目的就是给其他普通的标签进行解释说明的。
    //元标签有 @Retention、@Documented、@Target、@Inherited、@Repeatable 5 种。
    //@Retention
    //Retention 的英文意为保留期的意思。当 @Retention 应用到一个注解上的时候，它解释说明了这个注解的的存活时间。
    //它的取值如下：
    //RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
    //RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
    //RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。
    //我们可以这样的方式来加深理解，@Retention 去给一张标签解释的时候，它指定了这张标签张贴的时间。@Retention 相当于给一张标签上面盖了一张时间戳，时间戳指明了标签张贴的时间周期。
    //@Retention(RetentionPolicy.RUNTIME)
    //public @interface TestAnnotation {
    //}
    //1
    //上面的代码中，我们指定 TestAnnotation 可以在程序运行周期被获取到，因此它的生命周期非常的长。
    //@Documented
    //顾名思义，这个元注解肯定是和文档有关。它的作用是能够将注解中的元素包含到 Javadoc 中去。
    //@Target
    //Target 是目标的意思，@Target 指定了注解运用的地方。
    //你可以这样理解，当一个注解被 @Target 注解时，这个注解就被限定了运用的场景。
    //类比到标签，原本标签是你想张贴到哪个地方就到哪个地方，但是因为 @Target 的存在，它张贴的地方就非常具体了，比如只能张贴到方法上、类上、方法参数上等等。@Target 有下面的取值
    //ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
    //ElementType.CONSTRUCTOR 可以给构造方法进行注解
    //ElementType.FIELD 可以给属性进行注解
    //ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
    //ElementType.METHOD 可以给方法进行注解
    //ElementType.PACKAGE 可以给一个包进行注解
    //ElementType.PARAMETER 可以给一个方法内的参数进行注解
    //ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
    //@Inherited
    //Inherited 是继承的意思，但是它并不是说注解本身可以继承，而是说如果一个超类被 @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解。
    //说的比较抽象。代码来解释。
    //@Inherited
    //@Retention(RetentionPolicy.RUNTIME)
    //@interface Test {}
    //@Test
    //public class A {}
    //public class B extends A {}
    //1
    //注解 Test 被 @Inherited 修饰，之后类 A 被 Test 注解，类 B 继承 A,类 B 也拥有 Test 这个注解。
    //@Repeatable
    //Repeatable 自然是可重复的意思。@Repeatable 是 Java 1.8 才加进来的，所以算是一个新的特性。
    //什么样的注解会多次应用呢？通常是注解的值可以同时取多个。
    //举个例子，一个人他既是程序员又是产品经理,同时他还是个画家。
    //@interface Persons {
    //Person[] value();
    //}
    //@Repeatable(Persons.class)
    //@interface Person{
    //String role default "";
    //}
    //@Person(role="artist")
    //@Person(role="coder")
    //@Person(role="PM")
    //public class SuperMan{
    //}
    //1
    //注意上面的代码，@Repeatable 注解了 Person。而 @Repeatable 后面括号中的类相当于一个容器注解。

//容器注解
//什么是容器注解呢？就是用来存放其它注解的地方。它本身也是一个注解。
//我们再看看代码中的相关容器注解。
//@interface Persons {
//Person[] value();
//}
//1
//按照规定，它里面必须要有一个 value 的属性，属性类型是一个被 @Repeatable 注解过的注解数组，注意它是数组。
//如果不好理解的话，可以这样理解。Persons 是一张总的标签，上面贴满了 Person 这种同类型但内容不一样的标签。把 Persons 给一个 SuperMan 贴上，相当于同时给他贴了程序员、产品经理、画家的标签。
//我们可能对于 @Person(role=”PM”) 括号里面的内容感兴趣，它其实就是给 Person 这个注解的 role 属性赋值为 PM ，大家不明白正常，马上就讲到注解的属性这一块。
//注解的属性
//注解的属性也叫做成员变量。注解只有成员变量，没有方法。注解的成员变量在注解的定义中以“无形参的方法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
//public @interface TestAnnotation {
//int id();
//String msg();
//}
//1
//上面代码定义了 TestAnnotation 这个注解中拥有 id 和 msg 两个属性。在使用的时候，我们应该给它们进行赋值。
//赋值的方式是在注解的括号内以 value=”” 形式，多个属性之前用 ，隔开。
//@TestAnnotation(id=3,msg="hello annotation")
//public class Test {
//}
//1
//需要注意的是，在注解中定义属性时它的类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组。
//注解中属性可以有默认值，默认值需要用 default 关键值指定。比如：
//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
//public @interface TestAnnotation {
//public int id() default -1;
//public String msg() default "Hi";
//}
//1
//TestAnnotation 中 id 属性默认值为 -1，msg 属性默认值为 Hi。
//它可以这样应用。
//@TestAnnotation()
//public class Test {}
//1
//因为有默认值，所以无需要再在 @TestAnnotation 后面的括号里面进行赋值了，这一步可以省略。
//另外，还有一种情况。如果一个注解内仅仅只有一个名字为 value 的属性时，应用这个注解时可以直接接属性值填写到括号内。
//public @interface Check {
//String value();
//}
//1
//上面代码中，Check 这个注解只有 value 这个属性。所以可以这样应用。
//@Check("hi")
//int a;
//1
//这和下面的效果是一样的
//@Check(value="hi")
//int a;
//1
//最后，还需要注意的一种情况是一个注解没有任何属性。比如
//public @interface Perform {}
//1
//那么在应用这个注解的时候，括号都可以省略。
//@Perform
//public void testMethod(){}
//注解的提取
//注解通过反射获取。首先可以通过 Class 对象的 isAnnotationPresent() 方法判断它是否应用了某个注解
//public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {}
//1
//然后通过 getAnnotation() 方法来获取 Annotation 对象。
//public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {}
//1
//或者是 getAnnotations() 方法。
//public Annotation[] getAnnotations() {}
//1
//前一种方法返回指定类型的注解，后一种方法返回注解到这个元素上的所有注解。
//如果获取到的 Annotation 如果不为 null，则就可以调用它们的属性方法了。比如
//@TestAnnotation()
//public class Test {
//public static void main(String[] args) {
//boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
//if ( hasAnnotation ) {
//TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
//System.out.println("id:"+testAnnotation.id());
//System.out.println("msg:"+testAnnotation.msg());
//}
//}
//}
//1
//程序的运行结果是：
//id:-1
//msg:
//1
//这个正是 TestAnnotation 中 id 和 msg 的默认值。
//上面的例子中，只是检阅出了注解在类上的注解，其实属性、方法上的注解照样是可以的。同样还是要假手于反射。
//@TestAnnotation(msg="hello")
//public class Test {
//@Check(value="hi")
//int a;
//@Perform
//public void testMethod(){}
//@SuppressWarnings("deprecation")
//public void test1(){
//Hero hero = new Hero();
//hero.say();
//hero.speak();
//}
//public static void main(String[] args) {
//boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
//if ( hasAnnotation ) {
//TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
////获取类的注解
//System.out.println("id:"+testAnnotation.id());
//System.out.println("msg:"+testAnnotation.msg());
//}
//try {
//Field a = Test.class.getDeclaredField("a");
//a.setAccessible(true);
////获取一个成员变量上的注解
//Check check = a.getAnnotation(Check.class);
//if ( check != null ) {
//System.out.println("check value:"+check.value());
//}
//Method testMethod = Test.class.getDeclaredMethod("testMethod");
//if ( testMethod != null ) {
//// 获取方法中的注解
//Annotation[] ans = testMethod.getAnnotations();
//for( int i = 0;i < ans.length;i++) {
//System.out.println("method testMethod annotation:"+ans[i].annotationType().getSimpleName());
//}
//}
//} catch (NoSuchFieldException e) {
//// TODO Auto-generated catch block
//e.printStackTrace();
//System.out.println(e.getMessage());
//} catch (SecurityException e) {
//// TODO Auto-generated catch block
//e.printStackTrace();
//System.out.println(e.getMessage());
//} catch (NoSuchMethodException e) {
//// TODO Auto-generated catch block
//e.printStackTrace();
//System.out.println(e.getMessage());
//}
//}
//}
//1
//它们的结果如下：
//id:-1
//msg:hello
//check value:hi
//method testMethod annotation:Perform
//1
//需要注意的是，如果一个注解要在运行时被成功提取，那么 @Retention(RetentionPolicy.RUNTIME) 是必须的。
//之前我们说过，虚拟机规范定义了一系列和注解相关的属性表，也就是说，无论是字段、方法或是类本身，如果被注解修饰了，就可以被写进字节码文件。属性表有以下几种：
//RuntimeVisibleAnnotations：运行时可见的注解
//RuntimeInVisibleAnnotations：运行时不可见的注解
//RuntimeVisibleParameterAnnotations：运行时可见的方法参数注解
//RuntimeInVisibleParameterAnnotations：运行时不可见的方法参数注解
//AnnotationDefault：注解类元素的默认值
//给大家看虚拟机的这几个注解相关的属性表的目的在于，让大家从整体上构建一个基本的印象，注解在字节码文件中是如何存储的。
//所以，对于一个类或者接口来说，Class 类中提供了以下一些方法用于反射注解。
//getAnnotation：返回指定的注解
//isAnnotationPresent：判定当前元素是否被指定注解修饰
//getAnnotations：返回所有的注解
//getDeclaredAnnotation：返回本元素的指定注解
//getDeclaredAnnotations：返回本元素的所有注解，不包含父类继承而来的
//方法、字段中相关反射注解的方法基本是类似的，这里不再赘述，我们下面看一个完整的例子。
//首先，设置一个虚拟机启动参数，用于捕获 JDK 动态代理类。
//-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
//我们说过，注解本质上是继承了 Annotation 接口的接口，而当你通过反射，也就是我们这里的 getAnnotation 方法去获取一个注解类实例的时候，其实 JDK 是通过动态代理机制生成一个实现我们注解（接口）的代理类。
//我们运行程序后，会看到输出目录里有这么一个代理类，代理类实现接口 Hello 并重写其所有方法，包括 value 方法以及接口 Hello 从 Annotation 接口继承而来的方法。
}
