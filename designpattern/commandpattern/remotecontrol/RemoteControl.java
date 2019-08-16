package designpattern.commandpattern.remotecontrol;

import designpattern.commandpattern.remotecontrol.commands.Command;
import designpattern.commandpattern.remotecontrol.commands.NoCommand;

public class RemoteControl {
    private Command undoCommand;
    private Command[] onCommands;
    private Command[] offCommands;

    RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommond = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommond;
            offCommands[i] = noCommond;
        }
        undoCommand = noCommond;
    }

    void setCommands(int slot, Command onCommand, Command offComand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offComand;
    }

    void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        String s = "----------RemoteControl--------\n";
        for (int i = 0; i < onCommands.length; i++) {
            s += ("\n[slot " + i + "] " + onCommands[i].getClass().getName() + "             " + offCommands[i].getClass().getName());
        }
        return s;
    }
}
