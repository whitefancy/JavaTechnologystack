package SpringUsage;

public class SpringMVCUsage {
    //SpringMVC项目分层
    //实体层：bean、pojo等
    //用途：和数据库的实体保持一致。
    //数据访问层：dao层，以及dao层的实现类
    //DAO层主要是做数据持久层的工作，负责与数据库进行联络的一些任务都封装在此，DAO层的设计首先是设计DAO的接口，然后在Spring的配置文件中定义此接口的实现类，然后就可在模块中调用此接口来进行数据业务的处理，而不用关心此接口的具体实现类是哪个类，显得结构非常清晰，DAO层的数据源配置，以及有关数据库连接的参数都在Spring的配置文件中进行配置。
    //业务层：service层，以及service的实现类
    //具体用途：Service层主要负责业务模块的逻辑应用设计。同样是首先设计接口，再设计其实现的类，接着再Spring的配置文件中配置其实现的关联。这样我们就可以在应用中调用Service接口来进行业务处理。Service层的业务实现，具体要调用到已定义的DAO层的接口，封装Service层的业务逻辑有利于通用的业务逻辑的独立性和重复利用性，程序显得非常简洁。
    //controller层：控制层负责页面跳转，是无工作流的简单请求处理器，用于处理完成XHTML表单生命周期的表单控制器，向导控制器，提供多页面工作流，WebWork风格的一次性控制器，灵活的，多个动作的控制器。
    //Controller故意设计成单例，像Servlet一样。作为单例，他们可以处理并发的请求，因此不需要在每个请求中维持状态。
    //domain层：存放实体，如果用ibatis框架，一般mapping创建在它下面
    //Utils层：util功能包，针对本项目工具类。
    //common层：common通用工具包，一般一个公司会有固定的jar，好几个项目通用的，例如远程调用等。
    //@RestController vs @Controller
    //单独使用 @Controller 不加 @ResponseBody的话一般使用在要返回一个视图的情况，这种情况属于比较传统的Spring MVC 的应用，对应于前后端不分离的情况。
    //@RestController 返回JSON 或 XML 形式数据
    //@Controller +@ResponseBody 返回JSON 或 XML 形式数据

