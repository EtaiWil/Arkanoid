package assTwo;

import assTwo.MultipleBouncingBallsAnimation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import sprite.Ball;

import java.awt.Color;

public class MultipleFramesBouncingBallsAnimation {

    public static void main(String[] args) {
        int guiHeight = 800;
        int guiwidth = 800;
        int GrayRectangleXStrart = 50;
        int GrayRectangleYStrart = 50;
        int GrayRectangleXEnd = 500;
        int GrayRectangleYEnd = 500;
        int YellowRectangleXStart = 450;
        int YellowRectangleYStart = 450;
        int YellowRectangleXEnd = 600;
        int YellowRectangleYEnd = 600;
        Ball[] arr = new Ball[args.length];
        Ball[] GreyArr = new Ball[arr.length / 2];
        Ball[] YellowArr = new Ball[arr.length / 2];
        int[] ArrRadious = new int[args.length];
        MultipleBouncingBallsAnimation.readArgs(args, ArrRadious);
        MultipleBouncingBallsAnimation.CheckSizeofRadius(ArrRadious, guiHeight, guiwidth, GrayRectangleYStrart, GrayRectangleXStrart);


        //just for initalize;
        MultipleBouncingBallsAnimation.RandomLocation(arr, guiHeight, guiwidth, GrayRectangleXStrart, GrayRectangleYStrart, ArrRadious);
        CrateArrays(arr, GreyArr, YellowArr);

        MultipleBouncingBallsAnimation.sort(arr);

        MultipleBouncingBallsAnimation.startBallsSpeed(arr, arr.length);
        MultipleBouncingBallsAnimation.SetRange(GreyArr, GrayRectangleXStrart + GrayRectangleXEnd, GrayRectangleYStrart + GrayRectangleYEnd, GrayRectangleYStrart, GrayRectangleXStrart);
        MultipleBouncingBallsAnimation.SetRange(YellowArr, YellowRectangleYEnd, YellowRectangleXEnd, YellowRectangleYStart, YellowRectangleXStart);

        MultipleBouncingBallsAnimation.sort(GreyArr);
        MultipleBouncingBallsAnimation.sort(YellowArr);
        SortTwoSortedArrays(YellowArr, GreyArr, arr);

        drawAnimation(guiHeight, guiwidth, GrayRectangleXStrart, GrayRectangleYStrart, GrayRectangleXEnd, GrayRectangleYEnd,
                YellowRectangleXStart, YellowRectangleYStart, YellowRectangleXEnd, YellowRectangleYEnd, GreyArr, YellowArr);

    }

    public static void drawAnimation(int guiHeight, int guiWidth, int GrayRectangleXStrart, int GrayRectangleYStrart, int GrayRectangleXEnd
            , int GrayRectangleYEnd, int YellowRectangleXStart, int YellowRectangleYStart, int YellowRectangleXEnd, int YellowRectangleYEnd,
                                     Ball[] Grey, Ball[] Yellow) {
        GUI gui = new GUI("assTwo.MultipleFramesBouncingBallsAnimation", guiWidth, guiHeight);
        Sleeper sleeper = new Sleeper();
        boolean ChoseColor1 = false;
        boolean ChoseColor2 = false;
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            d.setColor(Color.GRAY);
            d.fillRectangle(GrayRectangleXStrart, GrayRectangleYStrart,
                    GrayRectangleXEnd, GrayRectangleYEnd);
            d.setColor(Color.YELLOW);
            d.fillRectangle(YellowRectangleXStart, YellowRectangleYStart,
                    YellowRectangleXEnd - YellowRectangleXStart, YellowRectangleYEnd - YellowRectangleYStart);
            for (int i = 0; i < Grey.length; i++) {
                Grey[i].moveOneStep();
                if (ChoseColor1 == false) {
                    Grey[i].drawonRandomColor(d);
                    ChoseColor1 = true;
                } else {
                    Grey[i].fillcircle(d);
                }
            }
            for (int i = 0; i < Yellow.length; i++) {

                Yellow[i].moveOneStep();
                if (ChoseColor2 == false) {
                    Grey[i].drawonRandomColor(d);
                    ChoseColor2 = true;
                } else {
                    Yellow[i].fillcircle(d);
                }

            }
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
            gui.show(d);
        }
    }


    public static void CrateArrays(Ball[] arr, Ball[] GreyArr, Ball[] YellowArr) {
        int j = 0;
        for (int i = 0; i < GreyArr.length; i++) {
            GreyArr[i] = arr[i];
        }
        for (int i = YellowArr.length; i < arr.length; i++) {

            YellowArr[j] = arr[i];
            j++;
        }
    }

    //merge the result to applay velocity for each array
    public static void SortTwoSortedArrays(Ball[] yellow, Ball[] Grey, Ball[] arr) {
        int j = 0;//for the yellow array
        int i = 0;// for the grey array
        int k = 0;//for the arr array
        while (j < yellow.length && i < Grey.length) {
            if (yellow[j].getSize() >= Grey[i].getSize()) {
                Grey[i].setVelocity(arr[k].getVelocity());
                k = k + 1;
                i = i + 1;
            } else {
                yellow[j].setVelocity(arr[k].getVelocity());
                k = k + 1;
                j = j + 1;
            }
        }
        if (j == yellow.length) {
            while (i < Grey.length) {
                Grey[i].setVelocity(arr[k].getVelocity());
                k = k + 1;
                i = i + 1;
            }
        }
        if (i == Grey.length) {
            while (j < yellow.length) {
                yellow[j].setVelocity(arr[k].getVelocity());
                k = k + 1;
                j = j + 1;
            }
        }


    }


}
