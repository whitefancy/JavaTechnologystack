package designpattern.commandpattern.remotecontrol.commands;

/**
 * 创建宏命令，一次执行多个指令
 */
public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    /**
     * 如果想实现多层次的撤销，即多次撤销，撤销到很早以前的状态
     * 需要用一个堆栈来记录操作过程的每一个命令。
     * 从顶部去除最上层的命令，然后调用它的undo方法。
     */
    @Override
    public void undo() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].undo();
        }
    }
}
