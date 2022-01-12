package maman15;


/**
 * Maman 15 Tester ( RectNode )
 * Amit Yanay
 */
public class RectNodeTester {

    public static void main(String[] args) {
        pn("--- RectNode Tester ---");
        // DECLARATIONS

        RectangleA r1 = new RectangleA(5, 5);
        RectNode rN1 = new RectNode(r1);
        RectangleA r2 = new RectangleA(8, 8);
        RectNode rN2 = new RectNode(r2, rN1); // first: r2, next: r1
        RectNode rN3 = new RectNode(rN2); // next isn't null
        RectNode rN4 = new RectNode(rN1); // next is null

        RectangleA r3 = new RectangleA(5, 8);
        RectangleA r4 = new RectangleA(9, 9);
        RectNode rN5 = new RectNode(r3);
        RectNode rN6 = new RectNode(r4);


        RectangleA rA1 = new RectangleA(5, 19);
        Point pA1 = new Point(5, 6);
        RectNode rNA1 = new RectNode(rA1);
        RectangleA rA2 = rNA1.getRect();


        // DECLARATIONS

        // Actions

        boolean getRect1 = r1.equals(rN1.getRect()); // should be true
        boolean getRect2 = r1.equals(rN2.getNext().getRect()); // should be true
        boolean getRect3 = r2.equals(rN3.getRect()); // should be true
        boolean getRect4 = r1.equals(rN4.getRect()); // should be true

        boolean getNext1 = rN1.getNext() == null; // should be true
        boolean getNext2 = rN2.getNext() == rN1; // should be true
        boolean getNext3 = rN3.getNext() == rN1; // should be true
        boolean getNext4 = rN4.getNext() == null; // should be true

        rN5.setRect(r4);
        boolean setRect1 = rN5.getRect().equals(r4); // should be true
        boolean setRect2 = rN5.getRect().equals(r3); // should be false

        rN6.setNext(rN5);
        boolean setNext1 = rN6.getNext() != null; // should be true
        boolean setNext2 = rN6.getNext().getRect().equals(rN5.getRect()); // should be true

        rA2.setPointSW(pA1);
        boolean Aliasing1 = rA2.equals(rNA1.getRect()); // should be false
        rNA1.setRect(rA2);
        rA2.setWidth(1);
        boolean Aliasing2 = rA2.equals(rNA1.getRect()); // should be false
        // Actions

        // ASSERTIONS
        pn("***** RectNode Tester *****\n");
        pn("Checking getRect method:");
        p("Check number 1: ");
        if (getRect1) ok();
        else err(r1, rN1.getRect());

        p("Check number 2: ");
        if (getRect2) ok();
        else err(r1, rN2.getNext().getRect());

        p("Check number 3: ");
        if (getRect3) ok();
        else err(r2, rN3.getRect());

        p("Check number 4: ");
        if (getRect4) ok();
        else err(r1, rN4.getRect());

        pn("");

        pn("Checking getNext method:");
        p("Check number 1: ");
        if (getNext1) ok();
        else err(null, pNode(rN1.getNext()));

        p("Check number 2: ");
        if (getNext2) ok();
        else err("rect: Width=5 Height=5 PointSW=(0,0) | next: null", pNode(rN2.getNext()));

        p("Check number 3: ");
        if (getNext3) ok();
        else err("rect: Width=5 Height=5 PointSW=(0,0) | next: null", pNode(rN3.getNext()));

        p("Check number 4: ");
        if (getNext4) ok();
        else err(null, pNode(rN4.getNext()));

        pn("");

        pn("Checking setRect method:");
        p("Check number 1: ");
        if (setRect1) ok();
        else err(r4, rN5.getRect());

        p("Check number 2: ");
        if (!setRect2) ok();
        else err(r3, rN5.getRect());

        pn("");

        pn("Checking setNext method:");
        p("Check number 1: ");
        if (setNext1) ok();
        else err("rect: Width=9 Height=9 PointSW=(0,0) | next: not null", null);

        p("Check number 2: ");
        if (setNext2) ok();
        else err(r4, rN6.getNext().getRect());

        pn("\n*** Aliasing Tests ***");
        p("Checking Aliasing on getRect ( NOTE: it has been said you must give a copy of the Rectangle ): ");
        if (!Aliasing1) ok();
        else err(false, true);

        p("Checking Aliasing on setRect: ");
        if (!Aliasing2) ok();
        else err(false, true);
        // ASSERTIONS



    }

    private static void p(String sen) {
        System.out.print(sen);
    }

    private static void pn(String sen) {
        p(sen + "\n");
    }

    private static void ok() {
        pn("Returned OK");
    }

    private static void err(Object expected, Object actual) {
        pn(String.format("Returned ERROR - expected: %s | actual: %s", expected, actual));
    }

    private static String pNode(RectNode r) {
        return (String.format("rect: %s | next: %s", r.getRect(), r.getNext() != null ? "not null":"null"));
    }
}
