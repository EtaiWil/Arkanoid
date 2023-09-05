package shapes;

/**
 * shapes.Point Class represent a point in the game.
 */

public class Point {
    private static final double EPSILON = Math.pow(10, -10);
    private double x;
    private double y;

    /**
     * Constructor.
     *
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * return the distance of this point to the other point.
     *
     * @param other
     * @return double distance between the points.
     */
    public double distance(Point other) {
        return (Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y)));
    }


    /**
     * return true if 2 points are equal,false otherwise.
     *
     * @param other
     * @return true or false if the points are equals.
     */
    public boolean equals(Point other) {
        if (Math.abs(other.getX() - this.getX()) < EPSILON) {
            this.setX(other.getX());
        }
        if (Math.abs(other.getY() - this.getY()) < EPSILON) {
            this.setY(other.getY());
        }
        if (this.x == other.x && this.y == other.y) {
            return true;
        }
        return false;
    }

    /**
     * @return the value of the x coordinate in the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the value of the y coordinate in the point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * get y coordinate and set it in the point.
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * get x coordinate and set it int the point.
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * return the positive value of the point.
     *
     * @param p a point to return his absolute value.
     */
    public void abs(Point p) {
        p.setX(Math.abs((int) p.getX()));
        p.setY((Math.abs((int) p.getY())));
    }

    /**
     * The assTwo.test is designed to prevent errors of inaccuracy of the variable of double.
     *
     * @param var1 double variable
     * @param var2 double variable
     * @return true if the difference is smaller than "epsilon"
     */
    public static boolean epsilonCheck(double var1, double var2) {
        if (Math.abs(var1 - var2) < EPSILON) {
            return true;
        }
        return false;
    }


}
