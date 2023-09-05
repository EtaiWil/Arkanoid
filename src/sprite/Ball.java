package sprite;

import biuoop.DrawSurface;
import collidable.CollisionInfo;
import collidable.Velocity;
import game.GameEnvironment;
import shapes.Line;
import shapes.Point;
import game.GameLevel;


import java.awt.Color;
import java.util.Random;

/**
 * ball class.
 */
public class Ball implements Sprite {
    private int maxlimitX;
    private int maxlimitY;
    private int minLimitY;
    private int minLimitX;
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity vel;
    private GameEnvironment game;


    /**
     * constarctor.
     *
     * @param center center of the ball
     * @param r      radius.
     * @param color  the color I want.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }


    /**
     * constructor.
     *
     * @param xCenter x center of the ball
     * @param yCenter y center of the ball.
     * @param r       radius
     * @param color   the color I want.
     */
    public Ball(double xCenter, double yCenter, int r, java.awt.Color color) {
        this.center = new Point(xCenter, yCenter);
        this.r = r;
        this.color = color;
    }


    /**
     * get x center.
     *
     * @return x center.
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * get y center.
     *
     * @return y center.
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     * get radius of the ball.
     *
     * @return radius. size
     */
    public int getSize() {
        return r;
    }

    /**
     * get the color of the ball.
     *
     * @return color color
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * give the ball frame.
     *
     * @param maxlimitX  the maxlimit x
     * @param maxlimitY  the maxlimit y
     * @param minLimitX  the min limit x
     * @param minLimintY the min limint y
     */
    public void setLimitForBall(int maxlimitX, int maxlimitY, int minLimitX, int minLimintY) {

        this.maxlimitX = maxlimitX;
        this.maxlimitY = maxlimitY;
        this.minLimitY = minLimintY;
        this.minLimitX = minLimitX;
    }


    /**
     * draw the ball on a surface.
     *
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * draw random color for the ball.
     *
     * @param surface surface.
     */
    public void drawonRandomColor(DrawSurface surface) {
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        Color color = new Color(r, g, b);
        surface.setColor(color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * fill circle with color.
     *
     * @param surface surface.
     */
    public void fillcircle(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * set velocity for the ball.
     *
     * @param v velocity.
     */
    public void setVelocity(Velocity v) {
        this.vel = v;
    }

    /**
     * set velocity for the ball.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        this.vel = new Velocity(dx, dy);
    }

    /**
     * get velocity of the ball.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.vel;
    }

    /**
     * move the ball one more step.
     */
    public void moveOneStep() {

        Point newCenter = this.getVelocity().applyToPoint(this.center);
        //new constructor to work with because i need the closest point
        Line trajectory = new Line(this.center, newCenter, 1);
        //check if there was colision
        CollisionInfo info = game.getClosestCollision(trajectory);
        //it's mean that was no collision and I need to change the center of the ball.
        if (info == null) {
            this.center = newCenter;
        } else {
            //set new velocity
            this.setVelocity(info.collidableObject().hit(this, info.collidePoint(), this.getVelocity()));
        }
    }

    /**
     * get game environment.
     *
     * @return the game enviroment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.game;
    }

    /**
     * setGame Environment.
     *
     * @param game the game
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.game = game;
    }

    /**
     * add the ball to the game.
     *
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * remove this ball from the game.
     *
     * @param g the game I'm removing from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
    /**
     * Sets color for the ball.
     *
     * @param color the color
     */
    public void setColor(Color color) {
        this.color = color;
    }


}