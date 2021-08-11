package javacore2.net;

public class LoggingInterceptor {
    //拦截器
    //拦截器
    //拦截器是一种强大的机制，可以监视，重写和重试呼叫。这是一个简单的拦截器，用于记录传出的请求和传入的响应。
    //class LoggingInterceptor implements Interceptor {
    //  @Override public Response intercept(Interceptor.Chain chain) throws IOException {
    //    Request request = chain.request();
    //    long t1 = System.nanoTime();
    //    logger.info(String.format("Sending request %s on %s%n%s",
    //        request.url(), chain.connection(), request.headers()));
    //    Response response = chain.proceed(request);
    //    long t2 = System.nanoTime();
    //    logger.info(String.format("Received response for %s in %.1fms%n%s",
    //        response.request().url(), (t2 - t1) / 1e6d, response.headers()));
    //    return response;
    //  }
    //}
    //调用chain.proceed(request)是每个拦截器实现的关键部分。这种简单的方法是所有HTTP工作发生的地方，产生一个响应来满足请求。如果chain.proceed(request)被多次调用，则必须关闭先前的响应主体。
    //拦截器可以链接。假设您同时具有压缩拦截器和校验和拦截器：您将需要确定是先压缩数据然后对校验和进行校验，还是先对数据进行校验和然后进行压缩。OkHttp使用列表来跟踪拦截器，并按顺序调用拦截器。
    //在应用程序拦截器和网络拦截器之间进行选择
    //每个拦截器链都有相对的优点。
    //应用拦截器
    //无需担心诸如重定向和重试之类的中间响应。
    //即使从缓存提供HTTP响应，也总是被调用一次。
    //遵守应用程序的原始意图。不关心OkHttp注入的标头，例如If-None-Match。
    //允许短路而不是Chain.proceed()。
    //允许重试并多次致电Chain.proceed()。
    //可以使用withConnectTimeout，withReadTimeout，withWriteTimeout调整呼叫超时。
    //网络拦截器
    //能够对诸如重定向和重试之类的中间响应进行操作。
    //不会为使网络短路的缓存响应调用。
    //观察数据，就像通过网络传输数据一样。
    //访问Connection带有请求的。
    //重写请求
    //拦截器可以添加，删除或替换请求标头。他们还可以转换那些具有一个请求的主体。例如，如果要连接到已知支持请求主体的Web服务器，则可以使用应用程序拦截器来添加请求主体压缩。
    ///** This interceptor compresses the HTTP request body. Many webservers can't handle this! */
    //final class GzipRequestInterceptor implements Interceptor {
    //  @Override public Response intercept(Interceptor.Chain chain) throws IOException {
    //    Request originalRequest = chain.request();
    //    if (originalRequest.body() == null || originalRequest.header("Content-Encoding") != null) {
    //      return chain.proceed(originalRequest);
    //    }
    //    Request compressedRequest = originalRequest.newBuilder()
    //        .header("Content-Encoding", "gzip")
    //        .method(originalRequest.method(), gzip(originalRequest.body()))
    //        .build();
    //    return chain.proceed(compressedRequest);
    //  }
    //  private RequestBody gzip(final RequestBody body) {
    //    return new RequestBody() {
    //      @Override public MediaType contentType() {
    //        return body.contentType();
    //      }
    //      @Override public long contentLength() {
    //        return -1; // We don't know the compressed length in advance!
    //      }
    //      @Override public void writeTo(BufferedSink sink) throws IOException {
    //        BufferedSink gzipSink = Okio.buffer(new GzipSink(sink));
    //        body.writeTo(gzipSink);
    //        gzipSink.close();
    //      }
    //    };
    //  }
    //}
    //重写响应
    //对称地，拦截器可以重写响应头并转换响应主体。通常，这比重写请求标头更危险，因为它可能违反Web服务器的期望！
    //如果您处在棘手的情况下并准备好处理后果，则重写响应标头是解决问题的有效方法。例如，您可以修复服务器的错误配置的Cache-Control响应头，以实现更好的响应缓存：
    ///** Dangerous interceptor that rewrites the server's cache-control header. */
    //private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
    //  @Override public Response intercept(Interceptor.Chain chain) throws IOException {
    //    Response originalResponse = chain.proceed(chain.request());
    //    return originalResponse.newBuilder()
    //        .header("Cache-Control", "max-age=60")
    //        .build();
    //  }
    //};
    //HTTPS
    //sOkHttp试图平衡两个相互竞争的问题：
    //连接到尽可能多的主机。其中包括运行最新版本的boringssl的高级主机，以及运行较旧版本的OpenSSL的过时主机。
    //连接的安全性。这包括使用证书验证远程Web服务器以及使用强密码交换的数据的私密性。
    //在协商与HTTPS服务器的连接时，OkHttp需要知道要提供哪些TLS版本和密码套件。想要最大程度地提高连接性的客户端将包括过时的TLS版本和弱设计密码套件。想要最大程度提高安全性的严格客户端将仅限于最新的TLS版本和最强的密码套件。
    //特定的安全性与连接性决定由ConnectionSpec实现。OkHttp包含四个内置的连接规范：
    //RESTRICTED_TLS 是一种安全配置，旨在满足更严格的合规性要求。
    //MODERN_TLS 是连接到现代HTTPS服务器的安全配置。
    //COMPATIBLE_TLS 是一种安全配置，可连接到安全的HTTPS服务器，但不能连接到当前的HTTPS服务器。
    //CLEARTEXT是用于http://URL的不安全配置。
    //这些宽松地遵循了Google Cloud Policies中设置的模型。我们跟踪对此政策的更改。
    //默认情况下，OkHttp将尝试MODERN_TLS连接。但是，COMPATIBLE_TLS如果现代配置失败，则可以通过配置客户端connectionSpecs来允许回退到连接。
    //OkHttpClient client = new OkHttpClient.Builder()
    //    .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS))
    //    .build();
    //每个规范中的TLS版本和密码套件可随每个发行版而更改。例如，在OkHttp 2.2中，为了响应POODLE攻击，我们放弃了对SSL 3.0的支持。在OkHttp 2.3中，我们放弃了对RC4的支持。与您的桌面Web浏览器一样，保持OkHttp的最新状态是确保安全的最佳方法。
    //您可以使用一组自定义的TLS版本和密码套件来构建自己的连接规范。例如，此配置仅限于三个备受推崇的密码套件。它的缺点是它需要Android 5.0+和类似的当前Web服务器。
    //ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
    //    .tlsVersions(TlsVersion.TLS_1_2)
    //    .cipherSuites(
    //          CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
    //          CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
    //          CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
    //    .build();
    //OkHttpClient client = new OkHttpClient.Builder()
    //    .connectionSpecs(Collections.singletonList(spec))
    //.build();
    //调试TLS握手失败
    //TLS握手要求客户端和服务器共享一个通用的TLS版本和密码套件。这取决于JVM或Android版本，OkHttp版本以及Web服务器配置。如果没有通用的密码套件和TLS版本，您的呼叫将失败，如下所示：
    //Caused by: javax.net.ssl.SSLProtocolException: SSL handshake aborted: ssl=0x7f2719a89e80:
    //    Failure in SSL library, usually a protocol error
    //        error:14077410:SSL routines:SSL23_GET_SERVER_HELLO:sslv3 alert handshake
    //        failure (external/openssl/ssl/s23_clnt.c:770 0x7f2728a53ea0:0x00000000)
    //    at com.android.org.conscrypt.NativeCrypto.SSL_do_handshake(Native Method)
    //您可以使用Qualys SSL Labs检查Web服务器的配置。OkHttp的TLS配置历史记录在此处跟踪。
    //预期将在旧版Android设备上安装的应用程序应考虑采用 Google Play服务的ProviderInstaller。这将提高用户的安全性，并增强与Web服务器的连接性。
    //证书固定（.kt，.java）
    //默认情况下，OkHttp信任主机平台的证书颁发机构。此策略可最大程度地提高连接性，但会受到诸如2011 DigiNotar攻击之类的证书颁发机构的攻击。它还假定您的HTTPS服务器的证书是由证书颁发机构签名的。
    //使用CertificatePinner可以限制受信任的证书和证书颁发机构。证书固定可提高安全性，但会限制您的服务器团队更新其TLS证书的能力。没有服务器的TLS管理员的祝福，请不要使用证书固定！
    //retryOnConnectionFailure
    //fun retryOnConnectionFailure(retryOnConnectionFailure:Boolean): Builder
    //遇到连接问题时，将此客户端配置为重试或不重试。默认情况下，此客户端从以下问题静默恢复：
    //无法访问的IP地址。如果URL的主机具有多个IP地址，则无法访问任何单个IP地址不会使整个请求失败。这可以增加多宿主服务的可用性。
    //过时的池连接。该连接池重用套接字来降低请求的延迟，但这些连接将偶尔超时。
    //无法访问的代理服务器。一的ProxySelector可用于尝试按顺序多个代理服务器，最终回落到直接连接。
    //将此设置为false可以避免重试请求，因为这样做会破坏性。在这种情况下，调用应用程序应自行恢复连接故障。
    //Retrofit
    //使用拦截器重试网络请求
    //作为okhttp2.2的一项新功能引入，拦截器旨在与您的http调用挂钩，以便您可以查看正在发生的事情和正在发生的事情。
    //这是一个很好的事情（也，在某些级别危险的）来实现Android应用频繁消耗一些REST API内部故障等防政策。通过在体系结构级别采用这样的策略，可以轻松监视我们的应用程序进行的网络调用并轻松处理令人讨厌的情况，例如，人们可以继续重试相同的调用，直到获取某些东西为止，这至少与重要的API无关。
    //拦截器的设计目的就是要做到这一点，并且与他们一起工作很愉快。而且，正如杰西·威尔逊（Jesse Wilson）在这里建议的那样，它们非常危险。
    //public interface Interceptor {
    //  Response intercept(Chain chain) throws IOException;
    //  interface Chain {
    //    Request request();
    //    Response proceed(Request request) throws IOException;
    //    Connection connection();
    //  }
    //}
    //让我们看看在令牌身份验证失败的情况下如何实施此策略。我们发出了一个请求，说是Req A，并设置了auth令牌作为标头，并得到了我们的令牌已过期的响应。现在，我们的政策是触发新的附带请求，该请求将为我们提供刷新的令牌。然后，我们使用新令牌再次生成ReqA。这就是一个自定义拦截器的模样。
    //public class CustomResponseInterceptor implements Interceptor {
    //    private static String newToken;
    //    private String bodyString;
    //    private final String TAG = getClass().getSimpleName();
    //    @Override
    //    public Response intercept(Chain chain) throws IOException {
    //        Request request = chain.request();
    //        Response response = chain.proceed(request);
    //        if (response.code() != 200) {
    //            Response r = null;
    //            try { r = makeTokenRefreshCall(request, chain); }
    //            catch (JSONException e) { e.printStackTrace(); }
    //            return r;
    //        }
    //        Log.d(TAG, "INTERCEPTED:$ " response.toString());
    //        return response;
    //    }
    //    private Response makeTokenRefreshCall(Request req, Chain chain) throws JSONException, IOException {
    //        Log.d(TAG, "Retrying new request");
    //        /* fetch refreshed token, some synchronous API call, whatever */
    //        String newToken = fetchToken();
    //        /* make a new request which is same as the original one, except that its headers now contain a refreshed token */
    //        Request newRequest;
    //        newRequest = req.newBuilder().header("Authorization", " Token " + newToken).build();
    //        Response another =  chain.proceed(newRequest);
    //        while (another.code() != 200) {
    //            makeTokenRefreshCall(newRequest, chain);
    //        }
    //        return another;
    //    }
    //}
    //现在，当您设置Retrofit2服务以生成该Req A时，只需将此拦截器添加到okhttp客户端即可。
    //CustomResponseInterceptor interceptor = new CustomResponseInterceptor();
    //OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
    //RandomAPIRequestA service = new Retrofit.Builder()
    //        .baseUrl("URL goes here")
    //        .client(client)
    //        .build()
    //        .create(RandomAPIRequestA);
}
