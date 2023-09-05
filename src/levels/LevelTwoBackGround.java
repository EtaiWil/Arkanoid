package levels;

import biuoop.DrawSurface;
import sprite.Sprite;

import java.awt.Color;

/**
 * The Level two background.
 */
public class LevelTwoBackGround implements Sprite {
    private int gameWidth = 800;
    private int gameHeight = 600;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.decode("#ecd4dc"));
        d.fillRectangle(0, 0, gameWidth, gameHeight);
        d.setColor(Color.decode("#F8E473"));
        d.fillCircle(150, 100, 50);
        int x = gameWidth;
        while (x > 0) {
            d.setColor(Color.decode("#F8E473"));
            d.drawLine(150, 150, x, 200);
            x = x - 20;
        }
        d.setColor(Color.decode("#f4c430"));
        d.fillCircle(150, 100, 40);
        d.setColor(Color.decode("#EED202"));
        d.fillCircle(150, 100, 30);


    }

    @Override
    public void timePassed() {

    }
}
