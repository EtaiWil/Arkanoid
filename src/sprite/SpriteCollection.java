package sprite;

import biuoop.DrawSurface;


import java.util.ArrayList;

/**
 * collection of sprite items.
 */
public class SpriteCollection {
    private ArrayList<Sprite> spriteArrayList;

    /**
     * constructor.
     */
    public SpriteCollection() {
        this.spriteArrayList = new ArrayList<Sprite>();
    }

    /**
     * add sprite to the arraylist.
     *
     * @param s the object i want to add.
     */
    public void addSprite(Sprite s) {
        this.spriteArrayList.add(s);

    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.spriteArrayList.size(); i++) {
            spriteArrayList.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.spriteArrayList.size(); i++) {
            spriteArrayList.get(i).drawOn(d);
        }
    }

    /**
     * remove this sprite from the arraylist.
     *
     * @param s what I'm removing.
     */
    public void removeSprite(Sprite s) {
        this.spriteArrayList.remove(s);
    }
}