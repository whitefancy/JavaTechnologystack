package javacore.bounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 一个可以移动并且碰到矩形就反弹的球
 */
public class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private final double x = 0;
    private final double y = 0;
    private final double dx = 1;
    private final double dy = 1;

    /**
     * 获得球当前的位置和形状
     *
     * @return
     */
    public static Ellipse2D getShape() {
        return null;
    }

    /**
     * 移动到下一个位置，反方向如果触到边界
     *
     * @param bounds
     */
    public void move(Rectangle2D bounds) {

    }
}
