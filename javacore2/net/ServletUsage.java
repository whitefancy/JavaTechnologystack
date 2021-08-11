package javacore2.net;

public class ServletUsage {
    //Servlet 核心类图及接口介绍
    //Servlet API介绍
    //Servlet API 包含以下4个Java包：
    //1.javax.servlet 其中包含定义servlet和servlet容器之间契约的类和接口。
    //2.javax.servlet.http 其中包含定义HTTP Servlet 和Servlet容器之间的关系。
    //3.javax.servlet.annotation 其中包含标注servlet，Filter,Listener的标注。它还为被标注元件定义元数据。
    //4.javax.servlet.descriptor，其中包含提供程序化登录Web应用程序的配置信息的类型。
    //以TOMCAT为例，<CATALINA_HOME>/lib/servlet-api.jar文件为Servlet API的类库文件。
    //Servlet API主要由两个Java包组成： javax.servlet和javax.servlet.http
    //在javax.servlet包中定义了Servlet接口及相关的通用接口和类；
    //在javax.servlet.http包中主要定义了与HTTP协议相关的HttpServlet类，HttpServletRequest接口和HttpServletResponse接口；
    //Servlet接口
    //在Servlet接口中定义了5个方法，其中3个方法都是由Servlet容器来调用的，容器会在Servlet的生命周期的不同阶段调用特定的方法：
    //init(ServletConfig) —— 负责初始化Servlet对象，容器在创建好Servlet对象后，就会调用该方法；
    //service(ServletRquest req, ServletResponse res) —— 负责相应客户的请求，为客户提供相应服务。当容器接受到客户端要求访问特定Servlet对象的请求时，就会调用该Servlet对象的service()方法；
    //destroy() —— 负责释放Servlet对象占用的资源。当Servlet对象结束声明周期时，容器会调用此方法；
    //GenericServlet抽象类
    //GenericServlet抽象类为Servlet接口提供了通用实现，它与任何网络应用层协议无关。
    //GenericServlet除了实现了Servlet接口，还实现了ServletConfig接口和Serializable接口：
    //public abstract class GenericServlet
    //implements Servlet, ServletConfig, java.io.Serializable
    //GenericServlet类实现了Servlet接口中的init(ServletConfig config)初始化方法。GenericServlet类有一个ServletConfig类型的private成员变量，当Servlet容器调用GenericServlet的init(ServletConfig)方法时，该方法使得私有变量引用由容器传入的ServletConfig对象。GenericServlet类还定义了一个不带参数的init()方法，init(ServletConfig)方法会调用此方法。因此在子类中重写init时，最好重写init()方法，若重写Init(ServletConfig)方法，还需要先调用父类的init(ServletConfig)方法（super.init(config)）。
    //GenericServlet类没有实现Servlet接口中的service()方法。service()方法是GenericServlet类中唯一的抽象方法，GenericServlet类的具体子类必须实现该方法。
    //GenericServlet类实现了Servlet接口的destroy()方法，但实际什么也没做。
    //GenericServlet类实现了ServletConfig接口的所有方法。
    //HttpServlet抽象类
    //HttpServlet类是GenericServlet类的子类。HttpServlet类为Serlvet接口提供了与HTTP协议相关的通用实现，也就是说，HttpServlet对象适合运行在与客户端采用HTTP协议通信的Servlet容器或者Web容器中。
    //在我们自己开发的Java Web应用中，自定义的Servlet类一般都扩展自HttpServlet类。
    //HttpServlet类实现了Servlet接口中的service(ServletRequest , ServletResponse)方法，而该方法实际调用的是它的重载方法HttpServlet.service(HttpServletRequest, HttpServletResponse)；
    //在上面的重载service()方法中，首先调用HttpServletRequest类型的参数的getMethod()方法，获得客户端的请求方法，然后根据该请求方式来调用匹配的服务方法；如果为GET方式，则调用doGet()方法，如果为POST方式，则调用doPost()方法。
    //HttpServlet类为所有的请求方式，提供了默认的实现doGet(),doPost(),doPut(),doDelete()方法；这些方法的默认实现都会向客户端返回一个错误。
    //对于HttpServlet类的具体子类，一般会针对客户端的特定请求方法，覆盖HttpServlet类中的相应的doXXX方法。如果客户端按照GET或POST方式请求访问HttpsServlet，并且这两种方法下，HttpServlet提供相同的服务，那么可以只实现doGet()方法，并且让doPost()方法调用doGet()方法。
    //ServletRequest接口
    //ServletRequest表示来自客户端的请求；当Servlet容器接收到客户端要求访问特定Servlet的请求时，容器先解析客户端的原始请求数据，把它包装成一个ServletRequest对象。
    //ServletRequest接口提供了一系列用于读取客户端的请求数据的方法，例如：
    //getContentLength() —— 返回请求正文的长度，如果请求正文的长度未知，则返回-1；
    //getContentType() —— 获得请求正文的MIME类型，如果请求正文的类型为止，则返回null；
    //getInputStream() —— 返回用于读取请求正文的输入流；
    //getLocalAddr() —— 返回服务端的IP地址；
    //getLocalName() —— 返回服务端的主机名；
    //getLocalPort() —— 返回服务端的端口号；
    //getParameters() —— 根据给定的请求参数名，返回来自客户请求中的匹配的请求参数值；
    //getProtocal() —— 返回客户端与服务器端通信所用的协议名称及版本号；
    //getReader() —— 返回用于读取字符串形式的请求正文的BufferReader对象；
    //getRemoteAddr() —— 返回客户端的IP地址
    //getRemoteHost() —— 返回客户端的主机名
    //getRemotePort() —— 返回客户端的端口号
    //HttpServletRequest接口
    //HttpServletRequest接口是ServletRequest接口的子接口。
    //HttpServletRequest接口提供了用于读取HTTP请求中的相关信息的方法：
    //getContextPath() —— 返回客户端请求方法的Web应用的URL入口，例如，如果客户端访问的URL为http://localhost:8080/helloapp/info，那么该方法返回“/helloapp”;
    //getCookies() —— 返回HTTP请求中的所有Cookie；
    //getHeader(String name) —— 返回HTTP请求头部的特定项；
    //getHeaderName() —— 返回一个Enumeration对象，它包含了HTTP请求头部的所有项目名；
    //getMethod() —— 返回HTTP请求方式；
    //getRequestURL() —— 返回HTTP请求的头部的第一行中的URL；
    //getQueryString() —— 返回HTTP请求中的查询字符串，即URL中的“？”后面的内容；
    //ServletResponse接口
    //Servlet通过ServletResponse对象来生成响应结果。
    //ServletResponse接口定义了一系列与生成响应结果相关的方法，例如：
    //setCharacterEncoding() —— 设置相应正文的字符编码。响应正文的默认字符编码为ISO-8859-1；
    //setContentLength() —— 设置响应正文的长度；
    //setContentType() —— 设置响应正文的MIME类型；
    //getCharacterEncoding() —— 获得响应正文的字符编码
    //getContentType() —— 获得响应正文的MIME类型
    //setBufferSize() —— 设置用于存放响应正文数据的缓冲区的大小
    //getBufferSize() —— 获得用于存放响应正文数据的缓冲区的大小；
    //reset() —— 清空缓冲区内的正文数据，并且清空响应状态代码及响应头
    //resetBuffer() —— 仅仅清空缓冲区的正文数据，不清空响应状态代码及响应头；
    //flushBuffer() —— 强制性地把缓冲区内的响应正文数据发送到客户端；
    //isCommitted() —— 返回一个boolean类型的值，如果为true，表示缓冲区内的数据已经提交给客户，即数据已经发送到客户端；
    //getOutputStream() —— 返回一个ServletOutputStream对象，Servlet用它来输出二进制的正文数据；
    //getWriter() —— 返回一个PrinterWriter对象，Servlet用它来输出字符串形式的正文数据；
    //ServletResponse中响应正文的默认MIME类型是text/plain,即纯文本类型，而HttpServletResponse中响应正文的默认MIME类型为text/html，即HTML文档类型。
    //为了提高输出数据的效率，ServletOutputStream和PrintWriter首先把数据写到缓冲区内。当缓冲区内的数据被提交给客户后，ServletResponse的isComitted方法返回true。在以下几种情况下，缓冲区内的数据会被提交给客户，即数据被发送到客户端：
    //当缓冲区内的数据已满时，ServletOutPutStream或PrintWriter会自动把缓冲区内的数据发送给客户端，并且清空缓冲区；
    //Servlet调用ServletResponse对象的flushBuffer方法；
    //Servlet调用ServletOutputStream或PrintWriter对象的flush方法或close方法；
    //为了确保SerlvetOutputStream或PrintWriter输出的所有数据都会被提交给客户，比较安全的做法是在所有数据都输出完毕后，调用ServletOutputStream或PrintWriter的close()方法（Tomcat中，会自动关闭）。
    //如果要设置响应正文的MIME类型和字符编码，必须先调用ServletResponse对象的setContentType()和setCharacterEncoding()方法，然后再调用ServletResponse的getOutputStream()或getWriter()方法，提交缓冲区内的正文数据；只有满足这样的操作顺序，所做的设置才能生效。
    //HttpServletResponse接口
    //HttpServletResponse接口提供了与HTTP协议相关的一些方法，Servlet可通过这些方法来设置HTTP响应头或向客户端写Cookie。
    //addHeader() —— 向HTTP响应头中加入一项内容
    //sendError() —— 向客户端发送一个代表特定错误的HTTP响应状态代码
    //setHeader() —— 设置HTTP响应头中的一项内容，如果在响应头中已经存在这项内容，则原来的设置被覆盖
    //setStatus() —— 设置HTTP响应的状态代码
    //addCookie() —— 向HTTP响应中加入一个Cookie
    //在HttpServletResponse接口中定义了一些代表HTTP响应状态代码的静态常量。
    //ServletConfig接口
    //当Servlet容器初始化一个Servlet对象时，会为这个Servlet对象创建一个ServletConfig对象。
    //在Servlet对象中包含了Servlet的初始化参数信息。
    //ServletConfig接口中定义了以下方法：
    //getInitParameter(String name) —— 返回匹配的初始化参数值
    //getInitParameterNames() —— 返回一个Enumeration对象，里面包含了所有的初始化参数名
    //getServletContext() —— 返回一个ServletContext对象
    //getServletName() —— 返回Servlet的名字，即web.xml文件中相应<servlet>元素的<servlet-name>子元素的值；如果没有为servlet配置<servlet-name>子元素，则返回Servlet类的名字
    //HttpServlet类继承了GenericServlet类，而GenericServlet类实现了ServletConfig接口，因此HttpServlet或GenericServlet类及子类中都可以直接调用ServletConfig接口中的方法。
    //ServletContext接口
    //ServletContext是Servlet与Servlet容器之间直接通信的接口。
    //Servlet容器在启动一个Web应用时，会为它创建一个ServletContext对象。每个Web应用都有唯一的ServletContext对象，可以把ServletContext对象形象地理解为Web应用的总管家，同一个Web应用中的所有Servlet对象都共享一个ServletContext，Servlet对象可以通过其访问容器中的各种资源。
    //ServletContext接口提供的方法可以分为以下几种类型：
    //用于在web应用范围内存取共享数据的方法：
    //setAttribute(String name, Object object) —— 把一个Java对象与一个属性名绑定，并存入到ServletContext中；
    //getAttribute() —— 返回指定数姓名的属性值
    //getAttributeNames() —— 返回一个Enumeration对象，包含所有存放在ServletContext中的属性名
    //removeAttributes() —— 从ServletContext中删除匹配的属性
    //访问当前Web应用的资源：
    //getContextPath() —— 返回当前Web应用的URL入口
    //getInitParameter() —— 返回Web应用范围内的匹配的初始化参数值。在web.xml中，直接在<web-app>根元素下定义的<context-param>元素表示应用范围内的初始化参数
    //getServletContextName() —— 返回Web应用的名字，即web.xml文件中<display-name>元素的值
    //getRequestDispatcher() —— 返回一个用于向其他WEB组件转发请求的RequestDispatcher对象
    //访问Servlet容器中的其他WEB应用：
    //访问Servlet容器的相关信息：
    //访问服务器端的文件系统资源：
    //getRealPath() —— 根据参数指定的虚拟路径，返回文件系统中的一个真实的路径
    //getResources() —— 返回一个映射到参数指定的路径的URL
    //getResourceAsStream() —— 返回一个用于读取参数指定的文件的输入流
    //getMimeType() —— 返回参数指定的文件MIME类型
    //输出日志：
    //log(String msg) —— 向Servlet的日志文件中写日志
    //log(String message, Throwable throwable) —— 向Servlet的日志文件中写入错误日志，以及异常的堆栈信息
    //Servlet相关类的关系
    //与Servlet主动关联的是三个类，分别是ServletConfig，ServletRequest和ServletResponse。这三个类都是通过容器传递给Servlet的；其中，ServletConfig是在Servlet初始化时传给Servlet的，后两个是在请求到达时调用Servlet传递过来的。
    //对于Request和Response，以TOMCAT为例，tomcat接到请求首先将会创建org.apache.coyote.Request和org.apache.coyote.Response，
    // 这两个类是Tomcat内部使用的描述一次请求和相应的信息类，它们是一个轻量级的类，作用就是在服务器接收到请求后，
    // 经过简单解析将这个请求快速分配给后续线程去处理。接下来当交给一个用户线程去处理这个请求时又创建org.apache.catalina.connector.Request
    // 和org.apache.catalina.connector.Response对象。这两个对象一直贯穿整个Servlet容器直到要传给Servlet，
    // 传给Servlet的是Request和Response的Facade类。


