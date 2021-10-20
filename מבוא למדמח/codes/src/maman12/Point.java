package maman12;

/**
 * Creates a point
 * @author Amit Y
 * @version 20/10/2021
 */
public class Point {

    private int _x;
    private int _y;

    /**
     * Constructs a point using x,y coordinates
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(int x, int y) {
        _x = x;
        _y = y;
    }

    /**
     * Constructs a point using another Point
     * @param other another Point
     */
    public Point(Point other) {
        _x = other.getX();
        _y = other.getY();
    }

    /**
     * Returns the x coordinate of this Point
     * @return x coordinate
     */
    public int getX() {
        return _x;
    }

    /**
     * Returns the y coordinate of this Point
     * @return y coordinate
     */
    public int getY() {
        return _y;
    }

    /**
     * Sets the x coordinate to a new coordinate
     * @param num new x coordinate
     */
    public void setX(int num) {
        _x = num;
    }

    /**
     * Sets the y coordinate to a new coordinate
     * @param num new y coordinate
     */
    public void setY(int num) {
        _y = num;
    }

    /**
     * Returns the coordinate as (x,y) format
     * @return x,y coordinates as (x,y) format
     */
    public String toString() { return "(" + _x + "," + _y + ")"; }

    /**
     * Checks if this point equals another point
     * @param other Another Point
     * @return if this point equals other point
     */
    public boolean equals(Point other) {
        return _x == other.getX() && _y == other.getY();
    }

    /**
     * Checks if this point is above another point
     * @param other Another Point
     * @return if this Point above other Point
     */
    public boolean isAbove(Point other) {
        return _y > other.getY();
    }

    /**
     * Checks if this point is under another point
     * @param other Another Point
     * @return if this Point under other Point
     */
    public boolean isUnder(Point other) {
        return !isAbove(other);
    }

    /**
     * Checks if this point is left from another point
     * @param other Another Point
     * @return if this Point is left from other Point
     */
    public boolean isLeft(Point other) {
        return _x < other.getX();
    }

    /**
     * Checks if this point is right from another point
     * @param other Another Point
     * @return if this Point is right from other Point
     */
    public boolean isRight(Point other) {
        return !isLeft(other);
    }

    /**
     * Moves this point to another x,y coordinates
     * @param deltaX new x coordinate
     * @param deltaY new y coordinate
     */
    public void move(int deltaX, int deltaY) {
        _x += deltaX;
        _y += deltaY;
    }

    /**
     * Checks distance between two points
     * @param p Another Point
     * @return distance between this Point and p Point
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(_x - p.getX(), 2) + Math.pow(_y - p.getY(), 2));
    }



}
