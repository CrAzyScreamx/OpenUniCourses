package maman12;

/**
 * Creates a new Rectangle
 * @author Amit Y
 * @version 20/10/2021
 */
public class RectangleB {

    private Point _pointSW;
    private Point _pointNE;
    private final int DEFAULT_VALUE = 1;
    private final int MIN_VALUE = 0;

    /**
     * First constructor for objects of class RectangleB Constructs a new rectangle with the specified width, height and it's south west corner is (0,0)
     * @param w The rectangle width
     * @param h The rectangle height
     */
    public RectangleB(int w, int h) {
        _pointSW = new Point(0,0);
        _pointNE = new Point(Math.max(DEFAULT_VALUE, w), Math.max(DEFAULT_VALUE, h)); // Uses Math library to check if width and height are greater than 0
    }

    /**
     * Second constructor for objects of class RectangleB Constructs a new rectangle with the specified vertices
     * @param p south western vertex
     * @param w rectangle width
     * @param h rectangle height
     * @see Point
     */
    public RectangleB(Point p, int w, int h) {
        this(w, h);
        _pointSW = new Point(p);
        _pointNE.move(p.getX(), p.getY());
    }

    /**
     * Third constructor for objects of class RectangleB Constructs a new rectangle with the specified vertices
     * @param sw south western vertex
     * @param ne north eastern vertex
     * @see Point
     */
    public RectangleB(Point sw, Point ne) {
        _pointSW = new Point(sw);
        _pointNE = new Point(ne);
    }

    /**
     * Copy constructor for objects of class RectangleB Constructs a rectangle using another rectangle
     * @param r The rectangle from which to construct the new object
     */
    public RectangleB(RectangleB r) {
        this(r._pointSW, r._pointNE);
    }

    /**
     * Returns the South-West point of the rectangle
     * @return a copy of the s-w point of the rectangle
     */
    public int getWidth() {
        return _pointNE.getX() - _pointSW.getX();
    }

    /**
     * Returns the height of the Rectangle
     * @return height
     */
    public int getHeight() {
        return _pointNE.getY() - _pointSW.getY();
    }

    /**
     * Returns the South-West point of the Rectangle
     * @return south-west point
     */
    public Point getPointSW() {
        return new Point(_pointSW);
    }

    /**
     * Sets the width of the Rectangle
     * @param w new width
     */
    public void setWidth(int w) {
        if (w > MIN_VALUE) {
            _pointNE.setX(_pointSW.getX() + w);
        }
    }

    /**
     * Sets the height of the Rectangle
     * @param h new height
     */
    public void setHeight(int h) {
        if (h > MIN_VALUE) {
            _pointNE.setY(_pointSW.getY() + h);
        }
    }

    /**
     * Sets a new South-West point for the Rectangle
     * @param p new point from Point class
     */
    public void setPointSW(Point p) {
        _pointNE = new Point(p.getX() + getWidth(), p.getY() + getHeight());
        _pointSW = new Point(p);
    }

    /**
     * Returns the information of the Rectangle
     * @return information as "Width=w Height=h" format
     */
    public String toString() {

        return "Width=" + getWidth() + " Height=" + getHeight() + " PointSW=" + getPointSW();
    }

    /**
     * Returns the Perimeter of the Rectangle
     * @return Perimeter of Rectangle
     */
    public int getPerimeter() {
        return 2*(getWidth() + getHeight());
    }

    /**
     * Returns the Area of the Rectangle
     * @return Area of Rectangle
     */
    public int getArea() {
        return getWidth() * getHeight();
    }

    /**
     * Moves the Rectangle to another place
     * @param deltaX new x coordinate
     * @param deltaY new y coordinate
     */
    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
        _pointNE.move(deltaX, deltaY);
    }

    /**
     * Checks if this Rectangle equals another Rectangle
     * @param other Rectangle of RectangleA class
     * @return if this Rectangle equals other Rectangle
     */
    public boolean equals(RectangleB other) {
        return _pointSW.equals(other.getPointSW()) && _pointNE.equals(other.getPointNE());
    }

    /**
     * Returns the diagonal length of the Rectangle
     * @return Diagonal length
     */
    public double getDiagonalLength() {
        return _pointSW.distance(getPointNE());
    }

    /**
     * Checks if this Rectangle is Larger than another Rectangle
     * @param other Rectangle of RectangleA class
     * @return if this RectangleA is larger than other RectangleA
     */
    public boolean isLarger(RectangleB other) {
        return this.getArea() > other.getArea();
    }

    /**
     * Returns the North-East Point of the Rectangle
     * @return north-east point as Point class
     */
    public Point getPointNE() {
        return new Point(_pointNE);
    }

    /**
     * Switches between the width and height of the Rectangle
     */
    public void changeSides() {
        int w = getWidth(); // width of the Rectangle
        int h = getHeight(); // height of the Rectangle
        setWidth(h);
        setHeight(w);
    }

    /**
     * Checks if this Rectangle is in another Rectangle
     * @param r Another Rectangle
     * @return if this RectangleA is in r RectangleA
     */
    public boolean isIn(RectangleB r){
        return !(_pointSW.isLeft(r.getPointSW()) || _pointSW.isUnder(r.getPointSW()) ||
                this.getPointNE().isRight(r.getPointNE()) || this.getPointNE().isAbove(r.getPointNE()));
        //
    }

    /**
     * Checks if this Rectangle overlaps another Rectangle
     * @param r Another Rectangle
     * @return if this RectangleA overlaps r RectangleA
     */
    public boolean overlap(RectangleB r) {
        Point rPointSW = r.getPointSW();
        Point rPointNE = r.getPointNE();
        return !(rPointSW.isRight(this.getPointNE()) || rPointSW.isAbove(this.getPointNE()) ||
                rPointNE.isUnder(_pointSW) || rPointNE.isLeft(_pointSW));
    }
}
