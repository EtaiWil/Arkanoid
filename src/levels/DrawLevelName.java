package levels;

import biuoop.DrawSurface;
import sprite.Sprite;

import static java.awt.Color.BLACK;

/**
 * The  Draw level Class draw the level name.
 */
public class DrawLevelName implements Sprite {
    private String name;

    /**
     * Instantiates a new Draw level name.
     *
     * @param name the name
     */
    public DrawLevelName(String name) {
        this.name = name;
    }

    @Override
    public void drawOn(DrawSurface d) {
        String levelName = "Level Name: " + this.name;
        d.setColor(BLACK);
        d.drawText(600, 16, levelName, 15);
    }

    @Override
    public void timePassed() {

    }
}
