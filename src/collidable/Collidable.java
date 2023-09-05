package collidable;

import shapes.Point;
import shapes.Rectangle;
import sprite.Ball;

/**
 * collidable.Collidable interface.
 */
public interface Collidable {
    /**
     * get the collision rectangle.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();



    /**
     * new velocity expected after the hit (based on the force the object inflicted on us).
     * @param hitter the ball that hitting.
     * @param collisionPoint the collision point.
     * @param currentVelocity current velocity.
     * @return new velocity of the ball.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}