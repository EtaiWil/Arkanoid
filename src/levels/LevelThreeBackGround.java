package levels;

import biuoop.DrawSurface;
import shapes.Point;
import sprite.Sprite;
import java.awt.Color;


/**
 * The Level three background.
 */
public class LevelThreeBackGround implements Sprite {
    private int gameWidth = 800;
    private int gameHeight = 600;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, gameWidth, gameHeight);

        d.setColor(Color.blue);
        d.fillRectangle(20, 40, gameWidth, 50);
        d.fillRectangle(20, 510, gameWidth, 50);
        Point lowTopTriangle = new Point(400, 250);
        Point lowLeftTriangle = new Point(300, 350);
        Point lowRightTriangle = new Point(500, 350);

        Point secondLeft = new Point(300, 280);
        Point secondDown = new Point(400, 380);
        Point secondRight = new Point(500, 280);
        d.drawLine((int) secondLeft.getX(), (int) secondLeft.getY(), (int) secondDown.getX(),
                (int) secondDown.getY());
        d.drawLine((int) secondLeft.getX(), (int) secondLeft.getY(), (int) secondRight.getX(),
                (int) secondRight.getY());
        d.drawLine((int) secondDown.getX(), (int) secondDown.getY(), (int) secondRight.getX(),
                (int) secondRight.getY());


        d.drawLine((int) lowTopTriangle.getX(), (int) lowTopTriangle.getY(), (int) lowLeftTriangle.getX(),
                (int) lowLeftTriangle.getY());
        d.drawLine((int) lowLeftTriangle.getX(), (int) lowLeftTriangle.getY(), (int) lowRightTriangle.getX(),
                (int) lowRightTriangle.getY());
        d.drawLine((int) lowTopTriangle.getX(), (int) lowTopTriangle.getY(), (int) lowRightTriangle.getX(),
                (int) lowRightTriangle.getY());


    }

    @Override
    public void timePassed() {

    }
}
