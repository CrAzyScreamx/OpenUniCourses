package maman15;

public class Point
{
    private int _x;
    private int _y;

    public Point(final int x, final int y) {
        this._x = x;
        this._y = y;
    }

    public Point(final Point other) {
        this._x = other.getX();
        this._y = other.getY();
    }

    public int getX() {
        return this._x;
    }

    public int getY() {
        return this._y;
    }

    public void setX(final int num) {
        this._x = num;
    }

    public void setY(final int num) {
        this._y = num;
    }

    @Override
    public String toString() {
        return "(" + this._x + "," + this._y + ")";
    }

    public boolean equals(final Point other) {
        return other != null && this._x == other.getX() && this._y == other.getY();
    }

    public boolean isAbove(final Point other) {
        return this._y > other.getY();
    }

    public boolean isUnder(final Point other) {
        return other.isAbove(this);
    }

    public boolean isLeft(final Point other) {
        return this._x < other.getX();
    }

    public boolean isRight(final Point other) {
        return other.isLeft(this);
    }

    public double distance(final Point p) {
        return Math.sqrt((this._x - p.getX()) * (this._x - p.getX()) + (this._y - p.getY()) * (this._y - p.getY()));
    }

    public void move(final int deltaX, final int deltaY) {
        this._x += deltaX;
        this._y += deltaY;
    }
}