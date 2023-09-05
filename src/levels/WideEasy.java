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
 * The Wide easy level.
 */
public class WideEasy implements LevelInformation {
    private int numberOfBalls = 10;
    private List<Velocity> velocities = new ArrayList<>();
    private int paddleSpeed = 10;
    private int paddleWidth = 420;
    private String levelName = "Wide Easy";
    private Sprite backGround = new LevelTwoBackGround();
    private List<Block> blocks = new ArrayList<>();
    private int numberOfBlocksToRemove = 15;
    private double blockWidth = 50.7;
    private double blockHeight = 20;

    @Override
    public int numberOfBalls() {
        return numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < this.numberOfBalls; i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed(150 + 5 * i, 6);
            velocities.add(velocity);
        }
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

        for (int i = 0; i < this.numberOfBlocksToRemove; i++) {
            Point p = new Point((this.blockWidth * i) + 20.7, 200);
            Rectangle rectangle = new Rectangle(p, this.blockWidth, this.blockHeight);
            if (i < 2) {
                Block block = new Block(rectangle, Color.red);
                blocks.add(block);
                continue;
            }
            if (i < 4) {
                Block block = new Block(rectangle, Color.orange);
                blocks.add(block);
                continue;
            }
            if (i < 6) {
                Block block = new Block(rectangle, Color.yellow);
                blocks.add(block);
                continue;
            }
            if (i < 9) {
                Block block = new Block(rectangle, Color.green);
                blocks.add(block);
                continue;
            }
            if (i < 11) {
                Block block = new Block(rectangle, Color.blue);
                blocks.add(block);
                continue;
            }
            if (i < 13) {
                Block block = new Block(rectangle, Color.pink);
                blocks.add(block);
                continue;
            } else {
                Block block = new Block(rectangle, Color.cyan);
                blocks.add(block);
                continue;
            }

        }

        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}
