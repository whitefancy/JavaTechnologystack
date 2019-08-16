package designpattern.commandpattern.remotecontrol.commands;

import designpattern.commandpattern.remotecontrol.appliances.GarageDoor;

public class GarageDoorUpCommand implements Command {
    private GarageDoor door;

    public GarageDoorUpCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.up();
    }

    @Override
    public void undo() {
        door.down();
    }
}
