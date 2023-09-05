package shapes;


import java.util.ArrayList;
import java.util.List;

/**
 * shapes.Rectangle object that is used in the game.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constractor of the rectangle.
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }


    /**
     * return list of intersection points between a line and a rectangle.
     *
     * @param line the line i check if intersecting with the rectangle
     * @return list of intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersections = new ArrayList<Point>();
        if (line.isIntersecting(getRight())) {
            //coordinate of the point the lines intersecting.
            Point cut = getRight().diffenceNoSignifcant(getRight(), getRight().intersectionWith(line).getX(),
                    getRight().intersectionWith(line).getY());
            intersections.add(cut);
        }
        if (line.isIntersecting(getleft())) {
            Point cut = getleft().diffenceNoSignifcant(getleft(), getleft().intersectionWith(line).getX(),
                    getleft().intersectionWith(line).getY());
            intersections.add(cut);
        }
        if (line.isIntersecting(gettopLine())) {

            Point cut = gettopLine().diffenceNoSignifcant(gettopLine(), gettopLine().intersectionWith(line).getX(),
                    gettopLine().intersectionWith(line).getY());
            intersections.add(cut);
        }
        if (line.isIntersecting(getDownLine())) {
            Point cut = getDownLine().diffenceNoSignifcant(getDownLine(), getDownLine().intersectionWith(line).getX(),
                    getDownLine().intersectionWith(line).getY());
            intersections.add(cut);
        }
        return intersections;
    }

    /**
     * the width of the rectangle.
     *
     * @return the width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * the height of the rectangle.
     *
     * @return the height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * upper left point of the rectangle.
     *
     * @return upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * set new upper left.
     *
     * @param p new upper left.
     */
    public void setUpperLeft(Point p) {
        this.upperLeft = new Point(p.getX(), p.getY());
    }

    /**
     * get top line of the rectangle.
     *
     * @return to line of the rectangle
     */
    public Line gettopLine() {
        Line top = new Line(upperLeft, new Point(upperLeft.getX() + width, upperLeft.getY()));
        return top;
    }

    /**
     * get the down line of the rectangle.
     *
     * @return down line.
     */
    public Line getDownLine() {
        Line down = new Line(this.upperLeft.getX(), this.upperLeft.getY() + height, this.upperLeft.getX() + width,
                this.upperLeft.getY() + height);
        return down;
    }

    /**
     * right line of the rectangle.
     *
     * @return right line
     */
    public Line getRight() {
        Line right = new Line(upperLeft.getX() + width, upperLeft.getY(), upperLeft.getX() + width,
                this.upperLeft.getY() + height);

        return right;
    }

    /**
     * left line of the rectangle.
     *
     * @return left line.
     */
    public Line getleft() {
        Line left = new Line(this.upperLeft.getX(), this.upperLeft.getY(), this.upperLeft.getX(),
                this.getUpperLeft().getY() + height);
        return left;
    }


}
