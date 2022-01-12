public class RectList {

    private RectNode _head;

    public RectList() {
        _head = null;
    }

    public void addRect(RectangleA r) {
        if (isEmptyList()) {
            _head = new RectNode(r);
        }
        else {
            RectNode _temp = _head;
            while (_temp.getNext() != null) {
                if (_temp.getRect().equals(r)) {
                    return;
                }
                _temp = _temp.getNext();
            }
            _temp.setNext(new RectNode(r));
        }
    }

    public int howManyWithPoint(Point p) {
        int countPoints = 0;
        if (isEmptyList()) {
            return countPoints;
        } else {
            RectNode _temp = _head;
            while (_temp != null) {
                Point rectPoint = _temp.getRect().getPointSW();
                if (rectPoint.equals(p)) {
                    countPoints+=1;
                }
                _temp = _temp.getNext();
            }
        }
        return countPoints;
    }

    public double longestDiagonal() {
        double longestDiag = 0;
        if (isEmptyList()) {
            return longestDiag;
        } else {
            RectNode _temp = _head;
            while (_temp != null) {
                double rectDiag = _temp.getRect().getDiagonalLength();
                if (rectDiag > longestDiag) {
                    longestDiag = rectDiag;
                }
                _temp = _temp.getNext();
            }
        }
        return longestDiag;
    }

    public Point mostLeftRect() {
        if (isEmptyList()) {
            return null;
        } else {
            RectNode _temp = _head;
            Point mostLeftPoint = _temp.getRect().getPointSW();
            while (_temp != null) {
                Point pointRect = _temp.getRect().getPointSW();
                if (pointRect.isLeft(mostLeftPoint)) {
                    mostLeftPoint = new Point(pointRect);
                }
                _temp = _temp.getNext();
            }
            return mostLeftPoint;
        }
    }

    public Point highestRect() {
        if (isEmptyList()) {
            return null;
        } else {
            RectNode _temp = _head;
            Point highestPoint = _temp.getRect().getPointNE();
            while (_temp != null) {
                Point pointRect = _temp.getRect().getPointNE();
                if (pointRect.isAbove(highestPoint)) {
                    highestPoint = new Point(pointRect);
                }
                _temp = _temp.getNext();
            }
            return highestPoint;
        }
    }

    public RectangleA minimalContainer() {
        if (isEmptyList()) {
            return null;
        } else {
            Point newPointSW = new Point(mostLeftRect().getX(), lowestRect().getY());
            Point newPointNE = new Point(mostRightRect().getX(), highestRect().getY());
            return new RectangleA(newPointSW, newPointNE);
        }
    }


    public String toString() {
        if (isEmptyList()) {
            return "The list has 0 rectangles.";
        } else {
            String rects = "";
            int rectCount = 0;
            RectNode _temp = _head;
            while (_temp != null) {
                rectCount += 1;
                rects += rectCount + ". " + _temp.getRect() + "\n";
                _temp = _temp.getNext();
            }
            return "The list has " + rectCount + " rectangles.\n" + rects;
        }
    }

    private Point lowestRect() {
        RectNode _temp = _head;
        Point lowestPoint = _temp.getRect().getPointSW();
        while (_temp != null) {
            Point pointRect = _temp.getRect().getPointSW();
            if (pointRect.isUnder(lowestPoint)) {
                lowestPoint = pointRect;
            }
            _temp = _temp.getNext();
        }
        return lowestPoint;
    }

    private Point mostRightRect() {
        RectNode _temp = _head;
        Point mostRightPoint = _temp.getRect().getPointNE();
        while (_temp != null) {
            Point pointRect = _temp.getRect().getPointNE();
            if (pointRect.isRight(mostRightPoint)) {
                mostRightPoint = pointRect;
            }
            _temp = _temp.getNext();
        }
        return new Point(mostRightPoint);
    }

    private boolean isEmptyList() {
        return _head == null;
    }
}

