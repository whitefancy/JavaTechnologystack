package designpattern.commandpattern.remotecontrol.appliances;

/**
 * 吊扇
 */
public class CeilingFan {
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int HIGH = 3;
    public static final int OFF = 0;
    private int speed;
    private String location;

    public CeilingFan(String location) {
        this.location = location;
        speed = CeilingFan.OFF;
    }

    public void high() {
        speed = CeilingFan.HIGH;
    }

    public void medium() {
        speed = CeilingFan.MEDIUM;
    }

    public void low() {
        speed = CeilingFan.LOW;
    }

    public void off() {
        speed = CeilingFan.OFF;
        System.out.println(location + " ceilingFan is off");
    }

    public void on() {
        System.out.println(location + " ceilingFan is on");
    }

    public int getSpeed() {
        return speed;
    }
}
