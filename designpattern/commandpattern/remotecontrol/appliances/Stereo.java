package designpattern.commandpattern.remotecontrol.appliances;

/**
 * 音响
 */
public class Stereo {
    private int volume;

    public void on() {
        System.out.println("stereo on");
    }

    public void off() {
        System.out.println("stereo off");
    }

    public void setCd() {
        System.out.println("set a cd");
    }

    void setDvd() {
        System.out.println("set a dvd");
    }

    void setRadio() {
        System.out.println("set a radio");
    }

    public void setVolume(int i) {
        volume = i;
    }

}
