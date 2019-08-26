package designpattern.templatemethodpattern;

import java.applet.Applet;
import java.awt.*;

/**
 * applet是能够在网页上面执行的小程序，
 * 任何applet都必须继承自Applet类
 * applet大量使用钩子来提供行为，
 * 因为这些行为作为钩子实现的，所以Applet类不用去实现它们
 */
public class MyApplet extends Applet {
    private static final long serialVersionUID = -945604934238992830L;
    private String message;

    /**
     * init钩子进行applet的初始化操作
     * 在一开始的时候被调用一次
     */
    @Override
    public void init() {
        message = "Hello World,I'm alive";
        /*
         repaint是Applet类的方法，可以让上层组件知道这个applet需要重绘
         */
        repaint();
    }

    /**
     * start钩子可以在正要被显示在网页上时，做一些动作
     */
    @Override
    public void start() {
        message = "Now,I'am starting up...";
        repaint();
    }

    /**
     * stop钩子方法，当用户跳到别的网页时，被调用，做一些事情来停止它的行动
     */
    @Override
    public void stop() {
        message = "Oh, now I'm being stopped...";
        repaint();
    }

    @Override
    public void destroy() {
        message = "I'm being destroying...bye";
        repaint();
    }

    /**
     * 钩子方法
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.drawString(message, 5, 15);
    }
}
