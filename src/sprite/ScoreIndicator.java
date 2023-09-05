package sprite;

import biuoop.DrawSurface;
import game.GameLevel;
import lisenters.Counter;

import java.awt.Color;

/**
 * This class charge of displaying the current score.
 */
public class ScoreIndicator implements Sprite {
    private Counter countScore;

    /**
     * constructor.
     *
     * @param countScore
     */
    public ScoreIndicator(Counter countScore) {
        this.countScore = countScore;
    }

    @Override
    public void drawOn(DrawSurface d) {
        String score = "Score: " + this.countScore.getValue();
        d.setColor(Color.black);
        d.drawText(400, 15, score, 20);
    }

    @Override
    public void timePassed() {

    }

    /**
     * add the score indicator to the game.
     *
     * @param game the game I'm adding.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
