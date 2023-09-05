package game;
import animation.AnimationRunner;
import animation.KeyPressStoppableAnimation;
import animation.CountdownAnimation;
import animation.PauseScreen;
import animation.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import collidable.Block;
import collidable.Collidable;
import collidable.Paddle;
import levels.DrawLevelName;
import levels.LevelInformation;
import lisenters.BallRemover;
import lisenters.BlockRemover;
import lisenters.Counter;
import lisenters.ScoreTrackingListener;
import shapes.Point;
import shapes.Rectangle;
import sprite.Ball;
import sprite.ScoreIndicator;
import sprite.Sprite;
import sprite.SpriteCollection;
import java.awt.Color;
/**
 * game class.
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private int screenWidth = 800;
    private int screenHeight = 600;
    private GUI gui;
    private Counter counterBlocks = new Counter(0);
    private Counter counterBalls = new Counter(0);
    private Counter score;
    private LevelInformation levelInformation;
    /**
     * Instantiates a new Game level.
     *
     * @param gui              the gui
     * @param runner           the runner
     * @param levelInformation the level information
     * @param score            the score
     */
    public GameLevel(GUI gui, AnimationRunner runner, LevelInformation levelInformation, Counter score) {
        this.gui = gui;
        this.runner = runner;
        this.levelInformation = levelInformation;
        this.score = score;
    }
    /**
     * add new collidable object.
     *
     * @param c what i am adding.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);

    }

    /**
     * add new sprite object.
     *
     * @param s what i am adding.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }


    /**
     * Initialize a new game: create the Blocks and sprite.Ball (and collidable.Paddle)
     * // and add them to the game.
     */
    public void initialize() {
        sprites.addSprite(this.levelInformation.getBackground());
        BlockRemover blockRemover = new BlockRemover(this, counterBlocks);
        BallRemover ballRemover = new BallRemover(this, counterBalls);
        Block top = new Block(new Rectangle(new Point(0, 0), 800, 20), Color.orange);
        Block left = new Block(new Rectangle(new Point(0, 0), 20, 600), Color.orange);
        Block right = new Block(new Rectangle(new Point(screenWidth - 20, 20), 20, 600), Color.orange);
        Block bottom = new Block(new Rectangle(new Point(0, screenHeight), 800, 0), Color.orange);
        left.addToGame(this);
        top.addToGame(this);
        right.addToGame(this);
        bottom.addToGame(this);
        // ball remover register to bottom block
        bottom.addHitListener(ballRemover);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        scoreIndicator.addToGame(this);
        Rectangle pad = new Rectangle(new Point((this.screenWidth - this.levelInformation.paddleWidth()) / 2,
                570), levelInformation.paddleWidth(), 6);
        Paddle p = new Paddle(gui.getKeyboardSensor(), pad, levelInformation.paddleSpeed(), 20,
                this.screenWidth - 20, Color.decode("#f98e73"));
        p.addToGame(this);

        createBlocks(blockRemover, scoreTrackingListener, counterBlocks);

        DrawLevelName name = new DrawLevelName(this.levelInformation.levelName());
        this.sprites.addSprite(name);


    }

    /**
     * Create blocks.
     *
     * @param blockRemover          the block remover
     * @param scoreTrackingListener the score tracking listener
     * @param counterBlocks         the counter blocks
     */
    public void createBlocks(BlockRemover blockRemover, ScoreTrackingListener scoreTrackingListener,
                             Counter counterBlocks) {
        int x = this.levelInformation.blocks().size();
        for (int i = 0; i < x; i++) {
            this.levelInformation.blocks().get(i).addHitListener(blockRemover);
            this.levelInformation.blocks().get(i).addHitListener(scoreTrackingListener);
            counterBlocks.increase(1);
            this.levelInformation.blocks().get(i).addToGame(this);
        }
    }



    /**
     * Create balls.
     */
    public void createBalls() {
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            if (i % 2 == 0) {
                Ball ball = new Ball(400 + (20 * i), 500 - (25 * i), 10, Color.decode("#5f5f5f"));
                ball.setColor(Color.decode("#5f5f5f"));
                ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
                ball.setGameEnvironment(this.environment);
                counterBalls.increase(1);
                ball.addToGame(this);

            } else {
                Ball ball = new Ball(250 - (20 * i), 280 + (25 * i), 10, Color.decode("#5f5f5f"));
                ball.setColor(Color.decode("#5f5f5f"));
                ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
                ball.setGameEnvironment(this.environment);
                counterBalls.increase(1);
                ball.addToGame(this);
            }
        }
    }

    /**
     * run the game.
     */
    public void run() {
        this.createBalls();
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * remove collidable from the game.
     *
     * @param c the collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);

    }

    /**
     * remove sprite from the game.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (gui.getKeyboardSensor().isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.gui.getKeyboardSensor(),
                    KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
        if (this.counterBlocks.getValue() == 0) {
            this.running = false;
        }
        if (this.counterBalls.getValue() == 0) {
            this.running = false;
        }
        this.sprites.drawAllOn(d);


        this.sprites.notifyAllTimePassed();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Gets ball counter.
     *
     * @return the ball counter
     */
    public int getBallCounter() {
        return this.counterBalls.getValue();
    }

}
