package levels;

import biuoop.DrawSurface;
import shapes.Point;
import sprite.Sprite;

import java.awt.Color;

/**
 * The Level one background.
 */
public class LevelOneBackGround implements Sprite {

    private int gameHeight = 600;
    private int gameWidth = 800;
    private Point targetCenter = new Point(gameWidth / 2, gameHeight / 2);


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 20, this.gameWidth, this.gameHeight);
        d.setColor(Color.blue);
        d.drawCircle((int) this.targetCenter.getX(), (int) this.targetCenter.getY(), 50);
        d.drawCircle((int) this.targetCenter.getX(), (int) this.targetCenter.getY(), 100);
        d.drawCircle((int) this.targetCenter.getX(), (int) this.targetCenter.getY(), 150);

        d.drawLine((int) this.targetCenter.getX(), (int) this.targetCenter.getY() - 200,
                (int) this.targetCenter.getX(), (int) this.targetCenter.getY() + 200);

        d.drawLine((int) this.targetCenter.getX() - 200, (int) this.targetCenter.getY(),
                (int) this.targetCenter.getX() + 200, (int) this.targetCenter.getY());
    }

    @Override
    public void timePassed() {

    }
}
