package maman12;

/**
 * Creates a new Rectangle
 * @author Amit Y
 * @version 20/10/2021
 */
public class RectangleB {

    private Point _pointSW;
    private Point _pointNE;

    /**
     * Constructs a new Rectangle using width and height
     * @param w width
     * @param h height
     */
    public RectangleB(int w, int h) {
        _pointSW = new Point(0,0);
        _pointNE = new Point(w, h);
    }

    /**
     * Constructs a new Rectangle using Point, width and height
     * @param p point of Point class
     * @param w width
     * @param h height
     */
    public RectangleB(Point p, int w, int h) {
        _pointSW = new Point(p);
        _pointNE = new Point(p.getX() + w, p.getY() + h);
    }

    /**
     * Constructs a new Rectangle using south-west and north-east points
     * @param sw south-west point
     * @param ne north-east point
     */
    public RectangleB(Point sw, Point ne) {
        _pointSW = new Point(sw);
        _pointNE = new Point(ne);
    }

    /**
     * Constructs a new Rectangle using another Rectangle
     * @param r Another Rectangle
     */
    public RectangleB(RectangleB r) {
        _pointSW = new Point(r.getPointSW());
        _pointNE = new Point(r.getPointNE());
    }

    /**
     * Returns the width of the Rectangle
     * @return width of Rectangle
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
        if (w > 0) {
            int yPointNE = _pointNE.getY();
            _pointNE = new Point(_pointSW.getX() + w, yPointNE);
        }
    }

    /**
     * Sets the height of the Rectangle
     * @param h new height
     */
    public void setHeight(int h) {
        if (h > 0) {
            int xPointNE = _pointNE.getX();
            _pointNE = new Point(xPointNE, _pointSW.getY() + h);
        }
    }

    /**
     * Sets a new South-West point for the Rectangle
     * @param p new point from Point class
     */
    public void setPointSW(Point p) {
        _pointSW = p;
    }

    /**
     * Returns the information of the Rectangle
     * @return information as "Width=w Height=h" format
     */
    public String toString() {

        return "Width=" + getWidth() + " Height=" + getHeight();
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
        int w = getWidth();
        int h = getHeight();
        _pointNE = new Point(_pointSW.getY() + h, _pointSW.getX() + w);
    }

    /**
     * Checks if this Rectangle is in another Rectangle
     * @param r Another Rectangle
     * @return if this RectangleA is in r RectangleA
     */
    public boolean isIn(RectangleB r) {
        return _pointSW.isRight(r.getPointSW()) && _pointSW.isAbove(r.getPointSW()) &&
                getPointNE().isLeft(r.getPointNE()) && getPointNE().isUnder(r.getPointNE());
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
