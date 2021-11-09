package maman12;

public class mainTest {

    public static void main(String[] args) {

        Point p7 = new Point(1, 2);
        RectangleA r28 = new RectangleA(p7, 2, 2);
        Point p8 = r28.getPointSW();
        p8.setX(5);
        System.out.println(p8);
        System.out.println(r28.getPointSW());
    }
}
