package maman12;

public class RectangleB {

    private Point _pointSW;
    private Point _pointNE;

    public RectangleB(int w, int h) {
        _pointSW = new Point(0,0);
        _pointNE = new Point(w, h);
    }

    public RectangleB(Point p, int w, int h) {
        _pointSW = p;
        _pointNE = new Point(p.getX() + w, p.getY() + h);
    }

    public RectangleB(Point sw, Point ne) {
        _pointSW = sw;
        _pointNE = ne;
    }

    public RectangleB(RectangleB r) {
        _pointSW = r.getPointSW();
        _pointNE = r.getPointNE();
    }

    public int getWidth() {
        return _pointNE.getX() - _pointSW.getX();
    }

    public int getHeight() {
        return _pointNE.getY() - _pointSW.getY();
    }

    public Point getPointSW() {
        return _pointSW;
    }

    public void setWidth(int w) {
        if (w > 0) {
            int yPointNE = _pointNE.getY();
            _pointNE = new Point(_pointSW.getX() + w, yPointNE);
        }
    }

    public void setHeight(int h) {
        if (h > 0) {
            int xPointNE = _pointNE.getX();
            _pointNE = new Point(xPointNE, _pointSW.getY() + h);
        }
    }

    public void setPointSW(Point p) {
        _pointSW = p;
    }

    public String toString() {

        return "Width=" + getWidth() + " Height=" + getHeight();
    }

    public int getPerimeter() {
        return 2*(getWidth() + getHeight());
    }

    public int getArea() {
        return getWidth() * getHeight();
    }

    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
        _pointNE.move(deltaX, deltaY);
    }

    public boolean equals(RectangleB other) {
        return _pointSW.equals(other.getPointSW()) && _pointNE.equals(other.getPointNE());
    }

    public double getDiagonalLength() {
        return _pointSW.distance(getPointNE());
    }

    public boolean isLarger(RectangleB other) {
        return this.getArea() > other.getArea();
    }

    public Point getPointNE() {
        return _pointNE;
    }

    public void changeSides() {
        int w = getWidth();
        int h = getHeight();
        _pointNE = new Point(_pointSW.getY() + h, _pointSW.getX() + w);
    }

    public boolean isIn(RectangleB r) {
        return _pointSW.isRight(r.getPointSW()) && _pointSW.isAbove(r.getPointSW()) &&
                getPointNE().isLeft(r.getPointNE()) && getPointNE().isUnder(r.getPointNE());
    }

    public boolean overlap(RectangleB r) {
        Point rPointSW = r.getPointSW();
        Point rPointNE = r.getPointNE();
        return !(rPointSW.isRight(this.getPointNE()) || rPointSW.isAbove(this.getPointNE()) ||
                rPointNE.isUnder(_pointSW) || rPointNE.isLeft(_pointSW));
    }
}