    //Spring MVC
    //MVC 是一种设计模式,Spring MVC 是一款很优秀的 MVC 框架。Spring MVC 可以帮助我们进行更简洁的Web层的开发，并且它天生与 Spring 框架集成。Spring MVC 下我们一般把后端项目分为 Service层（处理业务）、Dao层（数据库操作）、Entity层（实体类）、Controller层(控制层，返回数据给前台页面)。
    //SpringMVC 工作原理流程
    //客户端（浏览器）发送请求，直接请求到 DispatcherServlet。
    //DispatcherServlet 根据请求信息调用 HandlerMapping，解析请求对应的 Handler。
    //解析到对应的 Handler（也就是我们平常说的 Controller 控制器）后，开始由 HandlerAdapter 适配器处理。
    //HandlerAdapter 会根据 Handler 来调用真正的处理器开处理请求，并处理相应的业务逻辑。
    //处理器处理完业务后，会返回一个 ModelAndView 对象，Model 是返回的数据对象，View 是个逻辑上的 View。
    //ViewResolver 会根据逻辑 View 查找实际的 View。
    //DispaterServlet 把返回的 Model 传给 View（视图渲染）。
    //把 View 返回给请求者（浏览器）
    //SpringMVC 重要组件
    //1、前端控制器DispatcherServlet（不需要工程师开发）,由框架提供（重要）
    //作用：Spring MVC 的入口函数。接收请求，响应结果，相当于转发器，中央处理器。有了 DispatcherServlet 减少了其它组件之间的耦合度。用户请求到达前端控制器，它就相当于mvc模式中的c，DispatcherServlet是整个流程控制的中心，由它调用其它组件处理用户的请求，DispatcherServlet的存在降低了组件之间的耦合性。
    //2、处理器映射器HandlerMapping(不需要工程师开发),由框架提供
    //作用：根据请求的url查找Handler。HandlerMapping负责根据用户请求找到Handler即处理器（Controller），SpringMVC提供了不同的映射器实现不同的映射方式，例如：配置文件方式，实现接口方式，注解方式等。
    //3、处理器适配器HandlerAdapter
    //作用：按照特定规则（HandlerAdapter要求的规则）去执行Handler 通过HandlerAdapter对处理器进行执行，这是适配器模式的应用，通过扩展适配器可以对更多类型的处理器进行执行。
    //4、处理器Handler(需要工程师开发)
    //注意：编写Handler时按照HandlerAdapter的要求去做，这样适配器才可以去正确执行Handler Handler 是继DispatcherServlet前端控制器的后端控制器，在DispatcherServlet的控制下Handler对具体的用户请求进行处理。 由于Handler涉及到具体的用户业务请求，所以一般情况需要工程师根据业务需求开发Handler。
    //5、视图解析器View resolver(不需要工程师开发),由框架提供
    //作用：进行视图解析，根据逻辑视图名解析成真正的视图（view） View Resolver负责将处理结果生成View视图，View Resolver首先根据逻辑视图名解析成物理视图名即具体的页面地址，再生成View视图对象，最后对View进行渲染将处理结果通过页面展示给用户。 springmvc框架提供了很多的View视图类型，包括：jstlView、freemarkerView、pdfView等。 一般情况下需要通过页面标签或页面模版技术将模型数据通过页面展示给用户，需要由工程师根据业务需求开发具体的页面。
    //6、视图View(需要工程师开发)
    //View是一个接口，实现类支持不同的View类型（jsp、freemarker、pdf...）
    //注意：处理器Handler（也就是我们平常说的Controller控制器）以及视图层view都是需要我们自己手动开发的。其他的一些组件比如：前端控制器DispatcherServlet、处理器映射器HandlerMapping、处理器适配器HandlerAdapter等等都是框架提供给我们的，不需要自己手动开发。
    //什么是Spring的MVC框架？
    //Spring 配备构建Web 应用的全功能MVC框架。Spring可以很便捷地和其他MVC框架集成，如Struts，Spring 的MVC框架用控制反转把业务对象和控制逻辑清晰地隔离。它也允许以声明的方式把请求参数和业务对象绑定。
    //springMVC流程具体叙述下
    //当应用启动时,容器会加载servlet类并调用init方法. 在这个阶段，DispatcherServlet在init()完成初始化参数init-param的解析和封装,相关配置,spring的WebApplicationContext的初始化即完成xml文件的加载,bean的解析和注册等工作,另外为servlet功能所用的变量进行初始化,如:handlerMapping,viewResolvers等.
    //当用户发送一个请求时，首先根据请求的类型调用DispatcherServlet不同的方法，这些方法都会转发到doService()中执行．在该方法内部完成以下工作：
    //1)spring首先考虑multipart的处理,如果是MultipartContent类型的request,则将该请求转换成MultipartHttpServletRequest类型的request.
    //2)根据request信息获取对应的Handler. 首先根据request获取访问路径,然后根据该路径可以选择直接匹配或通用匹配的方式寻找Handler,即用户定义的controller. Handler在init()方法时已经完成加载且保存到Map中了,只要根据路径就可以得到对应的Handler. 如果不存在则尝试使用默认的Handler. 如果还是没有找到那么就通过response向用户返回错误信息.找到handler后会将其包装在一个执行链中,然后将所有的拦截器也加入到该链中.
    //4)如果存在handler则根据当前的handler寻找对应的HandlerAdapter. 通过遍历所有适配器来选择合适的适配器.
    //5)SpringMVC允许你通过处理拦截器Web请求,进行前置处理和后置处理.所以在正式调用 Handler的逻辑方法时,先执行所有拦截器的preHandle()方法.
    //6)正式执行handle的业务逻辑方法handle(),返回ModelAndView.逻辑处理是通过适配器调用handle并返回视图.这过程其实是调用用户controller的业务逻辑.
    //8)调用拦截器的postHandle()方法,完成后置处理.
    //9)根据视图进行页面跳转.该过程首先会根据视图名字解析得到视图,该过程支持缓存,如果缓存中存在则直接获取,否则创建新的视图并在支持缓存的情况下保存到缓冲中.
    //10)过程完成了像添加前缀后缀,设置必须的属性等工作.最后就是进行页面跳转处理.
    //11)调用拦截器的afterComplection()
    //DispatcherServlet
    //Spring的MVC框架是围绕DispatcherServlet来设计的，它用来处理所有的HTTP请求和响应。
    //WebApplicationContext
    //WebApplicationContext 继承了ApplicationContext 并增加了一些WEB应用必备的特有功能，它不同于一般的ApplicationContext ，因为它能处理主题，并找到被关联的servlet。
    //什么是Spring MVC框架的控制器？
    //控制器提供一个访问应用程序的行为，此行为通常通过服务接口实现。控制器解析用户输入并将其转换为一个由视图呈现给用户的模型。Spring用一个非常抽象的方式实现了一个控制层，允许用户创建多种用途的控制器。
    //控制器提供对应用程序行为的访问，通常通过服务接口实现。控制器解析用户的输入，并将其转换为一个由视图呈现给用户的模型。Spring 通过一种极其抽象的方式实现控制器，它允许用户创建多种类型的控制器。
    //@Controller annotation
    //@Controller注解表示该类扮演控制器的角色。Spring不需要继承任何控制器基类或应用Servlet API。
    //@RequestMapping annotation
    //@RequestMapping注解用于将URL映射到任何一个类或者一个特定的处理方法上。
    //使用Spring MVC构建Web应用程序
    //功能和优点
    //Spring MVC是一个基于动作的MVC框架，突出HTTP协议的请求/响应特性
    //主要通过将每个请求URI映射到一个可执行方法来实现
    //提供一种绑定机制，请求参数名称与Java类的属性相匹配是，从用户请求中提取数据，将数据转换为预定义的数据格式，最后映射到一个模型类，创建对象
    //Spring MVC是非侵入性的，业务逻辑代码与框架相分离
    //不需要进行集成测试，借助模拟实现便利的生成式API
    //Dispatcher Servlet机制
    //主要的Servlet，负责处理所有请求，调度到合适的通道
    //处理器映射 handler mappings
    //实现HandlerMapping接口
    //视图解析器 view resolver
    //执行过程
    //创建程序
    //使用注解配置Spring MVC
    //配置器类
    //@Configuration
    //包含多个使用@Bean注解的方法
    //从给定的基础包开始扫描组件
    //@ComponentScan
    //使用JSP处理表单 
    //使用注解的强大功能
    //@Controller
    //Dispatcher Servelt扫描被Controller注解的类，从而将Web请求映射到被@RequestMapping注解的方法上
    //@RequestMapping
    //@ModeAttribute
    //@PathVariable
    //@ControllerAdvice
    //@InitBinder
    //@ExceptionHandler
    //验证用户输入
    //在视图层完成验证会使数据更稳定，不易出错
    //验证注解
    //@Size
    //@Email
    //@CreditCardNumber
    //@Pattern
    //@Valid
    //上传文件
    //两种方法
    //Commons FileUpload
    //Servlet 3.1多部分请求流程
    //工作流程
    //首先在Web应用程序的上下文定义一个多部分解析器
    //Dispatcher Servlet检测到文件上传请求，会委托给多部分解析器
    //解析器将请求解析为多部分文件和参数，并创建一个MultipartHttpServletRequest实例
    //处理异常
    //提供了基于控制器的方法明确定义的处理机制来管理应用程序抛出的未处理异常
    //@ExceptionHandler
    //实现国际化
    //支持Web应用程序的国际化i18n
    //Dispatcher Servlet可以根据用户的区域设置配置多语言支持
    //区域设置解析器
    //localeResolver
    //区域设置更改拦截器
    //使用主题
    //一组静态资源提供主题化支持
    //主要机制
    //支持主题的资源包
    //主题解析器
    //主题更改拦截器
    //解释WEB模块
    //Spring的WEB模块是构建在application context 模块基础之上，提供一个适合web应用的上下文。这个模块也包括支持多种面向web的任务，如透明地处理多个文件上传请求和程序级请求参数的绑定到你的业务对象。它也有对Jakarta Struts的支持。
    //Spring 缓存
    //缓存
    //创建缓存应用程序
    //注解
    //@Cacheable(value="users")
    //@EnableCaching
    //@CacheEvict 删除过时数据
    //@CachePut更新缓存数据
    //缓存管理器 
    //SimpleCacheManager
    //NoOpCacheManager
    //ConcurrentMapCacheManager
    //CompositeCacheManager
    //将SpEL投射到缓存
    //以编程的方式初始化缓存
    //寻找替代的缓存提供程序
    //Spring Cache 三种常用的缓存注解和意义？
    //@Cacheable ，用来声明方法是可缓存，将结果存储到缓存中以便后续使用相同参数调用时不需执行实际的方法，直接从缓存中取值。
    //@CachePut，使用 @CachePut 标注的方法在执行前，不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
    //@CacheEvict，是用来标注在需要清除缓存元素的方法或类上的，当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。
    //Spring事件机制
    //Spring框架中有哪些不同类型的事件？
    //Spring 提供了以下5种标准的事件：
    //（1）上下文更新事件（ContextRefreshedEvent）：在调用ConfigurableApplicationContext 接口中的refresh()方法时被触发。
    //（2）上下文开始事件（ContextStartedEvent）：当容器调用ConfigurableApplicationContext的Start()方法开始/重新开始容器时触发该事件。
    //（3）上下文停止事件（ContextStoppedEvent）：当容器调用ConfigurableApplicationContext的Stop()方法停止容器时触发该事件。
    //（4）上下文关闭事件（ContextClosedEvent）：当ApplicationContext被关闭时触发该事件。容器被关闭时，其管理的所有单例Bean都被销毁。
    //（5）请求处理事件（RequestHandledEvent）：在Web应用中，当一个http请求（request）结束触发该事件。
    //如果一个bean实现了ApplicationListener接口，当一个ApplicationEvent 被发布以后，bean会自动被通知。

