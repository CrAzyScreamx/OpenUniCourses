package maman15;

public class RectList {

    private RectNode _head;

    /**
     * A constructor which initializes a new list, starting with null at the start
     * Time Complexity: O(1) - only one command is processed
     * Space Complexity: O(1) - only one value is initialized
     */
    public RectList() {
        _head = null;
    }

    /**
     * Adds a new RectNode to the list
     * @param r a new rectangle to add
     * Time Complexity: O(n) - There is one loop
     * Space Complexity: O(1) - 1 value is created
     */
    public void addRect(RectangleA r) {
        if (isEmptyList()) {
            _head = new RectNode(r);
            return; // If the list is empty it'll just skip everything else after initializing a new Node to the head
        }
        RectNode temp = _head;
        while (temp.getNext() != null) {
            if (temp.getRect().equals(r)) { // If it finds a rectangle it just stops the whilew
                return;
            }
            temp = temp.getNext();
        }
        // The while is processed until the last one but doesn't check if it equals so this statement is necessary
        if (!temp.getRect().equals(r)) {
            temp.setNext(new RectNode(r));
        }
    }

    /**
     * Counts how many rectangles have PointSW which equals to p Point
     * @param p point to compare with the rectangles
     * @return how many rectangles contains Point p as their PointSW
     * @see Point
     * Time Complexity: O(n) - There is one loop
     * Space Complexity: O(1) - two values are initialized
     */
    public int howManyWithPoint(Point p) {
        int countPoints = 0;
        RectNode temp = _head;
        while (temp != null) {
            Point rectPoint = temp.getRect().getPointSW();
            if (rectPoint.equals(p)) { // Checks if all points are equal to the point given
                countPoints+=1;
            }
            temp = temp.getNext();
        }
        return countPoints; // If there are no rectangles it won't process the loop, therefore it'll be just 0
    }

    /**
     * Returns the longest diagonal of the rectangles in the list
     * @return the longest diagonal
     * Time Complexity: O(n) - There is one loop
     * Space Complexity: O(1) - two values are initialized
     */
    public double longestDiagonal() {
        double longestDiag = 0;
        RectNode temp = _head;
        while (temp != null) {
            double rectDiag = temp.getRect().getDiagonalLength();
            longestDiag = Math.max(longestDiag, rectDiag); // Checks the largest diagonal using Math.max library
            temp = temp.getNext();
        }
        return longestDiag;
    }

    /**
     * Returns the South-West Point of the most left Rectangle in the list
     * @return the most left Point
     * Time Complexity: O(n) - There is one loop
     * Space Complexity: O(1) - two values are initialized
     */
    public Point mostLeftRect() {
        RectNode temp = _head;
        Point mostLeftPoint = null;
        while (temp != null) {
            Point pointRect = temp.getRect().getPointSW();
            if (mostLeftPoint == null || pointRect.isLeft(mostLeftPoint)) {
                // It checks if the mostLeftPoint is null to check if it's the first rectangle for first initialization
                mostLeftPoint = new Point(pointRect);
            }
            temp = temp.getNext();
        }
        return mostLeftPoint;
    }

    /**
     * Returns the North-East Point of the highest Rectangle in the list
     * @return the highest Point
     * Time Complexity: O(n) - There is one loop
     * Space Complexity: O(1) - two values are initialized
     */
    public Point highestRect() {
        RectNode temp = _head;
        Point highestPoint = null;
        while (temp != null) {
            Point pointRect = temp.getRect().getPointNE();
            if (highestPoint == null || pointRect.isAbove(highestPoint)) {
                // It checks if the highestPoint is null to check if it's the first rectangle for first initialization
                highestPoint = new Point(pointRect);
            }
            temp = temp.getNext();
        }
        return highestPoint;
    }

    /**
     * Returns the minimal Rectangle which can be created and contain all Rectangles from the list
     * @return minimal RectangleA rectangle which surrounds all rectangles
     * Time Complexity: O(n) - There are 4 loops but the 4 in 4n becomes n
     * Space Complexity: O(1) - two values are initialized
     */
    public RectangleA minimalContainer() {
        if (isEmptyList()) {
            return null;
        }
        /*
         * Created two function to get the mostRightRect and the lowestRect
         * From those function I get the rest of the coordinates to check the minimal Rectangle.
         */
        Point newPointSW = new Point(mostLeftRect().getX(), lowestRect().getY());
        Point newPointNE = new Point(mostRightRect().getX(), highestRect().getY());
        return new RectangleA(newPointSW, newPointNE);
    }

    /**
     * Returns a String of all the rectangles in the list printed in a shopping-list style.
     * @return a list of all the rectangles in the list
     * Time Complexity: O(n) - There is one loop
     * Space Complexity: O(1) - three values are initialized
     */
    public String toString() {
        String rects = "";
        int rectCount = 0;
        RectNode temp = _head;
        while (temp != null) {
            rectCount += 1;
            rects += rectCount + ". " + temp.getRect() + "\n";
            temp = temp.getNext();
        }
        // It goes and in the while it creates the rects and adds values of the rectangles in it, if there are
        // 0 rectangles it just adds nothing to the sentence, therefore not changing it.
        return "The list has " + rectCount + " rectangles.\n" + rects;
    }

    private Point lowestRect() {
        RectNode temp = _head;
        Point lowestPoint = temp.getRect().getPointSW();
        while (temp != null) {
            Point pointRect = temp.getRect().getPointSW();
            if (pointRect.isUnder(lowestPoint)) { // Checks for the lowest Point
                lowestPoint = pointRect;
            }
            temp = temp.getNext();
        }
        return lowestPoint;
    }

    private Point mostRightRect() {
        RectNode temp = _head;
        Point mostRightPoint = temp.getRect().getPointNE();
        while (temp != null) {
            Point pointRect = temp.getRect().getPointNE();
            if (pointRect.isRight(mostRightPoint)) { // Checks for the mostRightPoint
                mostRightPoint = pointRect;
            }
            temp = temp.getNext();
        }
        return mostRightPoint;
    }

    private boolean isEmptyList() { // Checks if the list is empty, means if head is null.
        return _head == null;
    }
}

