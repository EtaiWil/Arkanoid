package assTwo;

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import shapes.Point;
import sprite.Ball;


public class BallsTest1 {
    public static void main(String[] args) {
        //    GUI gui = new GUI("Balls Test 1", 400, 400);
        //   DrawSurface d = gui.getDrawSurface();

        //   sprite.Ball b1 = new sprite.Ball(100,100,30,java.awt.Color.RED);
        //  sprite.Ball b2 = new sprite.Ball(100,150,10,java.awt.Color.BLUE);
        //  sprite.Ball b3 = new sprite.Ball(80,249,50,java.awt.Color.GREEN);

        //  b1.drawOn(d);
        //  b2.drawOn(d);
        //  b3.drawOn(d);

        //   gui.show(d);

        //shapes.Point t=new shapes.Point(31,21);
        //drawAnimation(t,5,2);


    }

    static private void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball((int) start.getX(), (int) start.getY(), 30, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawonRandomColor(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}