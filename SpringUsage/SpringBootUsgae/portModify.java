package SpringUsage.SpringBootUsgae;

public class portModify {
    //SpringBoot修改默认端口号
    //有时候我们可能需要启动不止一个SpringBoot，而SpringBoot默认的端口号是8080，所以这时候我们就需要修改SpringBoot的默认端口了。修改SpringBoot的默认端口有两种方式。下面就分别说一下这两种方式。
    //修改application.properties
    //第一种方式我们只需要在application.properties中加这样的一句话就可以了：server.port=8004。为什么这种方式可以实现修改SpringBoot的默认端口呢？因为在SpringBoot中有这样的一个类：ServerProperties。我们可以大致看一下这个类：
    //@ConfigurationProperties(prefix = "server", ignoreUnknownFields = true)
    //public class ServerProperties
    //implements EmbeddedServletContainerCustomizer, EnvironmentAware, Ordered {
    ///**
    //* Server HTTP port.
    //*/
    //private Integer port;
    //在这个类里有一个@ConfigurationProperties注解，这个注解会读取SpringBoot的默认配置文件application.properties的值注入到bean里。这里定义了一个server的前缀和一个port字段，所以在SpringBoot启动的时候会从application.properties读取到server.port的值。我们接着往下看一下：
    //@Override
    //public void customize(ConfigurableEmbeddedServletContainer container) {
    //if (getPort() != null) {
    //container.setPort(getPort());
    //}
    //这里有一个customize的方法，这个方法里会给SpringBoot设置读取到的端口号。
    //实现EmbeddedServletContainerCustomizer
    //我们在上面看到了端口号是在customize这个方法中设置的，而这个方法是在EmbeddedServletContainerCustomizer这个接口中的，所以我们可以实现这个接口，来更改SpringBoot的默认端口号。具体代码如下：
    //@RestController
    //@EnableAutoConfiguration
    //@ComponentScan
    //public class FirstExample implements EmbeddedServletContainerCustomizer {
    //@RequestMapping("/first.do")
    //String home() {
    //return "Hello World！世界你好！O(∩_∩)O哈哈~！！！我不是太很好!";
    //}
    //public static void main(String[] args) {
    //SpringApplication.run(FirstExample.class, args);
    //}
    //@Override
    //public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
    //configurableEmbeddedServletContainer.setPort(8003);
    //}
    //}
    //然后你在启动SpringBoot的时候，发现端口号被改成了8003.
    //使用命令行参数
    //如果你只是想在启动的时候修改一次端口号的话，可以用命令行参数来修改端口号。配置如下：java -jar 打包之后的SpringBoot.jar --server.port=8000
    //使用虚拟机参数
    //你同样也可以把修改端口号的配置放到JVM参数里。配置如下：-Dserver.port=8009。 这样启动的端口号就被修改为8009了。

//在Spring Boot中从类路径加载文件
//需要加载文件并创建一个DatabaseReader对象，该对象存储在服务器内存中。
//classLoader.getResourceAsStream(SRC_RESOURCES_KEY_P12)
//不能使用文件的路径。因为jar中的文件已经是流了。
//资源加载器
//使用Java，您可以使用当前线程的classLoader并尝试加载文件，但是Spring Framework为您提供了更为优雅的解决方案，例如ResourceLoader。
//您只需要自动连接ResourceLoader，然后调用getResource(„somePath“)方法即可。
//从Spring Boot JAR加载文件
//如果您想从Spring Boot JAR中的classpath加载文件，则必须使用该resource.getInputStream()方法将其作为InputStream检索。如果尝试使用resource.getFile()该方法，则会收到错误消息，因为Spring尝试访问文件系统路径，但无法访问JAR中的路径。
//非常简短的答案：您正在特定类加载器的范围内寻找属性，而不是目标类。这应该工作：
//File file = new File(getClass().getResource("jsonschema.json").getFile());
//JsonNode mySchema = JsonLoader.fromFile(file);
//最重要的是，例如，如果您想在测试中以字符串形式读取资源文件，则可以使用以下静态utils方法：
//public static String getResourceFileAsString(String fileName) {
// InputStream is = getResourceFileAsInputStream(fileName);
// if (is != null) {
// BufferedReader reader = new BufferedReader(new InputStreamReader(is));
// return (String)reader.lines().collect(Collectors.joining(System.lineSeparator()));
// } else {
// throw new RuntimeException("resource not found");
// }
//}
//public static InputStream getResourceFileAsInputStream(String fileName) {
// ClassLoader classLoader = {CurrentClass}.class.getClassLoader();
// return classLoader.getResourceAsStream(fileName);
//}
//用法示例：
//String soapXML = getResourceFileAsString("some_folder_in_resources/SOPA_request.xml");


