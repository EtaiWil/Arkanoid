package assTwo;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import collidable.Block;
import shapes.Point;
import sprite.Ball;

public class test {
    private static void drawAnimation(Ball ball) {
        GUI gui = new GUI("title", 600, 600);
        Sleeper sleeper = new Sleeper();
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.getGameEnvironment().drawOn(d);
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);
        }
    }

    public static Block[] generateBlock() {
        Block[] blocks = new Block[14];
        int j = 0;
        for (int i = 0; i < 5; i++) {
            blocks[i] = new Block(new Point(j, 200), 30, 20);
            j += 30;
        }
        j += 20;
        for (int i = 5; i < 10; i++) {
            blocks[i] = new Block(new shapes.Point(j, 350), 30, 80);
            j += 40;
        }
        blocks[10] = new Block(new shapes.Point(0, 0), 0, 600);
        blocks[11] = new Block(new shapes.Point(600, 0), 0, 600);
        blocks[12] = new Block(new shapes.Point(0, 600), 600, 0);
        blocks[13] = new Block(new shapes.Point(0, 0), 600, 0);
        return blocks;
    }
}
/*
    public static void main(String[] args) {
check ball 300,5000 vel 2,-6
        sprite.Ball ball = new sprite.Ball(300, 435, 5, Color.RED);
        //chek 2,-8
        ball.setVelocity(2, -8);
        collidable.Block[] blocks = generateBlock();
        game.GameEnvironment gameEnvironment = new game.GameEnvironment();
        for (int i = 0; i < 14; i++) {
            gameEnvironment.addCollidable(blocks[i]);
        }

        //  collidable.Block d = new collidable.Block(new shapes.Point(50, 50), 100, 50);
        //collidable.Block e= new collidable.Block(new shapes.Point(600, 0), 2, 600);
        // collidable.Block f = new collidable.Block(new shapes.Point(0, 600), 600, 2);
        // collidable.Block g = new collidable.Block(new shapes.Point(0, 0), 600, 2);
        //   gameEnvironment.addCollidable(d);
        //gameEnvironment.addCollidable(e);
        ball.setGameEnvironment(gameEnvironment);
        drawAnimation(ball);
    }

        /*
        shapes.Line t = new shapes.Line(5,10,5,200);

       // collidable.Block[] blocks = generateBlock();

      //  collidable.Block block=new collidable.Block(new shapes.Point(5,20),100,300);
       //shapes.Point p= t.closestIntersectionToStartOfLine(block.getCollisionRectangle());
      // shapes.Line x=block.getCollisionRectangle().getleft();
       // System.out.println( t.isIntersecting(x));
       // System.out.println(p.getX() + " df"+ p.getY());

         */


