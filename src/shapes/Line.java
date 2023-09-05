package shapes;

import java.util.List;

/**
 * shapes.Line class building line,and do methods on the line.
 */
public class Line {
    private final Point start;
    private final Point end;

    /**
     * constructor get 2 points and build a line from both of the points.
     *
     * @param start
     * @param end
     */
    public Line(Point start, Point end) {
        //make sure that start is the min of the x value;
        if (start.getX() < end.getX() || Point.epsilonCheck(start.getX(), end.getX())) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
    }

    /**
     * special constructor used only in trajectory because only there i want to not change the stat and end point.
     *
     * @param start the start point of the line
     * @param end   the end point of the line
     * @param x     dont use him at all but need him to call this unique constructor
     */
    public Line(Point start, Point end, int x) {
        this.start = start;
        this.end = end;
    }


    /**
     * build 2 points from 4 coordinates.
     *
     * @param x1 x coordinate of the first point.
     * @param y1 y coordinate of the first point.
     * @param x2 x coordinate of the secend point.
     * @param y2 y coordinate of the secend point.
     */
    public Line(double x1, double y1, double x2, double y2) {

        if (x1 < x2 || Point.epsilonCheck(x1, x2)) {
            this.start = new Point(x1, y1);
            this.end = new Point(x2, y2);
        } else {
            this.start = new Point(x2, y2);
            this.end = new Point(x1, y1);
        }
    }

    /**
     * @return return the length of a line.
     */
    public double length() {
        return (this.start.distance(end));
    }


    /**
     * @return return a new point  that the coordinates of the points are the middle of the line.
     */
    public Point middle() {
        Point mid = new Point(((this.start.getX() + this.end.getX()) / 2), ((this.start.getY() + this.end.getY()) / 2));
        return (mid);
    }

    /**
     * @return the first point of the line.
     */
    public Point start() {
        return start;
    }

    /**
     * @return the last point of the line.
     */
    public Point end() {
        return end;
    }

    /**
     * calculating the slope of the line.
     *
     * @return the slope.
     */
    public double slpoe() {

        return ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
    }

    /**
     * @param slope the slope of the line.
     * @return the b value of the equation y=ax+b.
     */
    public double findB(double slope) {
        return (this.start.getY() - (slope * this.start.getX()));
    }

    /**
     * check if the line is vertical meaning his slop is infinity.
     *
     * @return yes if he is vertical no otherwise.
     */
    public boolean isVertical() {
        //  if (this.start.getX() == this.end.getX()) {
        return Point.epsilonCheck(this.start.getX(), this.end.getX());
    }

    /**
     * @param other other point.
     * @param xCut  the x value of point of intersection between two lines.
     * @return if the x value of the intersection between the two lines.
     */
    public boolean inrangeX(Line other, double xCut) {
        //if (xcut-xstart<epsilon)
        double thisminX = Math.min(this.start.getX(), this.end.getX());
        double thismax = Math.max(this.start.getX(), this.end.getX());
        double otherminX = Math.min(other.start.getX(), other.end.getX());
        double otherMaxX = Math.max(other.start.getX(), other.end.getX());

        return (thisminX < xCut || Point.epsilonCheck(thisminX, xCut))
                && (xCut < thismax || Point.epsilonCheck(thismax, xCut))
                && ((otherminX < xCut) || Point.epsilonCheck(otherminX, xCut))
                && (xCut < otherMaxX || Point.epsilonCheck(otherMaxX, xCut));
        //}
    }

    /**
     * check if there is any shared domain in the y value.
     *
     * @param other a line.
     * @return true if there is a shared, false otherwise.
     */
    public boolean inrangeY(Line other) {
        double thisMin = Math.min(this.start.getY(), this.end.getY());
        double thisMax = Math.max(this.start.getY(), this.end.getY());
        double otherMin = Math.min(other.start.getY(), other.end.getY());
        double otherMax = Math.max(other.start.getY(), other.end.getY());

        if (thisMin <= otherMin && otherMin <= thisMax) {
            return true;
        }
        return otherMin <= thisMin && thisMin <= otherMax;
    }

    /**
     * @param aOther the slope of the other line.
     * @param bOther the b value of the other line.
     * @param a      the slope value of this line.
     * @param b      the b value of the other line.
     * @return the x value of the intersection.
     */
    public double cutNoVertical(double aOther, double bOther, double a, double b) {
        //find the cut with this in this formula
        return (-(b - bOther) / (a - aOther));
    }

    /**
     * checking if 2 lines have only one cut between them can be vert of parallel.
     *
     * @param other a line.
     * @return yes if there is only one cut between two lines.
     */
    public boolean onlyOneCutWhenVert(Line other) {
        double thisMin = Math.min(this.start.getY(), this.end.getY());
        double thisMax = Math.max(this.start.getY(), this.end.getY());
        double otherMin = Math.min(other.start.getY(), other.end.getY());
        double otherMax = Math.max(other.start.getY(), other.end.getY());
        //checking that there only one cut when ישר look like x=number;

        if (thisMax == otherMin || thisMin == otherMax) {
            return true;
        }
        return false;
    }


