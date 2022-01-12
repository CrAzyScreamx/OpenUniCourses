package maman15;

public class RectangleA
{
    private int _width;
    private int _height;
    private Point _pointSW;
    private final int MIN_VAL = 1;

    public RectangleA(final int w, final int h) {
        this._width = ((w >= 1) ? w : 1);
        this._height = ((h >= 1) ? h : 1);
        this._pointSW = new Point(0, 0);
    }

    public RectangleA(final Point p, final int w, final int h) {
        this._width = ((w >= 1) ? w : 1);
        this._height = ((h >= 1) ? h : 1);
        this._pointSW = new Point(p);
    }

    public RectangleA(final Point sw, final Point ne) {
        this._width = ne.getX() - sw.getX();
        this._height = ne.getY() - sw.getY();
        this._pointSW = new Point(sw);
    }

    public RectangleA(final RectangleA r) {
        this._width = r._width;
        this._height = r._height;
        this._pointSW = new Point(r._pointSW);
    }

    public int getWidth() {
        return this._width;
    }

    public int getHeight() {
        return this._height;
    }

    public Point getPointSW() {
        return new Point(this._pointSW);
    }

    public void setWidth(final int w) {
        if (w >= 1) {
            this._width = w;
        }
    }

    public void setHeight(final int h) {
        if (h >= 1) {
            this._height = h;
        }
    }

    public void setPointSW(final Point p) {
        this._pointSW = new Point(p);
    }

    @Override
    public String toString() {
        return "Width=" + this._width + " Height=" + this._height + " PointSW=" + this._pointSW;
    }

    public int getPerimeter() {
        return 2 * this.getWidth() + 2 * this.getHeight();
    }

    public int getArea() {
        return this.getWidth() * this.getHeight();
    }

    public void move(final int deltaX, final int deltaY) {
        this._pointSW.move(deltaX, deltaY);
    }

    public boolean equals(final RectangleA other) {
        return other != null && this._width == other.getWidth() && this._height == other.getHeight() && this._pointSW.equals(other.getPointSW());
    }

    public double getDiagonalLength() {
        return this.getPointNE().distance(this.getPointSW());
    }

    public boolean isLarger(final RectangleA other) {
        return this.getArea() > other.getArea();
    }

    public Point getPointNE() {
        return new Point(this._pointSW.getX() + this._width, this._pointSW.getY() + this._height);
    }

    public void changeSides() {
        final int temp = this._width;
        this._width = this._height;
        this._height = temp;
    }

    public boolean isIn(final RectangleA r) {
        return !this.getPointNE().isRight(r.getPointNE()) && !this.getPointNE().isAbove(r.getPointNE()) && !this.getPointSW().isUnder(r.getPointSW()) && !this.getPointSW().isLeft(r.getPointSW());
    }

    public boolean overlap(final RectangleA r) {
        return !this.getPointSW().isRight(r.getPointNE()) && !this.getPointNE().isLeft(r.getPointSW()) && !this.getPointNE().isUnder(r.getPointSW()) && !this.getPointSW().isAbove(r.getPointNE());
    }
}