package designpattern.commandpattern.prototype;

/**
 * 客户负责创建一个ConcreteCommand，并设置其接收者
 */
public class Client {
    {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
    }
}
