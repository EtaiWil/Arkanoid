package levels;

import biuoop.DrawSurface;
import sprite.Sprite;

import java.awt.Color;

/**
 * The Level four background.
 */
public class LevelFourBackGround implements Sprite {
    private int gameWidth = 800;
    private int gameHeight = 600;


    @Override
    public void drawOn(DrawSurface d) {

        d.setColor(Color.decode("#b4b4cb"));
        d.fillRectangle(0, 0, this.gameWidth, this.gameHeight);

//germany

        d.setColor(Color.black);
        d.drawText(50, 45, "Germany", 20);
        d.setColor(Color.black);
        d.fillRectangle(50, 50, 100, 20);
        d.setColor(Color.red);
        d.fillRectangle(50, 70, 100, 20);
        d.setColor(Color.yellow);
        d.fillRectangle(50, 90, 100, 20);
        //england
        d.setColor(Color.black);
        d.drawText(160, 45, "England", 20);
        d.setColor(Color.white);
        d.fillRectangle(160, 50, 100, 60);
        d.setColor(Color.red);
        d.fillRectangle(160, 80, 100, 10);
        d.fillRectangle(200, 50, 10, 60);
        //Argentina
        d.setColor(Color.black);
        d.drawText(270, 45, "Argentina", 20);
        d.setColor(Color.blue);
        d.fillRectangle(270, 50, 100, 20);
        d.setColor(Color.white);
        d.fillRectangle(270, 70, 100, 20);
        d.setColor(Color.yellow);

        d.fillCircle(315, 80, 10);
        d.setColor(Color.blue);
        d.fillRectangle(270, 90, 100, 20);
//belgium
        d.setColor(Color.black);
        d.drawText(380, 45, "Belgium", 20);
        d.setColor(Color.black);
        d.fillRectangle(380, 50, 33, 60);
        d.setColor(Color.yellow);
        d.fillRectangle(413, 50, 33, 60);
        d.setColor(Color.red);
        d.fillRectangle(446, 50, 33, 60);
        //italy
        d.setColor(Color.black);
        d.drawText(489, 45, "Italy", 20);
        d.setColor(Color.GREEN);
        d.fillRectangle(489, 50, 33, 60);
        d.setColor(Color.white);
        d.fillRectangle(522, 50, 33, 60);
        d.setColor(Color.red);
        d.fillRectangle(555, 50, 33, 60);
        //Yemen
        d.setColor(Color.black);
        d.drawText(600, 45, "Yemen", 20);
        d.setColor(Color.red);
        d.fillRectangle(600, 50, 100, 20);
        d.setColor(Color.white);
        d.fillRectangle(600, 70, 100, 20);
        d.setColor(Color.black);
        d.fillRectangle(600, 90, 100, 20);
    }

    @Override
    public void timePassed() {

    }
}
