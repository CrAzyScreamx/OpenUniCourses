package maman15;

public class testForMySelf {
    public static void main(String[] args) {
        RectNode n1 = new RectNode(new RectangleA(3, 3));
        RectangleA r2 = new RectangleA(5, 5);
        RectNode n2 = new RectNode(r2, n1);
        RectNode n3 = new RectNode(n2);
        printNodes(n3);
    }

    private static void printNodes(RectNode n) {
        System.out.print("Nodes: ");
        RectNode temp = n;
        while (temp.getNext() != null) {
            System.out.print("node: " + temp.getRect() + " | next: " + temp.getNext().getRect() + ",");
            temp = temp.getNext();
        }
    }
}
