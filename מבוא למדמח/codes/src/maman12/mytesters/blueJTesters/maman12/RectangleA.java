/**
 * Creates a new Rectangle
 * @author Amit Y
 * @version 20/10/2021
 */
public class RectangleA {

    private int _width;
    private int _height;
    private Point _pointSW;

    /**
     * Constructs a RectangleA using width and height
     * @param w width of the Rectangle
     * @param h height of the Rectangle
     */
    public RectangleA(int w, int h) {
        _pointSW = new Point(0, 0);
        if (w <= 0) _width = 1;
        else _width = w;
        if (h <= 0) _height = 1;
        else _height = h;
    }

    /**
     * Constructs a RectangleA using point, width and height
     * @param p point from class Point
     * @param w width
     * @param h height
     */
    public RectangleA(Point p, int w, int h) {
        _pointSW = new Point(p);
        if (w <= 0) _width = 1;
        else _width = w;
        if (h <= 0) _height = 1;
        else _height = h;
    }

    /**
     * Constructs a RectangleA using south-west and north-east points
     * @param sw point from class Point
     * @param ne point from class Point
     */
    public RectangleA(Point sw, Point ne) {
        _height = ne.getY() - sw.getY();
        _width = ne.getX() - sw.getX();
        _pointSW = new Point(sw);
    }

    /**
     * Constructs a RectangleA using another Rectangle from RectangleA class
     * @param r rectangle from RectangleA class
     */
    public RectangleA(RectangleA r) {
        _width = r.getWidth();
        _height = r.getHeight();
        _pointSW = r.getPointSW();
    }

    /**
     * Gets the width of the Rectangle
     * @return width
     */
    public int getWidth() {
        return _width;
    }

    /**
     * Gets the height of the Rectangle
     * @return height
     */
    public int getHeight() {
        return _height;
    }

    /**
     * Gets the South-West point of the Rectangle
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
        if (w > 0) _width = w;
    }

    /**
     * Sets the height of the Rectangle
     * @param h new height
     */
    public void setHeight(int h) {
        if (h > 0) _height = h;
    }

    /**
     * Sets a new South-West point for the Rectangle
     * @param p new point from Point class
     */
    public void setPointSW(Point p) {
        _pointSW = new Point(p);
    }

    /**
     * Gets the information of the Rectangle
     * @return information as "Width=w Height=h" format
     */
    public String toString() {
        return ("Width=" + _width + " Height=" + _height + " PointSW=" + _pointSW);
    }

    /**
     * Gets the Perimeter of the Rectangle
     * @return Perimeter of Rectangle
     */
    public int getPerimeter() {
        return 2* (_width + _height);
    }

    /**
     * Gets the Area of the Rectangle
     * @return Area of Rectangle
     */
    public int getArea() {
        return _width * _height;
    }

    /**
     * Moves the Rectangle to another place
     * @param deltaX new x coordinate
     * @param deltaY new y coordinate
     */
    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
    }

    /**
     * Checks if this Rectangle equals another Rectangle
     * @param other Rectangle of RectangleA class
     * @return if this Rectangle equals other Rectangle
     */
    public boolean equals(RectangleA other) {
        return _width == other.getWidth() && _height == other.getHeight() && _pointSW.equals(other.getPointSW());
    }

    /**
     * Gets the diagonal length of the Rectangle
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
    public boolean isLarger(RectangleA other) {
        return this.getArea() > other.getArea();
    }

    /**
     * Gets the North-East Point of the Rectangle
     * @return north-east point as Point class
     */
    public Point getPointNE() {
        return new Point(_pointSW.getX() + _width, _pointSW.getY() + _height);
    }

    /**
     * Switches between the width and height of the Rectangle
     */
    public void changeSides() {
        int tempWidth = _width;
        _width = _height;
        _height = tempWidth;
    }

    /**
     * Checks if this Rectangle is in another Rectangle
     * @param r Another Rectangle
     * @return if this RectangleA is in r RectangleA
     */
    public boolean isIn(RectangleA r){
        return !(_pointSW.isLeft(r.getPointSW()) || _pointSW.isUnder(r.getPointSW()) ||
                this.getPointNE().isRight(r.getPointNE()) || this.getPointNE().isAbove(r.getPointNE()));
    }

    /**
     * Checks if this Rectangle overlaps another Rectangle
     * @param r Another Rectangle
     * @return if this RectangleA overlaps r RectangleA
     */
    public boolean overlap(RectangleA r) {
        Point rPointSW = r.getPointSW();
        Point rPointNE = r.getPointNE();
        return !(rPointSW.isRight(this.getPointNE()) || rPointSW.isAbove(this.getPointNE()) ||
                rPointNE.isUnder(_pointSW) || rPointNE.isLeft(_pointSW));
    }

}