    //Servlet 接口中定义的方法
    //让我们首先来看一看Servlet接口中定义了哪些方法吧。
    //public interface Servlet {
    //void init(ServletConfig var1) throws ServletException;
    //ServletConfig getServletConfig();
    //void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
    //String getServletInfo();
    //void destroy();
    //}

    //Servlet 的生命周期
    //其中，init( ),service( ),destroy( )是Servlet生命周期的方法。代表了Servlet从“出生”到“工作”再到“死亡 ”的过程。Servlet容器（例如TomCat）会根据下面的规则来调用这三个方法：
    //1.init( ),当Servlet第一次被请求时，Servlet容器就会开始调用这个方法来初始化一个Servlet对象出来，但是这个方法在后续请求中不会在被Servlet容器调用，就像人只能“出生”一次一样。我们可以利用init（ ）方法来执行相应的初始化工作。调用这个方法时，Servlet容器会传入一个ServletConfig对象进来从而对Servlet对象进行初始化。
    //2.service( )方法，每当请求Servlet时，Servlet容器就会调用这个方法。就像人一样，需要不停的接受老板的指令并且“工作”。第一次请求时，Servlet容器会先调用init( )方法初始化一个Servlet对象出来，然后会调用它的service( )方法进行工作，但在后续的请求中，Servlet容器只会调用service方法了。
    //3.destory,当要销毁Servlet时，Servlet容器就会调用这个方法，就如人一样，到时期了就得死亡。在卸载应用程序或者关闭Servlet容器时，就会发生这种情况，一般在这个方法中会写一些清除代码。
    //然后在xml中配置正确的映射关系，在浏览器中访问Servlet，第一次访问时，控制台输出了如下信息”Servlet正在初始化，Servlet正在提供服务”。刷新页面，不再出现“Servlet正在初始化”。只会提供服务。
    //接下来，我们关闭Servlet容器：控制台输出了Servlet的销毁信息，这就是一个Servlet的完整生命周期。
    //Servlet 的其它两个方法
    //getServletInfo（ ），这个方法会返回Servlet的一段描述，可以返回一段字符串。
    //getServletConfig（ ），这个方法会返回由Servlet容器传给init（ ）方法的ServletConfig对象。
}
