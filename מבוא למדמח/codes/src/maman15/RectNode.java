package maman15;

/**
 * Author: Amit Yanay
 * Version: 10/01/2021
 * This class represents a Node of Rectangles
 */
public class RectNode {

    private RectangleA _rect;
    private RectNode _next;

    /**
     * First constructor which initializes a new RectNode from a RectangleA
     * @param r a RectangleA object
     * @see RectangleA
     * Time Complexity: O(1) because there is only one command
     * Space Complexity: O(1) because there are no values
     */
    public RectNode(RectangleA r) {
        this(r, null);
    }

    /**
     * Second constructor which initializes a new RectNode from RectangleA and another RectNode.
     * NOTE: The RectNode is defined as the next node for this class
     * @param r the RectangleA object
     * @param n the RectNode object
     * @see RectangleA
     */
    public RectNode(RectangleA r, RectNode n) {
        _rect = new RectangleA(r);
        _next = n;
    }

    /**
     * Copy constructor which initializes a new RectNode from another RectNode.
     * @param r the RectNode object
     * Time Complexity: O(1) because there is only one command
     * Space Complexity: O(1) because there are no values
     */
    public RectNode(RectNode r) {
        this(r.getRect(), r.getNext());
    }

    /**
     * This method gets a copy of the rectangle inside the node
     * @return a copy of _rect
     * Time Complexity: O(1) because there is only one command
     * Space Complexity: O(1) because there are no values
     */
    public RectangleA getRect() {
        return new RectangleA(_rect);
    }

    /**
     * This method gets the next connected node
     * @return the next connected node, if there's no connected node it'll be null
     * Time Complexity: O(1) because there is only one command
     * Space Complexity: O(1) because there are no values
     */
    public RectNode getNext() {
        return _next;
    }

    /**
     * This method sets the rectangle of the node to r
     * @param r another RectangleA
     * Time Complexity: O(1) because there is only one command
     * Space Complexity: O(1) because there are no values
     */
    public void setRect(RectangleA r) {
        _rect = new RectangleA(r);
    }

    /**
     * Sets the next node of this node to another one
     * @param next another Node
     * Time Complexity: O(1) because there is only one command
     * Space Complexity: O(1) because there are no values
     */
    public void setNext(RectNode next) {
        _next = next;
    }
}
