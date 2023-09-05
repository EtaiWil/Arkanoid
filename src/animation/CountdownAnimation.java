package animation;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import sprite.SpriteCollection;

import java.awt.Color;


/**
 * The type Countdown animation.
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Boolean stop = false;
    private long waitFor;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.waitFor = 3;
    }

    @Override
    public void doOneFrame(DrawSurface d) {

        this.gameScreen.drawAllOn(d);
        d.setColor(Color.MAGENTA);
        d.drawText(d.getHeight() / 2, d.getWidth() / 2, Integer.toString(this.countFrom), 40);
        Sleeper sleeper = new Sleeper();

        if (this.countFrom != 0) {
            sleeper.sleepFor((long) ((this.numOfSeconds / waitFor * 1000)));
        }
        if (this.countFrom > 0) {
            this.countFrom = this.countFrom - 1;
        } else {
            sleeper.sleepFor((long) ((this.numOfSeconds / waitFor * 1000)));
            this.stop = true;
        }


    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }


}