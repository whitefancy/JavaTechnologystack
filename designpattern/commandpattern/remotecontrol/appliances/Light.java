package designpattern.commandpattern.remotecontrol.appliances;

public class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " light is on ,room is bright now");
    }

    public void off() {
        System.out.println(location + " light is off");
    }
}
