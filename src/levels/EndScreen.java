package levels;

import animation.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.GameFlow;

/**
 * The  End screen class.
 */
public class EndScreen implements Animation {
    private Boolean stop;
    private GameFlow gameFlow;
    private Boolean isWineer;

    /**
     * Instantiates a new End screen.
     *
     * @param gameFlow the game flow
     * @param isWineer the is wineer
     */
    public EndScreen(GameFlow gameFlow, Boolean isWineer) {
        this.stop = false;
        this.gameFlow = gameFlow;
        this.isWineer = isWineer;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (isWineer) {
            d.drawText(300, 400, "You win! Your score is " + this.gameFlow.getCounter(), 20);
        } else {
            d.drawText(300, 400, "Game Over. Your score is " + this.gameFlow.getCounter(), 20);
        }

        if (this.gameFlow.getGui().getKeyboardSensor().isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
