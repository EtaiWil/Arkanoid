package collidable;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import shapes.Point;
import shapes.Rectangle;
import game.GameLevel;
import sprite.Ball;
import sprite.Sprite;

import java.awt.Color;

/**
 * paddle class. use him in the game as a paddle.
 */
public class Paddle implements Sprite, Collidable {

    private biuoop.KeyboardSensor keyboard;
    private Rectangle pad;
    private int speedPad;
    private int leftLayoutLimit;
    private int rightLayoutLimit;
    private Color color;

    /**
     * constructor.
     *
     * @param keyboardSensor   keyboard sensor.
     * @param pad              thre rectangle of the paddle.
     * @param speedPad         speed of the paddle
     * @param leftLayoutLimit  the left limit of the paddle where he can go.
     * @param rightLayoutLimit thre right limit of the paddle where he can go.
     * @param color            color of the paddle.
     */
    public Paddle(KeyboardSensor keyboardSensor, Rectangle pad, int speedPad, int leftLayoutLimit,
                  int rightLayoutLimit, Color color) {
        this.keyboard = keyboardSensor;
        this.pad = pad;
        this.speedPad = speedPad;
        this.leftLayoutLimit = leftLayoutLimit;
        this.rightLayoutLimit = rightLayoutLimit;
        this.color = color;
    }

    /**
     * move left the paddle. when the user press left-key. if the paddle already at the left, the paddle stay there
     */
    public void moveLeft() {
        double newXValue = pad.getUpperLeft().getX() - speedPad;
        if (newXValue <= leftLayoutLimit) {
            this.pad.setUpperLeft(new Point(leftLayoutLimit, this.pad.getUpperLeft().getY()));
        } else {
            this.pad.setUpperLeft(new Point(newXValue, this.pad.getUpperLeft().getY()));
        }
    }

    /**
     * move the paddle to the right when the user hit thr right key.
     */
    public void moveRight() {

        double newXValue = pad.getUpperLeft().getX() + speedPad;
        if (newXValue >= rightLayoutLimit - pad.getWidth()) {
            this.pad.setUpperLeft(new Point(rightLayoutLimit - pad.getWidth(), this.pad.getUpperLeft().getY()));
        } else {
            this.pad.setUpperLeft(new Point(newXValue, this.pad.getUpperLeft().getY()));
        }


    }


    /**
     * move the paddle according to what key was pressed.
     */
    public void timePassed() {

        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
    }

    /**
     * draw the paddle.
     *
     * @param d the surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawRectangle((int) this.pad.getUpperLeft().getX(), (int) this.pad.getUpperLeft().getY(),
                (int) this.pad.getWidth(), (int) this.pad.getHeight());

        d.setColor(this.color);
        d.fillRectangle((int) this.pad.getUpperLeft().getX(), (int) this.pad.getUpperLeft().getY(),
                (int) this.pad.getWidth(), (int) this.pad.getHeight());

    }

    /**
     * get the Collision shapes.Rectangle.
     *
     * @return the rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.pad;
    }


    /**
     * return new velocity according to where the ball hit the paddle.
     *
     * @param hitter          the ball was hit.
     * @param collisionPoint  the collision point that the ball hits peddle.
     * @param currentVelocity current velocity of the ball.
     * @return new velocity of the ball.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        if (pad.gettopLine().pointInLine(collisionPoint)) {

            double angle = pad.gettopLine().angleByRegion(collisionPoint);
            double dx = currentVelocity.getDx();
            double dy = currentVelocity.getDy();
            double speed = Math.sqrt((dx * dx) + (dy * dy));

            return new Velocity(Velocity.fromAngleAndSpeed(angle, speed));
        } else {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
        }


    }
    /**
     * add this paddle to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}