    //Spring Boot Starter 的工作原理是什么？
    //答：Spring Boot 在启动的时候会干这几件事情：
    //① Spring Boot 在启动时会去依赖的 Starter 包中寻找 resources/META-INF/spring.factories 文件，然后根据文件中配置的 Jar 包去扫描项目所依赖的 Jar 包。
    //② 根据 spring.factories 配置加载 AutoConfigure 类
    //③ 根据 @Conditional 注解的条件，进行自动配置并将 Bean 注入 Spring Context
    //总结一下，其实就是 Spring Boot 在启动的时候，按照约定去读取 Spring Boot Starter 的配置信息，再根据配置信息对资源进行初始化，并注入到 Spring 容器中。这样 Spring Boot 启动完毕后，就已经准备好了一切资源，使用过程中直接注入对应 Bean 资源即可。
    //Spring Boot 的自动配置是如何实现的？
    //Spring Boot 项目的启动注解是：@SpringBootApplication，其实它就是由下面三个注解组成的：
    //@Configuration
    //@ComponentScan
    //@EnableAutoConfiguration
    //其中 @EnableAutoConfiguration 是实现自动配置的入口，该注解又通过 @Import 注解导入了AutoConfigurationImportSelector，
    // 在该类中加载 META-INF/spring.factories 的配置信息。然后筛选出以 EnableAutoConfiguration 为 key 的数据，加载到 IOC 容器中，
    // 实现自动配置功能！

    //8、Spring Boot 如何设置支持跨域请求？
    //现代浏览器出于安全的考虑， HTTP 请求时必须遵守同源策略，否则就是跨域的 HTTP 请求，默认情况下是被禁止的，IP（域名）不同、或者端口不同、协议不同（比如 HTTP、HTTPS）都会造成跨域问题。
    //一般前端的解决方案有：
    //① 使用 JSONP 来支持跨域的请求，JSONP 实现跨域请求的原理简单的说，就是动态创建<script>标签，然后利用<script>的 SRC 不受同源策略约束来跨域获取数据。缺点是需要后端配合输出特定的返回信息。
    //② 利用反应代理的机制来解决跨域的问题，前端请求的时候先将请求发送到同源地址的后端，通过后端请求转发来避免跨域的访问。
    //后来 HTML5 支持了 CORS 协议。CORS 是一个 W3C 标准，全称是”跨域资源共享”（Cross-origin resource sharing），允许浏览器向跨源服务器，发出 XMLHttpRequest 请求，从而克服了 AJAX 只能同源使用的限制。它通过服务器增加一个特殊的 Header[Access-Control-Allow-Origin]来告诉客户端跨域的限制，如果浏览器支持 CORS、并且判断 Origin 通过的话，就会允许 XMLHttpRequest 发起跨域请求。
    //前端使用了 CORS 协议，就需要后端设置支持非同源的请求，Spring Boot 设置支持非同源的请求有两种方式。
    //第一，配置 CorsFilter。
    //@Configuration
    //public class GlobalCorsConfig {
    //@Bean
    //public CorsFilter corsFilter() {
    //CorsConfiguration config = new CorsConfiguration();
    //config.addAllowedOrigin("*");
    //config.setAllowCredentials(true);
    //config.addAllowedMethod("*");
    //config.addAllowedHeader("*");
    //config.addExposedHeader("*");
    //UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
    //configSource.registerCorsConfiguration("/**", config);
    //return new CorsFilter(configSource);
    //}
    //}
    //需要配置上述的一段代码。第二种方式稍微简单一些。
    //第二，在启动类上添加：
    //public class Application extends WebMvcConfigurerAdapter {
    //@Override
    //public void addCorsMappings(CorsRegistry registry) {
    //registry.addMapping("/**")
    //.allowCredentials(true)
    //.allowedHeaders("*")
    //.allowedOrigins("*")
    //.allowedMethods("*");
    //}
    //}
}
