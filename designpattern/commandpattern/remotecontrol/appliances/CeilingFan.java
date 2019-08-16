package designpattern.commandpattern.remotecontrol.appliances;

/**
 * 吊扇
 */
public class CeilingFan {
    private String location;

    public CeilingFan(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " ceilingFan is on");
    }

    public void off() {
        System.out.println(location + " ceilingFan is off");
    }
}
