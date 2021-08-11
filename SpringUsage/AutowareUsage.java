package SpringUsage;

public class AutowareUsage {
    //自动装配
    //三种模式
    //byType
    //byName
    //constructor
    //autowiring 让Spring容器自动地向Bean中注入依赖项
    //容器中没有候选Bean，默认属性值保持不变（null）
    //注解
    //@Autowired
    //不必向@Bean注解添加autowire特性，也可以触发自动装配
    //如果有多个选项，注入将会失败
    //字段上放置@Autowired注解，就不需要编写Setter方法
    //Spring容器借助于Java反射API进行直接字段访问，完成依赖注入
    //@Qualifier
    //接收一个String值，通过该值可以更改默认的限定值（默认值为Bean的名称）
    //根据不同的限定值，可以自动装配名称和属性名称并不匹配的其他类
    //自动装配模式变为byName
    //自动装配仅适用于对其他Bean的依赖，不适用于纯粹值
    //值用@Value()注解
    //@Value还可以用于表达式驱动的依赖注入
    //什么是bean wiring？
    //Wiring，或者说bean Wiring是指beans在Spring容器中结合在一起的情况。当装配bean的时候，Spring容器需要知道需要哪些beans以及如何使用依赖注入将它们结合起来。
    //Spring基于xml注入bean的几种方式：
    //（1）Set方法注入；
    //（2）构造器注入：①通过index设置参数的位置；②通过type设置参数类型；
    //（3）静态工厂注入；
    //（4）实例工厂；
    //Spring的自动装配：
    //在spring中，对象无需自己查找或创建与其关联的其他对象，由容器负责把需要相互协作的对象引用赋予各个对象，使用autowire来配置自动装载模式。
    //在Spring框架xml配置中共有5种自动装配：
    //（1）no：默认的方式是不进行自动装配的，通过手工设置ref属性来进行装配bean。
    //（2）byName：通过bean的名称进行自动装配，如果一个bean的 property 与另一bean 的name 相同，就进行自动装配。
    //（3）byType：通过参数的数据类型进行自动装配。
    //（4）constructor：利用构造函数进行装配，并且构造函数的参数通过byType进行装配。
    //（5）autodetect：自动探测，如果有构造方法，通过 construct的方式自动装配，否则使用 byType的方式自动装配。
    //基于注解的方式：
    //使用@Autowired注解来自动装配指定的bean。在使用@Autowired注解之前需要在Spring配置文件进行配置，<context:annotation-config />。在启动spring IoC时，容器自动装载了一个AutowiredAnnotationBeanPostProcessor后置处理器，当容器扫描到@Autowied、@Resource或@Inject时，就会在IoC容器自动查找需要的bean，并装配给该对象的属性。在使用@Autowired时，首先在容器中查询对应类型的bean：
    //如果查询结果刚好为一个，就将该bean装配给@Autowired指定的数据；
    //如果查询的结果不止一个，那么@Autowired会根据名称来查找；
    //如果上述查找的结果为空，那么会抛出异常。解决方法时，使用required=false。
    //@Autowired可用于：构造函数、成员变量、Setter方法
    //注：@Autowired和@Resource之间的区别
    //(1) @Autowired默认是按照类型装配注入的，默认情况下它要求依赖对象必须存在（可以设置它required属性为false）。
    //(2) @Resource默认是按照名称来装配注入的，只有当找不到与名称匹配的bean才会按照类型来装配注入。
    //有五种自动装配的方式，可以用来指导Spring容器用自动装配方式来进行依赖注入。
    //no：默认的方式是不进行自动装配，通过显式设置ref 属性来进行装配。
    //byName：通过参数名 自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byname，之后容器试图匹配、装配和该bean的属性具有相同名字的bean。
    //byType:：通过参数类型自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byType，之后容器试图匹配、装配和该bean的属性具有相同类型的bean。如果有多个bean符合条件，则抛出错误。
    //constructor：这个方式类似于byType， 但是要提供给构造器参数，如果没有确定的带参数的构造器参数类型，将会抛出异常。
    //autodetect：首先尝试使用constructor来自动装配，如果无法工作，则使用byType方式。
    //自动装配有哪些局限性 ?
    //自动装配的局限性是：
    //重写： 你仍需用 <constructor-arg>和 <property> 配置来定义依赖，意味着总要重写自动装配。
    //基本数据类型：你不能自动装配简单的属性，如基本数据类型，String字符串，和类。
    //模糊特性：自动装配不如显式装配精确，如果有可能，建议使用显式装配。
}
