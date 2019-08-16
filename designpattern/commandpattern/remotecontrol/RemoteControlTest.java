package designpattern.commandpattern.remotecontrol;

import designpattern.commandpattern.remotecontrol.appliances.GarageDoor;
import designpattern.commandpattern.remotecontrol.appliances.Light;
import designpattern.commandpattern.remotecontrol.commands.GarageDoorUpCommand;
import designpattern.commandpattern.remotecontrol.commands.LightOnCommand;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light("");
        LightOnCommand lightOn = new LightOnCommand(light);
        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        GarageDoor door = new GarageDoor();
        GarageDoorUpCommand doorOpen = new GarageDoorUpCommand(door);
        remote.setCommand(doorOpen);
        remote.buttonWasPressed();
        remote.setCommand(lightOn);
        remote.buttonWasPressed();
    }
}
