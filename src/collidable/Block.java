package collidable;

import biuoop.DrawSurface;
import lisenters.HitListener;
import lisenters.HitNotifier;
import shapes.Point;
import shapes.Rectangle;
import game.GameLevel;
import sprite.Ball;
import sprite.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * collidable.Block shape.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle rec;
    private Color color = null;

    /**
     * constructor.
     *
     * @param upperLeft upper left of the rectangle.
     * @param width     width of the rectangle.
     * @param height    height of the rectangle.
     */
    public Block(Point upperLeft, double width, double height) {
        this.rec = new Rectangle(upperLeft, width, height);
        this.hitListeners = new ArrayList<>();
    }

    /**
     * constructor.
     *
     * @param rec   rectangle.
     * @param color color
     */
    public Block(Rectangle rec, Color color) {
        this.rec = rec;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * getting the collision rectangle.
     *
     * @return rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }

    /**
     * change the velocity according where the ball hits.
     *
     * @param hitter          is the Ball that's doing the hitting.
     * @param collisionPoint  the collision point.
     * @param currentVelocity current velocity.
     * @return new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        if (this.rec.gettopLine().pointInLine(collisionPoint) || this.rec.getDownLine().pointInLine(collisionPoint)) {
            dy = -dy;
        } else {
            dx = -dx;
        }
        this.notifyHit(hitter);
        Velocity newVelocity = new Velocity(dx, dy);
        return newVelocity;
    }

    @Override
    public void drawOn(DrawSurface d) {
        if (this.color == null) {
            color = Color.red;
            d.fillRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                    (int) this.rec.getWidth(), (int) this.rec.getHeight());
            d.setColor(Color.black);
            d.drawRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                    (int) this.rec.getWidth(), (int) this.rec.getHeight());
        } else {
            d.setColor(this.color);
            d.fillRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                    (int) this.rec.getWidth(), (int) this.rec.getHeight());
            d.setColor(Color.black);
            d.drawRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                    (int) this.rec.getWidth(), (int) this.rec.getHeight());
        }
    }

    @Override
    public void timePassed() {

    }

    /**
     * add the block to a given game.
     *
     * @param game the game I add.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * set color to block.
     *
     * @param color the color I want to set.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * this function remove this block from the game.
     *
     * @param game the game I want to remove the block from him.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);

    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }


    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);

    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}