    /**
     * return if two line are intersecting.
     *
     * @param other a line.
     * @return return yes if they are intersecting, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        //if one of them is vertical
        if (this.isVertical() && other.isVertical()) {
            //if both have the same x;
            if (this.start.getX() == other.start.getX() && inrangeY(other)) {
                if (onlyOneCutWhenVert(other)) {
                    return true;
                }
            }
            return false;
        }
        if (this.isVertical()) {
            double aOther = other.slpoe();
            double bOther = other.findB(aOther);
            //find the x  by futing him in the secend equaison
            // double Xcut = (this.start.getX() * A_other) + B_other;
            double xCut = this.start.getX();
            double yCut = xCut * aOther + bOther;
            double min = Math.min(this.start.getY(), this.end.getY());
            double max = Math.max(this.start.getY(), this.end.getY());
            if (min <= yCut && yCut <= max && this.inrangeX(other, xCut)) {
                return true;
            }
            return false;
        }
        if (other.isVertical()) {
            double a = this.slpoe();
            double b = this.findB(a);
            //  double Xcut = ((other.start.getX() * a) + b);
            double xCut = other.start.getX();
            double yCut = (xCut * a) + b;
            double min = Math.min(other.start.getY(), other.end.getY());
            double max = Math.max(other.start.getY(), other.end.getY());
            if (min <= yCut && yCut <= max && this.inrangeX(other, xCut)) {
                return true;
            }
            return false;
        }
        double aOther = other.slpoe();
        double bOther = other.findB(aOther);
        double a = this.slpoe();
        double b = this.findB(a);


        if (this.equals(other)) {
            return true;
        }
        //makbil

        double xCut = cutNoVertical(aOther, bOther, a, b);
        //if its parallel
        if (a == 0 && inrangeX(this, xCut) && inrangeX(other, xCut)) {
            double yCut = (xCut * aOther) + bOther;
            if (Math.abs(b - yCut) < Math.pow(10, -10)) {
                return true;
            }
            return false;

            // if other line is parallel.
        } else if (aOther == 0) {
            double yCut = (xCut * a) + b;
            return Math.abs(bOther - yCut) < Math.pow(10, -10) && inrangeX(this, xCut) && inrangeX(other, xCut);
        } else {
            return this.inrangeX(other, xCut);
        }

    }

    /**
     * return the  y coordinate point of intersect between two vertical lines .
     *
     * @param other other line.
     * @return y coordinate.
     */
    public double sameY(Line other) {

        double thisMin = Math.min(this.start.getY(), this.end.getY());
        double thisMax = Math.max(this.start.getY(), this.end.getY());
        double otherMin = Math.min(other.start.getY(), other.end.getY());
        double otherMax = Math.max(other.start.getY(), other.end.getY());
        if (thisMax == otherMin) {
            return thisMax;
        }
        if (thisMin == otherMax) {
            return thisMin;
        }
        return 0;
    }

    /**
     * return if there is intersection between two lines.
     *
     * @param other another line
     * @return if there is return the cordinate of the intersection and if not return null.
     */
    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    public Point intersectionWith(Line other) {
        if (this.isIntersecting(other)) {
            if (this.isVertical() && other.isVertical()) {
                // if its vetrical.
                if (onlyOneCutWhenVert(other)) {
                    if (this.start.equals(other.start)) {
                        return start;
                    }
                    if (this.start.equals(other.end)) {
                        return start;
                    }
                    return end;
                }
            }
            if (this.isVertical()) {
                double aOther = other.slpoe();
                double bOther = other.findB(aOther);
                //find the x  by putting the answer in the second equation
                double xCut = this.start.getX();
                double yCut = xCut * aOther + bOther;
                Point cut = new Point(xCut, yCut);
                return cut;
            }
            if (other.isVertical()) {
                double a = this.slpoe();
                double b = this.findB(a);
                double xCut = other.start.getX();
                double yCut = (xCut * a) + b;
                Point cut = new Point(xCut, yCut);
                return cut;
            }
            double aOther = other.slpoe();
            double bOther = other.findB(aOther);
            double a = this.slpoe();
            double b = this.findB(a);
            if (this.start.equals(other.start) && this.end.equals(other.end)) {
                return null;
            }
            //if both of the lines are in form y= number
            if (this.onlyOneCutWhenVert(other) && a == aOther && a == 0) {
                if (this.start.equals(other.start)) {
                    return start;
                }
                if (this.start.equals(other.end)) {
                    return start;
                }
                return end;
            }
            if (a == aOther && b == bOther) {
                //check if one line Contained in the other in (range).
                Point closeOtherstart = new Point(other.start.getX() + Math.pow(10, -10), other.start.getY()
                        + Math.pow(10, -10));
                Point closeThisStart = new Point(this.start.getX() + Math.pow(10, -10), this.start.getY()
                        + Math.pow(10, -10));
                //if one line  in the other line. for exampe one line i y=x in the range 1-10 and the
                // other is y=x in rang 1-6
                if ((this.pointInLine(other.start) && this.pointInLine(closeOtherstart))
                        || (other.pointInLine(this.start)) && other.pointInLine(closeThisStart)) {
                    return null;

                }
            }
            Double xCut = cutNoVertical(aOther, bOther, a, b);
            double yCut = (xCut * a) + b;
            Point cut = diffenceNoSignifcant(other, xCut, yCut);


            return cut;
        }
        return null;
    }

