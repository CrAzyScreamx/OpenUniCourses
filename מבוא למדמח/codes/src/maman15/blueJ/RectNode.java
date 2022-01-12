public class RectNode {

    private RectangleA _rect;
    private RectNode _next;

    public RectNode(RectangleA r) {
        _rect = r;
        _next = null;
    }

    public RectNode(RectangleA r, RectNode n) {
        _rect = r;
        _next = n;
    }

    public RectNode(RectNode r) {
        _rect = r.getRect();
        _next = r.getNext();
    }

    public RectangleA getRect() {
        return new RectangleA(_rect);
    }

    public RectNode getNext() {
        return _next;
    }

    public void setRect(RectangleA r) {
        _rect = new RectangleA(r);
    }

    public void setNext(RectNode next) {
        _next = next;
    }
}
