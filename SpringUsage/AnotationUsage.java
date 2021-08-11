package SpringUsage;

public class AnotationUsage {
    //Spring注解汇总
    //什么是基于Java的Spring注解配置? 给一些注解的例子.
    //基于Java的配置，允许你在少量的Java注解的帮助下，进行你的大部分Spring配置而非通过XML文件。
    //以@Configuration 注解为例，它用来标记类可以当做一个bean的定义，被Spring IOC容器使用。另一个例子是@Bean注解，它表示此方法将要返回一个对象，作为一个bean注册进Spring应用上下文。
    //什么是基于注解的容器配置?
    //相对于XML文件，注解型的配置依赖于通过字节码元数据装配组件，而非尖括号的声明。
    //开发者通过在相应的类，方法或属性上使用注解的方式，直接组件类中进行配置，而不是使用xml表述bean的装配关系。
    //怎样开启注解装配？
    //注解装配在默认情况下是不开启的，为了使用注解装配，我们必须在Spring配置文件中配置 <context:annotation-config/>元素。
    //声明bean的注解
    //Spring注解	描述
    //@Component
    //通用的注解，可标注任意类为 Spring 组件。如果一个Bean不知道属于哪个层，可以使用@Component 注解标注。
    //@Repository	在展现层使用，控制器的声明（C）对应持久层即 Dao 层，主要用于数据库相关操作。
    //@Service	在业务逻辑层使用（service层）对应服务层，主要涉及一些复杂的逻辑，需要用到 Dao层。
    //@Controller	对应 Spring MVC 控制层，主要用户接受用户请求并调用 Service 层返回数据给前端页面。
    //2.注入bean的注解
    //Spring注解	描述
    //@Autowired	Spring提供的工具（由Spring的依赖注入工具（BeanPostProcessor、BeanFactoryPostProcessor）自动注入。）
    //@Inject	由JSR-330提供
    //@Resource	由JSR-250提供
    //@Required 注解	这个注解表明bean的属性必须在配置的时候设置，通过一个bean定义的显式的属性值或通过自动装配，若@Required注解的bean属性未被设置，容器将抛出BeanInitializationException。
    //@Autowired 	注解提供了更细粒度的控制，包括在何处以及如何完成自动装配。它的用法和@Required一样，修饰setter方法、构造器、属性或者具有任意名称和/或多个参数的PN方法。
    //@Qualifier 注解	当有多个相同类型的bean却只有一个需要自动装配时，将@Qualifier 注解和@Autowire 注解结合使用以消除这种混淆，指定需要装配的确切的bean。
    //
    //3.java配置类相关注解
    //Spring注解	描述
    //@Bean	注解在方法上，声明当前方法的返回值为一个bean，替代xml中的方式（方法上）
    //@Configuration	声明当前类为配置类，相当于xml形式的Spring配置（类上），其中内部组合了@Component注解，表明这个类是一个bean（类上）
    //@ComponentScan	用于对Component进行扫描，相当于xml中的context:component-scan（类上）
    //@WishlyConfiguration	为@Configuration与@ComponentScan的组合注解，可以替代这两个注解
    //4.切面（AOP）相关注解
    //Spring注解	描述
    //@Aspect	声明一个切面（类上）,使用@After、@Before、@Around定义建言（advice），可直接将拦截规则（切点）作为参数。
    //@After	在方法执行之后执行（方法上）
    //@Before	在方法执行之前执行（方法上）
    //@Around	在方法执行之前与之后执行（方法上）
    //@PointCut	声明切点, 在java配置类中使用@EnableAspectJAutoProxy注解开启Spring对AspectJ代理的支持（类上）
    //5.@Bean的属性支持
    //Spring注解	描述
    //@Scope	设置Spring容器如何新建Bean实例（方法上，得有@Bean）
    //其设置类型包括：Singleton （单例,一个Spring容器中只有一个bean实例，默认模式）,
    //Protetype （每次调用新建一个bean）,
    //Request （web项目中，给每个http request新建一个bean）,
    //Session （web项目中，给每个http session新建一个bean）,
    //GlobalSession（给每一个 global http session新建一个Bean实例）
    //@StepScope	在Spring Batch中还有涉及
    //@PostConstruct	由JSR-250提供，在构造函数执行完之后执行，等价于xml配置文件中bean的initMethod
    //@PreDestory	由JSR-250提供，在Bean销毁之前执行，等价于xml配置文件中bean的destroyMethod
    //6.@Value注解
    //@Value 为属性注入值（属性上）
    //@Value的优先级比构造函数要高
    //7.环境切换
    //Spring注解	描述
    //@Profile	通过设定Environment的ActiveProfiles来设定当前context需要使用的配置环境。（类或方法上）
    //@Conditional	Spring4中可以使用此注解定义条件话的bean，通过实现Condition接口，并重写matches方法，从而决定该bean是否被实例化。（方法上）
    //8.异步相关
    //Spring注解	描述
    //@EnableAsync	配置类中，通过此注解开启对异步任务的支持，叙事性AsyncConfigurer接口（类上）
    //@Async	在实际执行的bean方法使用该注解来申明其是一个异步任务（方法上或类上所有的方法都将异步，需要@EnableAsync开启异步任务）
    //9.定时任务相关
    //Spring注解	描述
    //@EnableScheduling	在配置类上使用，开启计划任务的支持（类上）
    //@Scheduled	来申明这是一个任务，包括cron,fixDelay,fixRate等类型（方法上，需先开启计划任务的支持）
    //10.@Enable*注解说明
    //这些注解主要用来开启对xxx的支持。
    //Spring注解	描述
    //@EnableAspectJAutoProxy	开启对AspectJ自动代理的支持
    //@EnableAsync	开启异步方法的支持
    //@EnableScheduling	开启计划任务的支持
    //@EnableWebMvc	开启Web MVC的配置支持
    //@EnableConfigurationProperties	开启对@ConfigurationProperties注解配置Bean的支持
    //@EnableJpaRepositories	开启对SpringData JPA Repository的支持
    //@EnableTransactionManagement	开启注解式事务的支持
    //@EnableCaching	开启注解式的缓存支持
    //11.测试相关注解
    //Spring注解	描述
    //@RunWith	运行器，Spring中通常用于对JUnit的支持
    //@ContextConfiguration	用来加载配置ApplicationContext，其中classes属性用来加载配置类
    //12.SpringMVC部分
    //上一部分的注解是Spring的注解，这一部分的注解是SpringMVC的注解
    //SpringMVC注解	描述
    //@EnableWebMvc	在配置类中开启Web MVC的配置支持，如一些ViewResolver或者MessageConverter等，若无此句，重写WebMvcConfigurerAdapter方法（用于对SpringMVC的配置）。
    //@Controller	声明该类为SpringMVC中的Controller
    //@RequestMapping	用于映射Web请求，包括访问路径和参数（类或方法上）
    //@ResponseBody	支持将返回值放在response内，而不是一个页面，通常用户返回json数据（返回值旁或方法上）
    //@RequestBody	允许request的参数在request体中，而不是在直接连接在地址后面。（放在参数前）
    //@PathVariable	用于接收路径参数，比如@RequestMapping(“/hello/{name}”)申明的路径，将注解放在参数中前，即可获取该值，通常作为Restful的接口实现方法。
    //@RestController	该注解为一个组合注解，相当于@Controller和@ResponseBody的组合，注解在类上，意味着，该Controller的所有方法都默认加上了@ResponseBody。
    //@ControllerAdvice	通过该注解，我们可以将对于控制器的全局配置放置在同一个位置，注解了@Controller的类的方法可使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上， 这对所有注解了 @RequestMapping的控制器内的方法有效。
    //@ExceptionHandler	用于全局处理控制器里的异常
    //@InitBinder	用来设置WebDataBinder，WebDataBinder用来自动绑定前台请求参数到Model中。
    //@ModelAttribute	本来的作用是绑定键值对到Model里，在@ControllerAdvice中是让全局的@RequestMapping都能获得在此处设置的键值对。
    //注解
    //@Before("execytion(...)")
    //注解到表示方面的方法上
    //@PointCut
    //注解到声明为public void的空方法上
    //@PointCut("execution(public * * (..)")
    //public void anyPublicMethod(){}
    //该方法将被作为配置，用于对@Before（参数）参数的重写
    //@Before("anyPublicMethod()")
    //将切入点绑定到所定义的通知上
    //可以与boolean运算符结合，创建更大的切入点
    //@After
    //@AfterReturning
    //@AfterThrowing
    //@Aspect
    //注解到含有通知的类上
    //同时该类@Component注解
    //@Around
    //@DeclareParents
    //引入：通过提供接口的具体类而让目标动态地实现该接口
    //从而让路径在Java中实现“多重继承”
    //AspectJ融合Spring
}
