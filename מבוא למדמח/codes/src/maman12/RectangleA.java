package maman12;

/**
 * Creates a new Rectangle
 * @author Amit Y
 * @version 20/10/2021
 */
public class RectangleA {

    private int _width;
    private int _height;
    private Point _pointSW;
    private final int MIN_VALUE = 0;
    private final int DEF_VALUE = 1;

    /**
     * First constructor for objects of class RectangleA Constructs a new rectangle with the specified width, height and it's south west corner is (0,0)
     * @param w The rectangle width
     * @param h The rectangle height
     */
    public RectangleA(int w, int h) {
        _pointSW = new Point(0, 0);
        if (w <= MIN_VALUE) {
            _width = DEF_VALUE;
        } else {
            _width = w;
        }
        if (h <= MIN_VALUE) {
            _height = DEF_VALUE;
        } else {
            _height = h;
        }
    }

    /**
     * Second constructor for objects of class RectangleA Construct a new rectangle with the specified width, height and south west vertex
     * @param p south western vertex
     * @param w rectangle width
     * @param h rectangle height
     * @see Point
     */
    public RectangleA(Point p, int w, int h) {
        this(w, h);
        _pointSW = new Point(p);
    }

    /**
     * Third constructor for objects of class RectangleA Construct a new rectangle with the specified south west vertex and north east vertex
     * @param sw south western vertex
     * @param ne north eastern vertex
     */
    public RectangleA(Point sw, Point ne) {
        this(sw,ne.getX() - sw.getX(), ne.getY() - sw.getY());
    }

    /**
     * Copy constructor for objects of class RectangleA Constructs a rectangle using another rectangle
     * @param r The rectangle from which to construct the new object
     */
    public RectangleA(RectangleA r) {
        this(r._pointSW, r.getWidth(), r.getHeight());
    }

    /**
     * Returns the width of the rectangle
     * @return the width of the rectangle
     */
    public int getWidth() {
        return _width;
    }

    /**
     * Returns the height of the rectangle
     * @return the height of the rectangle
     */
    public int getHeight() {
        return _height;
    }

    /**
     * Returns the South-West point of the rectangle
     * @return a copy of the s-w point of the rectangle
     */
    public Point getPointSW() {
        return new Point(_pointSW);
    }

    /**
     * Sets the width of the rectangle
     * @param w the width of the rectangle to set to
     */
    public void setWidth(int w) {
        if (w > MIN_VALUE) _width = w;
    }

    /**
     * Sets the height of the rectangle
     * @param h the height of the rectangle to set to
     */
    public void setHeight(int h) {
        if (h > MIN_VALUE) _height = h;
    }

    /**
     * Sets the South-West point of the rectangle
     * @param p the S-W point of the rectangle to set to
     */
    public void setPointSW(Point p) {
        _pointSW = new Point(p);
    }

    /**
     * Returns a string representation of the rectangle
     * @return a string represent the rectangle For example: Width=4 Height=6 PointSW=(1,2)
     */
    public String toString() {
        return ("Width=" + _width + " Height=" + _height + " PointSW=" + _pointSW);
    }

    /**
     * Calculates the perimeter of the rectangle
     * @return The perimeter of the rectangle.
     */
    public int getPerimeter() {
        return 2* (_width + _height);
    }

    /**
     * Calculates the area of the rectangle
     * @return The area of the rectangle.
     */
    public int getArea() {
        return _width * _height;
    }

    /**
     * Move the rectangle by deltaX in x direction and deltaY in y direction
     * @param deltaX translate the rectangle deltaX in the x direction.
     * @param deltaY translate the rectangle deltaY in the y direction.
     */
    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
    }

    /**
     * Returns true iff the given rectangle is equal to this rectangle
     * @param other the rectangle to check equality with
     * @return true iff other and this rectangle are equal
     */
    public boolean equals(RectangleA other) {
        return _width == other._width && _height == other._height && _pointSW.equals(other.getPointSW());
    }

    /**
     * Returns the length of the rectangle diagonal
     * @return the length of the diagonal of the Rectangle
     */
    public double getDiagonalLength() {
        return _pointSW.distance(getPointNE());
    }

    /**
     * Returns true if the current rectangle is larger than the parameter rectangle
     * @param other another Rectangle to compare with
     * @return true - if the current Rectangle's area is larger than the other Rectangle which recieved as parameter, false - otherwise
     */
    public boolean isLarger(RectangleA other) {
        return this.getArea() > other.getArea();
    }

    /**
     * Returns the North-East point of the rectangle
     * @return a copy of the North-East point of the Rectangle
     */
    public Point getPointNE() {
        return new Point(_pointSW.getX() + _width, _pointSW.getY() + _height);
    }

    /**
     * Changes the width to height and vice versa
     */
    public void changeSides() {
        int tempWidth = _width;
        _width = _height;
        _height = tempWidth;
    }

    /**
     * Returns true if the current rectangle is in the parameter rectangle
     * @param r another Rectangle to check with
     * @return true - if the current Rectangle's completly in the other Rectangle which recieved as parameter, false - otherwise
     */
    public boolean isIn(RectangleA r){
        return !(_pointSW.isLeft(r.getPointSW()) || _pointSW.isUnder(r.getPointSW()) ||
                this.getPointNE().isRight(r.getPointNE()) || this.getPointNE().isAbove(r.getPointNE()));
    }

    /**
     * Returns true if the current rectangle overlaps with the parameter rectangle
     * @param r another Rectangle to check with
     * @return true - if the current Rectangle's overlaps with the other Rectangle which recieved as parameter even by a single point, false - otherwise
     */
    public boolean overlap(RectangleA r) {
        Point rPointSW = r.getPointSW();
        Point rPointNE = r.getPointNE();
        return !(rPointSW.isRight(this.getPointNE()) || rPointSW.isAbove(this.getPointNE()) ||
                rPointNE.isUnder(_pointSW) || rPointNE.isLeft(_pointSW));
    }

}
