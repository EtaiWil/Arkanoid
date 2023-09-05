package assTwo;

import biuoop.GUI;
import biuoop.DrawSurface;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;

import java.util.List;
import java.util.Random;
import java.awt.Color;

public class AbstractArtDrawing {
    Line[] arrRandom = new Line[6];
    Line[] storeArr = new Line[100];

    Line generateRandomLine() {
        Random rand = new Random(); // create a random-number generator
        int x1 = rand.nextInt(400) + 1;
        int y1 = rand.nextInt(400) + 1;
        int x2 = rand.nextInt(400) + 1;
        int y2 = rand.nextInt(400) + 1;
        Line New = new Line(x1, y1, x2, y2);
        return New;

    }

    void drawLine(Line l, DrawSurface d) {
        d.drawLine((int) l.start().getX(), (int) l.start().getY(), (int) l.end().getX(), (int) l.end().getY());

        // d.setColor(Color.blue);
        //d.fillCircle((int) l.middle().getX(), (int) l.middle().getY(), 3);
        //  d.drawCircle((int) l.middle().getX(), (int) l.middle().getY(), 3);
        //d.setColor(Color.black);
    }

    void drawrec(Point p, int hight, int width, DrawSurface d) {

        d.drawRectangle((int) p.getX(), (int) p.getY(), hight, width);
    }

    public void drawRandomLines(Point r, int Height, int Width, Rectangle rec) {
        Random rand = new Random(); // create a random-number generator
        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Lines Example", 800, 800);
        DrawSurface d = gui.getDrawSurface();

        Line check = new Line(528, 242, 531, 231);
        Line TRY = new Line(530, 210, 530, 240);

        drawLine(check, d);
        //drawLine(TRY,d);
        //for (int i = 1; i < arrRandom.length; i++) {
        //    arrRandom[i] = generateRandomLine();
        //    drawLine(arrRandom[i], d);
        // }
        drawrec(r, Width, Height, d);

        //for (int i = 1; i < arrRandom.length; i++) {
        // for (int j = 2; j < arrRandom.length; j++) {
        // shapes.Point p = arrRandom[i].intersectionWith(arrRandom[j]);

        //   if (p != null) {
        //      d.setColor(Color.red);
        //       d.fillCircle((int) p.getX(), (int) p.getY(), 3);
        //  }
        //  }
        //   }
        /*
        for (int i=0;i< arrRandom.length;i++){
            List<shapes.Point> intersections=rec.intersectionPoints(arrRandom[i]);
            if (intersections.isEmpty()==false) {
                shapes.Point t = intersections.get(i);
                d.setColor(Color.CYAN);
                d.fillCircle((int) t.getX(), (int) t.getY(), 5);
                d.setColor(Color.CYAN);
            }
        }

         */

        //for (int i=0;i< arrRandom.length;i++){
        Point k = check.closestIntersectionToStartOfLine(rec);

        if (k != null) {
            d.setColor(Color.green);
            d.fillCircle((int) k.getX(), (int) k.getY(), 2);
        }
        Point jr = TRY.closestIntersectionToStartOfLine(rec);
        if (jr != null) {
            d.setColor(Color.green);
            d.fillCircle((int) jr.getX(), (int) jr.getY(), 2);
        }

        List<Point> intersections = rec.intersectionPoints(check);
        //intersections=rec.intersectionPoints(check);
        if (intersections.isEmpty() == false) {
            Point mm = intersections.get(1);
            d.setColor(Color.orange);
            d.fillCircle((int) mm.getX(), (int) mm.getY(), 5);
            d.setColor(Color.orange);
        }

        gui.show(d);
    }
}
/*
    public static void main(String[] args) {
     // assTwo.AbstractArtDrawing example = new assTwo.AbstractArtDrawing();

       // shapes.Rectangle r=new shapes.Rectangle(new shapes.Point(770,130),30,40);
      // example.drawRandomLines(r.getUpperLeft(),(int)r.getHeight(),(int)r.getWidth(),r);
//shapes.Line t=new shapes.Line(2,2,120,100);
//shapes.Line g=new shapes.Line(50,60,80,60);
//shapes.Point k=t.intersectionWith(g);
      //  System.out.println(k.getX());
       // System.out.println(k.getY());

        shapes.Line check =new shapes.Line( 528,242,531,231);
        shapes.Line TRY=new shapes.Line(480,240,530,240);
     Boolean b= check.isIntersecting(TRY);
        System.out.println(b);
   //     System.out.println(b);
      //  System.out.println(b);
        // shapes.Point p=check.intersectionWith(TRY);
       // System.out.println(p.getX());
       // System.out.println(p.getY());


    }
}

 */
