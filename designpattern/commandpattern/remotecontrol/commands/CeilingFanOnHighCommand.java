package designpattern.commandpattern.remotecontrol.commands;

import designpattern.commandpattern.remotecontrol.appliances.CeilingFan;

public class CeilingFanOnHighCommand implements Command {
    private CeilingFan ceilingFan;
int prevSpeed;
    public CeilingFanOnHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed=ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {

        if(prevSpeed==CeilingFan.HIGH)
            ceilingFan.high();
        else if(prevSpeed==CeilingFan.MEDIUM)
            ceilingFan.medium();
        else if(prevSpeed==CeilingFan.LOW)
            ceilingFan.low();
        else if(prevSpeed==CeilingFan.OFF)
            ceilingFan.off();
    }
}
