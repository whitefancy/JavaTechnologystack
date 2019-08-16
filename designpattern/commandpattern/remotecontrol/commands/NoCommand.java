package designpattern.commandpattern.remotecontrol.commands;

/**
 * 实现一个不做事情的命令
 * 因为我们不想每次都检查是否每个插槽都加载了命令
 * 所以给了他们初始值，就不用做null校验了
 * <p>
 * 很多设计模式中，都有空对象的使用，甚至有些时候，空对象本身也被视为一种设计模式
 */
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
