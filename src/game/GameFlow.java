package game;

import animation.Animation;
import animation.AnimationRunner;
import animation.KeyPressStoppableAnimation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import levels.EndScreen;
import levels.LevelInformation;
import lisenters.Counter;

import java.util.List;

/**
 * The Game flow class.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;
    private Counter counter;


    /**
     * Instantiates a new Game flow.
     *
     * @param animationRunner the animation runner
     * @param keyboardSensor  the keyboard sensor
     * @param gui             the gui
     */
    public GameFlow(AnimationRunner animationRunner, KeyboardSensor keyboardSensor, GUI gui) {
        this.animationRunner = animationRunner;
        this.keyboardSensor = keyboardSensor;
        this.gui = gui;
        this.counter = new Counter(0);
    }

    /**
     * Run levels of the game.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        Animation endScreen;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(gui, animationRunner, levelInfo, counter);

            level.initialize();

            level.run();
            if (level.getBallCounter() == 0) {
                //if he loses the game
                endScreen = new EndScreen(this, false);
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                        endScreen));

                this.gui.close();
            }
            this.counter.increase(100);
        }
        //if wins
        endScreen = new EndScreen(this, true);
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                endScreen));
        this.gui.close();
    }

    /**
     * Gets counter.
     *
     * @return the counter
     */
    public int getCounter() {
        return this.counter.getValue();
    }

    /**
     * Gets gui.
     *
     * @return the gui
     */
    public GUI getGui() {
        return this.gui;
    }

}

