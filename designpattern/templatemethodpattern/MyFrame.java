package designpattern.templatemethodpattern;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame是最基本的Swing容器，通过覆盖paint，
 * 可以将自己的代码插入JFrame的算法中
 * 显示出你所想要的画面
 */
public class MyFrame extends JFrame {
    private static final long serialVersionUID = 9006988947474216067L;

    private MyFrame(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Head First Design Patterns");
    }

    /**
     * paint方法就是一个钩子方法，在update()方法中调用。
     * 默认状态下，paint方法是不做是的，我们覆盖这个方法，让它显示一条消息
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String msg = "I rule!!";
        g.drawString(msg, 100, 100);
    }
}
