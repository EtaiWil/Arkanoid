package game;

import biuoop.DrawSurface;
import collidable.Collidable;
import collidable.CollisionInfo;
import shapes.Line;
import shapes.Point;

import java.util.ArrayList;
import java.util.List;


/**
 * game environment class.
 */
public class GameEnvironment {
    /**
     * add the given collidable to the environment.
     */
    private List<Collidable> collidables;

    /**
     * constructor.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * add new collidable.
     *
     * @param c what i want to add.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * get the closest collision that is going to be if exist.
     *
     * @param trajectory the line of the ball
     * @return closest collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        // Case no collidable objects in the game environment.
        if (collidables.isEmpty()) {
            return null;
        }
        // The algorithm to find the closest collision point if exist.
        CollisionInfo info = null;
        double curDist;
        double minDist = Double.MAX_VALUE;
        for (Collidable collidable : collidables) {
            Point hit = trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());
            if (hit != null) {
                curDist = hit.distance(trajectory.start());
                if (curDist < minDist) {
                    minDist = curDist;
                    info = new CollisionInfo(hit, collidable);
                }
            }
        }
        return info;
    }

    /**
     * fill rectangle.
     *
     * @param surface a surface
     */
    public void drawOn(DrawSurface surface) {
        for (int i = 0; i < collidables.size(); i++) {
            surface.fillRectangle((int) collidables.get(i).getCollisionRectangle().getUpperLeft().getX(),
                    (int) collidables.get(i).getCollisionRectangle().getUpperLeft().getY(),
                    (int) collidables.get(i).getCollisionRectangle().getWidth(),
                    (int) collidables.get(i).getCollisionRectangle().getHeight());
        }
    }

    /**
     * get all the collidables.
     *
     * @return list of collidables objects.
     */
    public List<Collidable> getCollidables() {
        return (this.collidables);
    }

    /**
     * remove collidable from the game.
     * @param c what I'm removing.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);

    }

}
