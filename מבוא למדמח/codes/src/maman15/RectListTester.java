package maman15;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Maman 15 Tester ( RectList )
 * Amit Yanay
 */
public class RectListTester {
    public static void main(String[] args) {

        // DECLARATIONS

        RectList rLEmpty = new RectList();
        RectList rL1 = new RectList();
        RectangleA r1 = rndRect();
        RectangleA r2 = rndRect();
        RectangleA r3 = rndRect();
        RectangleA r4 = rndRect();
        Point p1 = new Point(5, 6);
        RectangleA r5 = new RectangleA(p1, 5, 5);

        Point p2 = new Point(8, 8);
        RectList rL2 = new RectList();
        RectList rL3 = new RectList();

        RectList rL4 = new RectList();
        for (int i = 1; i <= 10; i++) {
            RectangleA rect = new RectangleA(i, i);
            rL4.addRect(rect);
        }
        RectList rL5 = new RectList();
        RectangleA AB1 = cRect(new int[]{2, 1, 5, 3});
        RectangleA CD1 = cRect(new int[]{2, 5, 7, 8});
        RectangleA EF1 = cRect(new int[]{12, 5, 16, 9});
        RectangleA GH1 = cRect(new int[]{3, -4, 10, -1});
        RectangleA IJ1 = cRect(new int[]{-14, 6, 4, 20});


        RectList rL6 = new RectList();
        RectangleA AB2 = cRect(new int[]{0, 0, 7, 5});
        RectangleA CD2 = cRect(new int[]{3, -2, 6, 1});
        RectangleA EF2 = cRect(new int[]{-6, 1, -3, 3});
        RectangleA GH2 = cRect(new int[]{-9, -3, -4, -1});
        RectangleA IJ2 = cRect(new int[]{-9, -1, -5, 2});
        RectangleA KL2 = cRect(new int[]{-9, -4, -8, -3});
        RectList rL7 = new RectList();

        RectList rL8 = new RectList();
        RectangleA AB3 = cRect(new int[]{2, -6, 5, -3});
        RectangleA CD3 = cRect(new int[]{-2, -2, 2, 1});
        RectangleA EF3 = cRect(new int[]{3, 4, 5, 5});
        RectangleA GH3 = cRect(new int[]{5, 5, 7, 6});
        RectangleA IJ3 = cRect(new int[]{-2, 2, 2, 5});
        RectangleA KL3 = cRect(new int[]{7, 3, 9, 7});
        RectangleA MN3 = cRect(new int[]{7, 7, 10, 9});
        RectangleA OP3 = cRect(new int[]{9, 5, 13, 9});
        RectList rL9 = new RectList();

        RectList rL10 = new RectList();
        RectangleA AB4 = cRect(new int[]{-4, -3, -4, -2});
        RectangleA CD4 = cRect(new int[]{1, -4, 3, -2});
        RectangleA EF4 = cRect(new int[]{-8, -3, -2, 1});

        RectList rLAliasing = new RectList();
        RectangleA AB5 = cRect(new int[]{-1, -3, 1, -2});
        RectangleA CD5 = cRect(new int[]{-5, -3, 2, 2});
        RectangleA EF5 = cRect(new int[]{3, 2, 5, 4});
        // DECLARATIONS

        // ACTIONS

        rL1.addRect(r1);
        rL1.addRect(r2);
        rL1.addRect(r3);
        rL1.addRect(r4);
        rL1.addRect(r5);
        rL1.addRect(r5);
        int checkRects = rL1.howManyWithPoint(p1); // for cals of how much of the same rectangles there are in rL1

        for (int i = 0; i < 3; i++) {
            RectangleA rect = rndRect();
            rect.setPointSW(p2);
            rL2.addRect(rect);
        }
        rL2.addRect(new RectangleA(5, 80));
        int howManyWithPoint1 = rL2.howManyWithPoint(p2); // should be 3
        int howManyWithPoint2 = rL3.howManyWithPoint(p2); // should be 0 ( list empty )

        rL5.addRect(AB1);
        rL5.addRect(CD1);
        rL5.addRect(EF1);
        rL5.addRect(GH1);
        rL5.addRect(IJ1);
        double lExpected1 = new RectangleA(10, 10).getDiagonalLength();
        double lActual1 = rL4.longestDiagonal();
        double lExpected2 = IJ1.getDiagonalLength();
        double lActual2 = rL5.longestDiagonal();
        double lActual3 = rLEmpty.longestDiagonal();

        rL6.addRect(AB2);
        rL6.addRect(CD2);
        rL6.addRect(EF2);
        rL6.addRect(GH2);
        rL6.addRect(IJ2);
        rL6.addRect(KL2);
        rL7.addRect(AB2);
        rL7.addRect(CD2);
        rL7.addRect(EF2);
        rL7.addRect(KL2);
        rL7.addRect(GH2);
        rL7.addRect(IJ2);
        Point mLExpected1 = new Point(GH2.getPointSW());
        Point mLActual1 = rL6.mostLeftRect();
        Point mLExpected2 = new Point(KL2.getPointSW());
        Point mLActual2 = rL7.mostLeftRect();
        Point mLActual3 = rLEmpty.mostLeftRect();

        rL8.addRect(AB3);
        rL8.addRect(CD3);
        rL8.addRect(EF3);
        rL8.addRect(GH3);
        rL8.addRect(IJ3);
        rL8.addRect(KL3);
        rL8.addRect(MN3);
        rL8.addRect(OP3);
        rL9.addRect(AB3);
        rL9.addRect(CD3);
        rL9.addRect(EF3);
        rL9.addRect(GH3);
        rL9.addRect(IJ3);
        rL9.addRect(KL3);
        rL9.addRect(OP3);
        rL9.addRect(MN3);
        Point hLExpected1 = new Point(MN3.getPointNE());
        Point hLActual1 = rL8.highestRect();
        Point hLExpected2 = new Point(OP3.getPointNE());
        Point hLActual2 = rL9.highestRect();
        Point hLActual3 = rLEmpty.highestRect();

        rL10.addRect(AB4);
        rL10.addRect(CD4);
        rL10.addRect(EF4);
        RectangleA MCExpected = cRect(new int[]{-8, -4, 3, 1});
        RectangleA MCActual = rL10.minimalContainer();

        String rL6Str = "The list has 6 rectangles.\n" +
                "1. Width=7 Height=5 PointSW=(0,0)\n" +
                "2. Width=3 Height=3 PointSW=(3,-2)\n" +
                "3. Width=3 Height=2 PointSW=(-6,1)\n" +
                "4. Width=5 Height=2 PointSW=(-9,-3)\n" +
                "5. Width=4 Height=3 PointSW=(-9,-1)\n" +
                "6. Width=1 Height=1 PointSW=(-9,-4)\n";
        String rL8Str = "The list has 8 rectangles.\n" +
                "1. Width=3 Height=3 PointSW=(2,-6)\n" +
                "2. Width=4 Height=3 PointSW=(-2,-2)\n" +
                "3. Width=2 Height=1 PointSW=(3,4)\n" +
                "4. Width=2 Height=1 PointSW=(5,5)\n" +
                "5. Width=4 Height=3 PointSW=(-2,2)\n" +
                "6. Width=2 Height=4 PointSW=(7,3)\n" +
                "7. Width=3 Height=2 PointSW=(7,7)\n" +
                "8. Width=4 Height=4 PointSW=(9,5)\n";
        String rL10Str = "The list has 3 rectangles.\n" +
                "1. Width=0 Height=1 PointSW=(-4,-3)\n" +
                "2. Width=2 Height=2 PointSW=(1,-4)\n" +
                "3. Width=6 Height=4 PointSW=(-8,-3)\n";
        String rLEmptyStr = "The list has 0 rectangles.\n";

        rLAliasing.addRect(AB5);
        rLAliasing.addRect(CD5);
        rLAliasing.addRect(EF5);
        Point mLPointAliasing = rLAliasing.mostLeftRect();
        Point hPointAliasing = rLAliasing.highestRect();
        mLPointAliasing.setX(0);
        hPointAliasing.setY(-19);
        // ACTIONS

        // ASSERTIONS

        pn("***** RectList Tester *****\n");
        p("Checking addRect: ");
        if (checkRects == 1) ok();
        else err("1 of the same rectangle", "2 of the same rectangle ( NOTE: The question stated you must have only 1 of the same rectangle )");

        pn("");

        pn("Checking howManyWithPoint:");
        p("Check number 1: ");
        if (howManyWithPoint1 == 3) ok();
        else err(3, howManyWithPoint1);
        p("Check number 2: ");
        if (howManyWithPoint2 == 0) ok();
        else err(0, howManyWithPoint2);

        pn("");

        pn("Checking longestDiagonal: ");
        p("Check number 1: ");
        if (lActual1 == lExpected1) ok();
        else err(lExpected1, lActual1);
        p("Check number 2: ");
        if (lActual2 == lExpected2) ok();
        else err(lExpected2, lActual1);
        p("Check number 3: ");
        if (lActual3 == 0) ok();
        else err(0, lActual3);

        pn("");

        pn("Checking mostLeftRect:");
        p("Check number 1: ");
        if (mLExpected1.equals(mLActual1)) ok();
        else err(mLExpected1, mLActual1);
        p("Check number 2: ");
        if (mLExpected2.equals(mLActual2)) ok();
        else err(mLExpected2, mLActual2);
        p("Check number 3: ");
        if (mLActual3 == null) ok();
        else err(null, mLActual2);

        pn("");

        pn("Checking highestRect:");
        p("Check number 1: ");
        if (hLExpected1.equals(hLActual1)) ok();
        else err(hLExpected1, hLActual1);
        p("Check number 2: ");
        if (hLExpected2.equals(hLActual2)) ok();
        else err(hLExpected2, hLActual2);
        p("Check number 3: ");
        if (hLActual3 == null) ok();
        else err(null, hLActual3);

        pn("");

        p("Checking minimalContainer: ");
        if (MCExpected.equals(MCActual)) ok();
        else err(MCExpected, MCActual);

        pn("");

        pn("Checking toString:");
        p("Check number 1: ");
        if (rL6Str.equals(rL6.toString())) ok();
        else err(rL6Str, rL6.toString());
        p("Check number 2: ");
        if (rL8Str.equals(rL8.toString())) ok();
        else err(rL8Str, rL8.toString());
        p("Check number 3: ");
        if (rL10Str.equals(rL10.toString())) ok();
        else err(rL10Str, rL10.toString());
        p("Check number 4: ");
        if (rLEmptyStr.equals(rLEmpty.toString())) ok();
        else err(rLEmptyStr, rLEmpty.toString());

        pn("");
        pn("*** Aliasing Tests ***");

        p("Aliasing Test on mostLeftPoint: ");
        if (!mLPointAliasing.equals(rLAliasing.mostLeftRect())) ok();
        else err(false, true + " ( NOTE: It means you've got aliasing )");
        p("Aliasing Test on highestRect: ");
        if (!hPointAliasing.equals(rLAliasing.highestRect())) ok();
        else err(false, true + " ( NOTE: It means you've got aliasing ) ");
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

    private static RectangleA rndRect() {
        int width = ThreadLocalRandom.current().nextInt(0, 10);
        int height = ThreadLocalRandom.current().nextInt(0, 15);
        return new RectangleA(width, height);
    }

    private static RectangleA cRect(int[] xyArr) {
        return new RectangleA(new Point(xyArr[0], xyArr[1]), new Point(xyArr[2], xyArr[3]));
    }
}