    /**
     * check if the diffence between the points is no significant.
     *
     * @param other other line
     * @param xCut  x value of the cut
     * @param yCut  y value of the cut
     * @return the point of the cut
     */
    public Point diffenceNoSignifcant(Line other, double xCut, Double yCut) {
        if (Math.abs(this.start.getX() - xCut) < Math.pow(10, -10)) {
            xCut = this.start.getX();
        }
        if (Math.abs(other.start.getX() - xCut) < Math.pow(10, -10)) {
            xCut = other.start.getX();
        }
        if (Math.abs(this.end.getX() - xCut) < Math.pow(10, -10)) {
            xCut = this.end.getX();
        }
        if (Math.abs(other.end.getX() - xCut) < Math.pow(10, -10)) {
            xCut = other.end.getX();
        }
        if (Math.abs(this.start.getY() - yCut) < Math.pow(10, -10)) {
            yCut = this.start.getY();
        }
        if (Math.abs(other.start.getY() - yCut) < Math.pow(10, -10)) {
            yCut = other.start.getY();
        }
        if (Math.abs(this.end.getY() - yCut) < Math.pow(10, -10)) {
            yCut = this.end.getY();
        }
        if (Math.abs(other.end.getY() - yCut) < Math.pow(10, -10)) {
            yCut = other.end.getY();
        }
        Point p = new Point(xCut, yCut);
        return p;
    }


    /**
     * get a line and return if both line are equals or no.
     *
     * @param other another line.
     * @return return true if the are the same line.
     */
    public boolean equals(Line other) {
        double aOther = other.slpoe();
        double bOther = other.findB(aOther);
        double a = this.slpoe();
        double b = this.findB(aOther);
        //if paralel
        if (a == aOther) {

            if (b == bOther) {
                if (a == 0 && aOther == 0) {
                    return this.end.getX() == other.end.getX() || this.start.getX() == other.end.getX();
                }
                return true;
            }
        }
        return false;
    }

    /**
     * return the closest point to the start of the line.
     *
     * @param rect a rectangle.
     * @return the closest point to the start of the line
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        // we generate a list of intersection points with the rectangle
        List<Point> list = rect.intersectionPoints(this);

        // we check if the intersections exist
        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() == 2) {
            if (list.get(0).distance(this.start) < list.get(1).distance(this.start)) {
                return list.get(0);
            }

        }
        return list.get(1);
    }

    /**
     * this function check if point is in a given line.
     *
     * @param p point.
     * @return true if in line.
     */
    public boolean pointInLine(Point p) {
        double miny = Math.min(this.start.getY(), this.end.getY());
        double maxY = Math.max(this.start.getY(), this.end.getY());
        return p.getX() >= this.start.getX() && p.getX() <= this.end.getX() && p.getY() >= miny && p.getY() <= maxY;

    }


/*
        shapes.Point closest = this.end;

        // we set the minimal distance to be at first the length of the line
        double minDistance = this.length();
        for (shapes.Point point : list) {

            // we check if the distance from the start of the line to the point is smaller than the minimal
            if (this.start.distance(point) < minDistance) {
                minDistance = this.start.distance(point);
                closest.setX((int)Math.round(point.getX()));
                closest.setY((int)Math.round(point.getY()));
            }
        }
        return closest;
    }

 */

    /**
     * give a different angle to any region of the paddle.
     *
     * @param p
     * @return int angle
     */
    public int angleByRegion(Point p) {
        Point startPoint;
        if (this.start().getX() < this.end().getX()) {
            startPoint = this.start();
        } else {
            startPoint = this.end();
        }
        double distanceFromStart = p.distance(startPoint);
        double length = distanceFromStart / this.length();
        if (length < 0.2) {
            return 300;
        } else if (length < 0.4) {
            return 330;
        } else if (length < 0.6) {
            return 0;
        } else if (length < 0.8) {
            return 30;
        } else if (length < 1) {
            return 60;
        }
        return 0;
    }

}