package collidable;
import shapes.Point;

/**
 * collision info class.
 */
public class CollisionInfo {
    private Point collidePoint;
    private Collidable collidableObject;



    /**
     * constructor.
     * @param collidePoint the colide point.
     * @param collidableObject with what object was the collidable.
     */
    public CollisionInfo(Point collidePoint, Collidable collidableObject) {
        this.collidePoint = collidePoint;
        this.collidableObject = collidableObject;
    }

    /**
     * get the collide  point.
     * @return collide point
     */
    public Point collidePoint() {
        return this.collidePoint;
    }

    /**
     * get the collidable.Collidable Object.
     * @return collidable.Collidable Object
     */
    public Collidable collidableObject() {
        return this.collidableObject;
    }
}
