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
 * The Other flags level.
 */
public class OtherFlags implements LevelInformation {
    private int numberOfBalls = 9;
    private List<Velocity> velocities = new ArrayList<>();
    private int paddleSpeed = 8;
    private int paddleWidth = 250;
    private String levelName = "Other flags";
    private Sprite backGround = new LevelFourBackGround();
    private List<Block> blocks = new ArrayList<>();
    private int numberOfBlocksToRemove = 90;
    private double blockWidth = 50;
    private double blockHeight = 40;
    private double gameWidth = 800;
    private double blocksInRow = numberOfBlocksToRemove / 6;

    @Override
    public int numberOfBalls() {
        return numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        for (int i = 0; i < this.numberOfBalls; i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed(300 + (15 * i), 5);
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
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < this.blocksInRow; i++) {

                Point p = new Point(this.gameWidth - blockWidth - 20 - blockWidth * i, 230 - this.blockHeight * j);
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
        }
        return blocks;
    }


    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}

