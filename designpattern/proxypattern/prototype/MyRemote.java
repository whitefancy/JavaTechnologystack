package designpattern.proxypattern.prototype;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * java.rmi.Remote是一个记号接口，不具有方法。必须遵守规则
 * 接口可以拓展Remote接口
 */
public interface MyRemote extends Remote {
    /**
     * 在远程接口上所有的服务都应该考虑网络和IO的异常
     *
     * @return 变量和返回值必须属于原语或者可序列化 因为这样才能通过网络运送
     * @throws RuntimeException
     */
    String sayHello() throws RemoteException;
}
