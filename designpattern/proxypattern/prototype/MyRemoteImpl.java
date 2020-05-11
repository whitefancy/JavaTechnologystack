package designpattern.proxypattern.prototype;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 你的服务必须实现远程接口，供客户使用接口方法
 * <p>
 * 为了成为远程服务对象，需要某些远程功能，最简单的方式是继承UnicastRemoteObject，让超类帮你工作
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    private static final long serialVersionUID = 5985745491829130126L;

    /**
     * 如果超类的构造器抛出异常，子类的构造器也只能抛出异常，所以必须要声明构造器
     *
     * @throws RemoteException
     */
    protected MyRemoteImpl() throws RemoteException {
    }

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String sayHello() {
        return "Server says, 'Hey'";
    }
}
