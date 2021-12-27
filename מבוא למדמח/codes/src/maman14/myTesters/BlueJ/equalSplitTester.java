package maman14.myTesters.BlueJ;

import maman14.Ex14;

import java.util.Arrays;

/**
 * Amit Yanay
 * equalSplitTester
 */
public class equalSplitTester extends Ex14 {

    public static void main(String[] args) {
        System.out.println("Checking equalSplit Tester ---");

        int[] arr1 = new int[]{5};
        int[] arr2t = new int[]{8,8};
        int[] arr2f = new int[]{8,5};
        int[] arr3 = new int[]{5,8,7};
        int[] arr4t = new int[]{5, 8, 12, 1};
        int[] arr4f = new int[]{35, 4, 5, 0};
        int[] arr5 = new int[]{5,5,5,5,5};
        int[] arr6t = new int[]{20, -5, -10, 50, 30, -5};
        int[] arr6f = new int[]{40, 20, 10, 50, 6, 0};
        int[] arr8t = new int[]{2, 10, 5, 10, 3, 2, -8, 10};
        int[] arr10t = new int[]{1, 4, 1, 4, 4, 4, 1, 4, 1, 16};

        cArr(arr1, "None");
        if (!equalSplit(arr1)) ok();
        else error();

        cArr(arr2t, "8=8");
        if (equalSplit(arr2t)) ok();
        else error();

        cArr(arr2f, "None");
        if (!equalSplit(arr2f)) ok();
        else error();

        cArr(arr3, "None");
        if (!equalSplit(arr3)) ok();
        else error();

        cArr(arr4t, "5+8=12+1");
        if (equalSplit(arr4t)) ok();
        else error();

        cArr(arr4f, "None");
        if (!equalSplit(arr4f)) ok();
        else error();

        cArr(arr5, "None");
        if (!equalSplit(arr5)) ok();
        else error();

        cArr(arr6t, "20+30-10=50-5-5");
        if (equalSplit(arr6t)) ok();
        else error();

        cArr(arr6f, "None");
        if (!equalSplit(arr6f)) ok();
        else error();

        cArr(arr8t, "10+10+5-8=3+2+10+2");
        if (equalSplit(arr8t)) ok();
        else error();

        cArr(arr10t, "4+4+4+4+4=1+1+1+1+16");
        if (equalSplit(arr10t)) ok();
        else error();



    }

    private static void cArr(int[] arr, String comb) {
        p(String.format("Checking array %s (combination: %s): ", Arrays.toString(arr), comb));
    }

    private static void p(String sen) {
        System.out.print(sen);
    }

    private static void pn(String sen) {
        p(sen + "\n");
    }

    private static void error() {
        System.out.println("Found combination but shouldn't");
    }

    private static void ok() {
        System.out.println("Returned OK");
    }



}