    //什么是Spring事件监听机制
    //Spring 的事件（Application Event）为 Bean 与 Bean 之间的消息通信提供了支持。当一个 Bean 处理完一个任务之后，希望另一个 Bean 知道并能做相应的处理，这时我们就需要让另一个 Bean 监听当前 Bean 所发送的消息。（观察者模式）
    //事件及事件源:对应于观察者模式中的主题。事件源发生某事件是特定事件监听器被触发的原因。
    //事件监听器:对应于观察者模式中的观察者。监听器监听特定事件,并在内部定义了事件发生后的响应逻辑。
    //事件发布器:事件监听器的容器,对外提供发布事件和增删事件监听器的接口,维护事件和事件监听器之间的映射关系,并在事件发生时负责通知相关监听器。
    //Spring事件应用流程
    //（1）自定义事件，必须继承ApplicationEvent，实现构造方法。（消息封装推送）
    //（2）public class UserEvent extends ApplicationEvent {
    //private BaseBean baseBean;
    //（2）事件监听器，监听方法的实现可以使用注解，也可以实现接口ApplicationListener，并包含具体要触发的业务逻辑需求
    //@Component
    //public class UserBeanListener implements ApplicationListener<UserEvent>
    //@Override
    //public void onApplicationEvent(UserEvent event) {
    //System.out.println(event.getNotify().toString());
    ////监听事件后，处理后续事情
    //}
    //（3）使用容器发布事件（事件源）
    //@Autowired
    //private ApplicationContext applicationContext;
    //applicationContext.publishEvent(new UserEvent(this, b));
    //ContextLoaderListener是监听什么事件
    //ContextLoaderListener的作用就是启动Web容器时，自动装配ApplicationContext的配置信息。因为它实现了ServletContextListener这个接口，在web.xml配置这个监听器，启动容器时，就会默认执行它实现的方法。
}
