package javacore.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
    //Proxy类
    //Proxy类就是用来创建一个代理对象的类，它提供了很多方法，但是我们最常用的是newProxyInstance方法。
    //public static Object newProxyInstance(ClassLoader loader,
    //Class<?>[] interfaces,
    //InvocationHandler h)
    //这个方法的作用就是创建一个代理类对象，它接收三个参数，我们来看下几个参数的含义：
    //loader：一个classloader对象，定义了由哪个classloader对象对生成的代理类进行加载
    //interfaces：一个interface对象数组，表示我们将要给我们的代理对象提供一组什么样的接口，如果我们提供了这样一个接口对象数组，那么也就是声明了代理类实现了这些接口，代理类就可以调用接口中声明的所有方法。
    //h：一个InvocationHandler对象，表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并最终由其调用。
    //上面我们只讲解了Proxy中的newProxyInstance（生成代理类的方法），但是它还有其它的几个方法，我们下面就介绍一下：
    //getInvocationHandler：返回指定代理实例的调用处理程序
    //getProxyClass：给定类加载器和接口数组的代理类的java.lang.Class对象。
    //isProxyClass：当且仅当使用getProxyClass方法或newProxyInstance方法将指定的类动态生成为代理类时，才返回true。
    //newProxyInstance：返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序。
    //代理的操作是通过java.lang.reflect.Proxy 类中实现的，通过Proxy的newProxyInstance()方法可以创建一个代理对象
    //public static Object newProxyInstance(ClassLoader loader,类<?>[] interfaces,InvocationHandler h)
    //代理可以帮助我们进行很好的封装，使底层的代码能够有效的隐藏起来。
    //动态代理，传入代理对象，执行invoke方法。
    //RealObject real = new RealObject();
    //ProxyInterface proxy = (ProxyInterface)Proxy.newProxyInstance(
    //ProxyInterface.class.getClassLoader(),
    //new Class[]{ProxyInterface.class},
    //new ProxyObject(real));
    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length) + 1;

        int result = Arrays.binarySearch(elements, key);

        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}

class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object t) {
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //print implicit argument
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        //print explicit arguments
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(",");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}