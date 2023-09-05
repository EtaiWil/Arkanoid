package levels;

import collidable.Block;
import collidable.Velocity;

import shapes.Rectangle;
import shapes.Point;
import sprite.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Isreal level of the game.
 */
public class IsrealFlag implements LevelInformation {
    private int numberOfBalls = 10;
    private List<Velocity> velocities = new ArrayList<>();
    private int paddleSpeed = 12;
    private int paddleWidth = 200;
    private String levelName = "Israel";
    private Sprite backGround = new LevelThreeBackGround();
    private List<Block> blocks = new ArrayList<>();
    private int numberOfBlocksToRemove = 40;
    private int blockWidth = 50;
    private int blockHeight = 30;
    private int gameWidth = 800;

    @Override
    public int numberOfBalls() {
        return numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < this.numberOfBalls; i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed(150 + 5 * i, 5);
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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                Point point = new Point(this.gameWidth - blockWidth - 20 - blockWidth * j, 120 + i * blockHeight);
                Rectangle rectangle = new Rectangle(point, blockWidth, blockHeight);
                if (i == 0) {
                    Block block = new Block(rectangle, Color.blue);
                    blocks.add(block);
                    continue;
                }
                if (i == 1) {
                    Block block = new Block(rectangle, Color.yellow);
                    blocks.add(block);
                    continue;
                }
                if (i == 2) {
                    Block block = new Block(rectangle, Color.green);
                    blocks.add(block);
                    continue;
                }
                if (i == 3) {
                    Block block = new Block(rectangle, Color.pink);
                    blocks.add(block);
                    continue;
                }
                if (i == 4) {
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
