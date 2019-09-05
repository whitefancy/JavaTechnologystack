package designpattern.commandpattern.remotecontrol;

import designpattern.commandpattern.remotecontrol.appliances.CeilingFan;
import designpattern.commandpattern.remotecontrol.appliances.GarageDoor;
import designpattern.commandpattern.remotecontrol.appliances.Light;
import designpattern.commandpattern.remotecontrol.appliances.Stereo;
import designpattern.commandpattern.remotecontrol.commands.*;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();
        CeilingFanOnMediumCommand fanMedium = new CeilingFanOnMediumCommand(ceilingFan);
        CeilingFanOnHighCommand fanHigh = new CeilingFanOnHighCommand(ceilingFan);
        CeilingFanOnLowCommand fanlow = new CeilingFanOnLowCommand(ceilingFan);
        CeilingFanOffCommand fanOff = new CeilingFanOffCommand(ceilingFan);
        remoteControl.setCommands(0, fanMedium, fanOff);
        remoteControl.setCommands(1, fanHigh, fanOff);
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        remoteControl.setCommands(4, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommands(5, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommands(2, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommands(3, stereoOnWithCD, stereoOff);
        Command[] partyOn = {livingRoomLightOn, kitchenLightOn, ceilingFanOn};
        Command[] partyOff = {livingRoomLightOff, kitchenLightOff, ceilingFanOff};
        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);
        remoteControl.setCommands(6, partyOnMacro, partyOffMacro);
        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

    }
}
