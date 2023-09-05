package lisenters;

import collidable.Block;
import sprite.Ball;

/**
 * ScoreTrackingListener track after the user game score.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constractor.
     *
     * @param scoreCounter counter that store the user score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * incrase the counter by 5 every time block was hit.
     *
     * @param beingHit the block that was hit.
     * @param hitter   the ball the hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }

}
