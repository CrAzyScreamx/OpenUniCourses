package maman12;

/**
* Creates new Point by (x,y)
* @author Amit Y

*/
public class Point {

    private int _x;
    private int _y;

    /*
    * Constructs a new Point using x,y coordinates
    * @param x - x coordinate of a point
    * @param y - y coordinate of a point
     */
    public Point(int x, int y) {
        _x = x;
        _y = y;
    }

    /*
    * Constructs a new Point by copying x,y coordinates of another point
    * @param other - another point which the code copies x,y coordinates from
    */
    public Point(Point other) {
        _x = other.getX();
        _y = other.getY();
    }

    /*
    * Getting the x coordinate of the point
    * @return - the x coordinate of Point
    */
    public int getX() {
        return _x;
    }

    /*
    * Getting the y coordinate of the point
    * @return - the y coordinate of Point
    */
    public int getY() {
        return _y;
    }

    /*
    * Setting the x coordinate to another number
    * @param num - the new x coordinate of Point
    */
    public void setX(int num) {
        _x = num;
    }

    /*
     * Setting the y coordinate to another number
     * @param num - the new y coordinate of Point
     */
    public void setY(int num) {
        _y = num;
    }

    /*
    * Overriding toString method, getting the sentence of the coordinate (x,y)
    * @return - sentence of (x,y) Point
    */
    public String toString() { return "(" + _x + "," + _y + ")"; }

    /*
    * Checks if one Point equals to another
    * @param other - Another Point
    * @return - if the Points are equal or not
    */
    public boolean equals(Point other) {
        return _x == other.getX() && _y == other.getY();
    }

    /*
    * Checks if this Point is above Point other
    * @param other - Another Point
    * @return - if this Point is above other Point
    */
    public boolean isAbove(Point other) {
        return _y > other.getY();
    }

    /*
    * Checks if this Point is Under Point other
    * @param other - another Point
    * @return - If this Point is under other Point
    */
    public boolean isUnder(Point other) {
        return !isAbove(other);
    }

    /*
    * Checks if this Point positioned left of Point other
    * @param other - Another Point
    * @return - if this Point is positioned left of Point other
    */
    public boolean isLeft(Point other) {
        return _x < other.getX();
    }

    /*
    * Checks if this Point positioned right of Point other
    * @param other - Another Point
    * @return - if this Point is positioned right of Point other
    */
    public boolean isRight(Point other) {
        return !isLeft(other);
    }

    /*
    * Moves Point by x,y coordinates
    * @param deltaX - move the x coordinate by deltaX
    * @param deltaY - move the y coordinate by deltaY
    */
    public void move(int deltaX, int deltaY) {
        _x += deltaX;
        _y += deltaY;
    }

    /*
    * Calculates the distance between two Point
    * @param p - Another Point
    * @return - the distance between two Points
    */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(_x - p.getX(), 2) + Math.pow(_y - p.getY(), 2));
    }



}
