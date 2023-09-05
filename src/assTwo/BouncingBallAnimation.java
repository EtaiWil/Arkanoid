package assTwo;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import shapes.Point;
import sprite.Ball;

public class BouncingBallAnimation {
    public static void main(String[] args) {

        Point t = new Point(50, 30);
        //make sure that the point is positive
        t.abs(t);


        drawAnimation(t, 30, 3);
    }

    static private void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball((int) start.getX(), (int) start.getY(), 30, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        DrawSurface info = gui.getDrawSurface();
        ball.setLimitForBall(info.getWidth(), info.getHeight(), 0, 0);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();

            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
