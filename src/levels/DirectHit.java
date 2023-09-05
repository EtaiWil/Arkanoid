package levels;

import collidable.Block;

import collidable.Velocity;
import shapes.Point;
import shapes.Rectangle;
import sprite.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The Direct hit level.
 */
public class DirectHit implements LevelInformation {
    private int numberOfBalls = 1;
    private List<Velocity> velocities = new ArrayList<>();
    private int paddleSpeed = 5;
    private int paddleWidth = 50;
    private String levelName = "Direct Hit";
    private Sprite backGround = new LevelOneBackGround();
    private List<Block> blocks = new ArrayList<>();
    private int numberOfBlocksToRemove = 1;

    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Velocity velocity = new Velocity(0, -5);
        velocities.add(velocity);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public Sprite getBackground() {
        return this.backGround;
    }

    @Override
    public List<Block> blocks() {
        Block b = new Block(new Rectangle(new Point(380, 280), 40, 40), Color.red);
        this.blocks.add(b);
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}
