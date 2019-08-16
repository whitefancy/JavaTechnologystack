package designpattern.commandpattern.prototype;

/**
 *
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    void setCommand() {
        command.execute();
    }
}
