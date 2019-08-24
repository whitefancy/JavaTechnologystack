package designpattern.adapterpattern.appearancepattern.hometheatre;

/**
 * 为影院系统创建一个外观，对外暴露几个简单的方法，比如看电影，听歌
 * 外观只是提供给你更直接的操作，需要更高层内容，还是可以用原来的子系统。
 * 外观并没有封装子系统的类。
 * 外观可以新增功能，附加聪明的功能，让子系统使用更加方便
 * 你可以为一个子系统创建许多个外观。
 * 外观允许从子系统解耦，如果子系统换成了另外一个，不需要改变客户代码
 * 和适配器的区别 适配器是改变接口符合客户期望，即转换接口。
 * 外观是提供简化的接口，同事将客户从组件子系统解耦。
 */
public class HomeTheaterFacade {
    private Amplifier amp;
    private Tuner tuner;
    private DvdPlayer dvd;
    private CDPlayer cd;
    private Projector projector;
    private TheaterLights lights;
    private Screen screen;
    private PopcornPopper popper;

    HomeTheaterFacade(Amplifier amp, Tuner tuner,
                      DvdPlayer dvd, CDPlayer cd, Projector projector,
                      TheaterLights lights, Screen screen,
                      PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }
}
