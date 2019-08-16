package designpattern.commandpattern.remotecontrol;

import designpattern.commandpattern.remotecontrol.commands.Command;

class SimpleRemoteControl {
    private Command slot;

    SimpleRemoteControl() {
    }

    void setCommand(Command command) {
        slot = command;
    }

    void buttonWasPressed() {
        slot.execute();
    }
}
