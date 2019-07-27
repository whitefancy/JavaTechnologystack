package javacore.bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 弹跳球游戏，碰到墙壁重新开始
 * 本程序 展示一个弹力球
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * 有球组件和button的帧
 */
class BounceFrame extends JFrame {
    private static final int STEPS = 1000;
    private static final int DELAY = 3;
    private static final long serialVersionUID = -8967952730540159602L;
    private final BallComponent comp;

    /**
     * 构造一个帧，展示球，和开始结束button
     */
    BounceFrame() {
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        BounceFrame.addButton(buttonPanel, "Start", e -> addBall());
        BounceFrame.addButton(buttonPanel, "Close", e -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * 增加一个button到容器里
     *
     * @param c
     * @param title
     * @param listener
     */
    private static void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * 增加一个弹力球并让他弹1000次
     */
    private void addBall() {
        Ball ball = new Ball();
        comp.add(ball);

        for (int i = 0; i < BounceFrame.STEPS; i++) {
            ball.move(comp.getBounds());
            comp.paint(comp.getGraphics());
            try {
                Thread.sleep(BounceFrame.DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}