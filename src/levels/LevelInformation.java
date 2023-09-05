package levels;

import collidable.Block;
import collidable.Velocity;
import sprite.Sprite;

import java.util.List;

/**
 * The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls .
     *
     * @return the int
     */
    int numberOfBalls();

    /**
     * Initial velocity of each ball in list.
     *
     * @return the list
     */
    List<Velocity> initialBallVelocities();
    /**
     * Paddle speed.
     *
     * @return the int
     */
    int paddleSpeed();
    /**
     * Paddle width.
     *
     * @return the int
     */
    int paddleWidth();

    /**
     * Level name string at the top of the screen.
     *
     * @return the string
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return the background
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the list
     */
    List<Block> blocks();

    /**
     * Number of blocks to remove.
     *
     * @return the int
     */
    int numberOfBlocksToRemove();
}

