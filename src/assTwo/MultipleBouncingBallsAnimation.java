package assTwo;

import java.awt.*;
import java.util.Random;

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import shapes.Point;
import sprite.Ball;


public class MultipleBouncingBallsAnimation {


    public static void main(String[] args) {
        int Maxheight = 500;
        int Maxwidtgh = 500;
        int Minheight = 0;
        int Minwidtgh = 0;

        int[] radious = new int[args.length];
        readArgs(args, radious);
        Ball[] arr = new Ball[args.length];
        //  readArgs(args,arr);
        CheckSizeofRadius(radious, Maxheight, Maxwidtgh, Minheight, Minwidtgh);
        //    sort(arr);
        RandomLocation(arr, Maxheight, Maxheight, Minheight, Minwidtgh, radious);
        sort(arr);
        startBallsSpeed(arr, arr.length);

        drawAnimation(arr, Maxheight, Maxwidtgh, Minheight, Minwidtgh);

    }

    static private void drawAnimation(Ball[] balls, int Maxheight, int MaxWidth, int MinHeight, int MInWidth) {

        GUI gui = new GUI("title", Maxheight, MaxWidth);
        SetRange(balls, Maxheight, MaxWidth, MinHeight, MInWidth);
        sort(balls);
        startBallsSpeed(balls, balls.length);
        showBallAnimation(balls, gui);
    }


    public static void showBallAnimation(Ball[] balls, GUI gui) {
        boolean ChoseColor = false;
        Sleeper sleeper = new Sleeper();
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (int i = 0; i < balls.length; i++) {
                balls[i].moveOneStep();
                if (ChoseColor == false) {
                    balls[i].drawonRandomColor(d);
                    ChoseColor = true;
                } else {
                    balls[i].fillcircle(d);
                }
            }
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
            gui.show(d);

        }

    }

    //the ball need to know where he can go
    public static void SetRange(Ball[] arr, double Maxheight, double MaxWight, double MinHeight, double MinWeight) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].setLimitForBall((int) MaxWight, (int) Maxheight, (int) MinWeight, (int) MinHeight);
        }
    }

    public static void readArgs(String[] args, int[] radious) {
        for (int i = 0; i < args.length; i++) {
            int temp = Integer.parseInt(args[i]);
            //defult read;
            radious[i] = temp;
            // balls[i]=new sprite.Ball(0,0,temp, Color.black);
        }

    }

    public static void RandomLocation(Ball[] arr, int MaxHeight, int Maxweight, int MinHeight, int Minweight, int[] radious) {
        for (int i = 0; i < arr.length; i++) {

            arr[i] = new Ball(RandomPoint(arr[i], MaxHeight, Maxweight, MinHeight, Minweight), radious[i], RandomColor());
        }
    }

    //if the radious is bigger then the place i have
    public static void CheckSizeofRadius(int[] radious, int Maxheight, int Maxwidth, int Minheight, int MinWidth) {
        for (int i = 0; i < radious.length; i++) {
            if (radious[i] > Math.min(Maxheight, Maxwidth)) {
                radious[i] = 52;
            }
        }
    }


    //decending order of balls from the user.
    public static Color RandomColor() {
        Random rand = new Random();
        int R = rand.nextInt(255);
        int G = rand.nextInt(255);
        int B = rand.nextInt(255);
        Color color = new Color(R, G, B);
        return color;
    }

    public static shapes.Point RandomPoint(Ball ball, int Maxheight, int MaxWidth, int MinHeight, int MinnWidth) {
        Random rand = new Random();
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);
        //max can is the maximume value for a point
        int maxCan = Math.min(Maxheight, MaxWidth);
        int minCan = Math.max(MinHeight, MinnWidth);
        //if the point is out of range;
        if (x > maxCan) {
            x = (minCan + maxCan) / 2;
        }
        if (x < minCan) {
            x = (minCan + maxCan) / 2;
        }

        if (y > maxCan) {
            y = (minCan + maxCan) / 2;
        }
        if (y < minCan) {
            y = (minCan + maxCan) / 2;
        }

        Point p = new shapes.Point(x, y);
        return p;
    }

    public static void sort(Ball arr[]) {
        Ball temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1].getSize() > arr[j].getSize()) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void startBallsSpeed(Ball arr[], int size) {
        int speed = size * 3;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSize() > 50) {
                arr[i].setVelocity(1, 1);
            } else {
                arr[i].setVelocity(speed - (2 * i), speed - (2 * i));
            }
        }
    }


}
