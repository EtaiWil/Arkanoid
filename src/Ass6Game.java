import animation.AnimationRunner;
import game.GameFlow;
import biuoop.GUI;
import biuoop.Sleeper;
import levels.DirectHit;
import levels.IsrealFlag;
import levels.LevelInformation;
import levels.WideEasy;
import levels.OtherFlags;
import java.util.ArrayList;
import java.util.List;
// 211601653 Etai Wilentzik

/**
 * class Ass6game.
 */
public class Ass6Game {

    /**
     * main.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        GUI gui = new GUI("Arkanoid", 800, 600);
        Sleeper sleeper = new Sleeper();
        AnimationRunner animationRunner = new AnimationRunner(gui, 60, sleeper);
        for (String s : args) {
            if (s.equals("1")) {
                levels.add(new DirectHit());
            }
            if (s.equals("2")) {
                levels.add(new WideEasy());
            }
            if (s.equals("3")) {
                levels.add(new IsrealFlag());
            } else if (s.equals("4")) {
                levels.add(new OtherFlags());
            }
        }
        if (levels.isEmpty()) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new IsrealFlag());
            levels.add(new OtherFlags());
        }
        GameFlow gameFlow = new GameFlow(animationRunner, gui.getKeyboardSensor(), gui);
        gameFlow.runLevels(levels);
    }
}
