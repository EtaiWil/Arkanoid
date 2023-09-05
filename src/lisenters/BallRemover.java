package lisenters;

import collidable.Block;
import game.GameLevel;
import sprite.Ball;

/**
 * BallRemover  in charge of removing balls from the game, as well as keeping count
 * * of the number of blocks that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param game           the game.
     * @param remainingBalls the remaining balls.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        remainingBalls.decrease(1);

    }

}
