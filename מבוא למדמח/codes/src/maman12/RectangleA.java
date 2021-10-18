package maman12;

/**
* A class resposible of building a new Rectangle in a grid with Point class
* @author Amit Y
*/
public class RectangleA {

    private int _width;
    private int _height;
    private Point _pointSW;

    /*
    * Constructor used to create a new Rectangle using width and height
    * @param w - width of Rectangle
    * @param h - height of Rectangle
    */
    public RectangleA(int w, int h) {
        _pointSW = new Point(0, 0);
        if (w <= 0) _width = 1;
        else _width = w;
        if (h <= 0) _height = 1;
        else _height = h;
    }

    /*
    * Constructor used to create a new Rectangle using Point, width and height
    * @param p - South-West point
    * @param w - width of Rectangle
    * @param h - height of Rectangle
    */
    public RectangleA(Point p, int w, int h) {
        _pointSW = p;
        if (w <= 0) _width = 1;
        else _width = w;
        if (h <= 0) _height = 1;
        else _height = h;
    }

    /*
    * Constructor used to create a new Rectangle using two Points
    * @param sw - South-West point
    * @param ne - North-East point
    */
    public RectangleA(Point sw, Point ne) {
        _height = ne.getY() - sw.getY();
        _width = ne.getX() - sw.getX();
        _pointSW = sw;
    }

    /*
    * Constructor used to create a new Rectangle by copying attributes from another Rectangle
    * @param r - Another RectangleA
    */
    public RectangleA(RectangleA r) {
        _width = r.getWidth();
        _height = r.getHeight();
        _pointSW = r.getPointSW();
    }

    /*
    * Get the width of the Rectangle
    * @return width of RectangleA
    */
    public int getWidth() {
        return _width;
    }

    /*
    * Get the height of the Rectangle
    * @return height of RectangleA
    */
    public int getHeight() {
        return _height;
    }

    /*
    * Get the South-West Point of the Rectangle
    *
    */
    public Point getPointSW() {
        return _pointSW;
    }

    public void setWidth(int w) {
        if (w > 0) _width = w;
    }

    public void setHeight(int h) {
        if (h > 0) _height = h;
    }

    public void setPointSW(Point p) {
        _pointSW = p;
    }

    public String ToString() {
        return "Width=" + _width + " Height=" + _height + " PointSW=" + _pointSW;
    }

    public int getPerimeter() {
        return 2* (_width + _height);
    }

    public int getArea() {
        return _width * _height;
    }

    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
    }

    public boolean equals(RectangleA other) {
        return _width == other.getWidth() && _height == other.getHeight() && _pointSW.equals(other.getPointSW());
    }

    public double getDiagonalLength() {
        return _pointSW.distance(getPointNE());
    }

    public boolean isLarger(RectangleA other) {
        return this.getArea() > other.getArea();
    }

    public Point getPointNE() {
        return new Point(_pointSW.getX() + _width, _pointSW.getY() + _height);
    }

    public void changeSides() {
        int tempWidth = _width;
        _width = _height;
        _height = tempWidth;
    }

    public boolean isIn(RectangleA r) {
        return _pointSW.isRight(r.getPointSW()) && _pointSW.isAbove(r.getPointSW()) &&
                getPointNE().isLeft(r.getPointNE()) && getPointNE().isUnder(r.getPointNE());
    }

    public boolean overlap(RectangleA r) {
        Point rPointSW = r.getPointSW();
        Point rPointNE = r.getPointNE();
        return !(rPointSW.isRight(this.getPointNE()) || rPointSW.isAbove(this.getPointNE()) ||
                rPointNE.isUnder(_pointSW) || rPointNE.isLeft(_pointSW));
    }

}
