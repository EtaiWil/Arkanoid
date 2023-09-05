package collidable;

import shapes.Point;

/**
 * velocity for the balls.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor.
     *
     * @param dx
     * @param dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * constructor of velocity.
     *
     * @param v
     */
    public Velocity(Velocity v) {
        this.dx = v.getDx();
        this.dy = v.getDy();
    }


    /**
     *  get the dx.
     * @return the current dx.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * get the dy.
     *
     * @return the current dy.
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * Take a point with position (x,y).
     * @param p  a point.
     * @return and return a new point  with position (x+dx, y+dy).
     *
     */
    public Point applyToPoint(Point p) {
        Point newPoint = new Point(p.getX() + this.dx, p.getY() + dy);
        return newPoint;
    }

    /**
     * construct a velocity witgh given angle and speed.
     * @param angle the angle of velocity a with degree.
     * @param speed the spped of the velocity.
     * @return the new velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {

        // Calculates dx and dy with trigonometry.
        double dx = (speed * Math.sin(Math.toRadians(angle))); //using formula
        double dy = -(speed * Math.cos(Math.toRadians(angle))); //using formula

        // Return new velocity with the new dx and dy.
        return new Velocity(dx, dy);
    }
}
