package designpattern.commandpattern.remotecontrol.commands;

/**
 * 命令模式: 将“请求”封装成对象，以便不同的请求、队列、或者日志 来参数化其他对象。
 * 命令模式也支持可撤销的操作
 * <p>
 * 特定接收者只暴露出一个 execute()方法
 */
public interface Command {
    public void execute();

    public void undo();
}
