package sprite;

import collidable.Block;
import lisenters.HitListener;

/**
 * print if was hit.
 */
public class PrintingHitListener implements HitListener {

    /**
     * print.
     *
     * @param beingHit the block that was hit.
     * @param hitter   the ball the hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}
