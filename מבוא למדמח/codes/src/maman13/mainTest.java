package maman13;

import maman12.Point;
import maman12.RectangleB;

import java.util.Random;

public class mainTest {

    public static void main(String[] args) {
        System.out.println(what(new int[]{4,5,2}));
    }

    public static int what(int[] a) {
        double x = 0;
        for (int i = 0; i < a.length; i++) {
            x = (x+a[i]) / 2 + Math.abs((x-a[i]) / 2);
        }
        return (int)x;
    }
}
