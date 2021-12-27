package maman14.myTesters.BlueJ;

import maman14.Ex14;

import java.util.Arrays;

/**
 * Amit Yanay
 * isSpecialTester
 */
public class isSpecialTester extends Ex14 {

    public static void main(String[] args) {
        System.out.println("--- isSpecial Tester ---");
        System.out.println("this system checks between 1-20000 for special numbers");
        System.out.println("If you ask, then no, I didn't sit on my ass for a full day to gather the numbers I just" +
                " used a function to do it");
        System.out.println();

        int[] specialArr = new int[159];
        int count = 0;
        for (int i = 1; i <= 20000; i++) {
            if (isSpecial(i)) {
                try {
                    specialArr[count] = i;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("The function returned more than it should");
                    return;
                }
                count++;
            }
        }
        int[] arr = new int[]{1,3,7,13,19,27,39,49,63,79,91,109,133,147,181,207,223,253,289,307,349,387,399,459,481,529,
                567,613,649,709,763,807,843,927,949,1009,1093,1111,1189,1261,1321,1359,1471,1483,1579,1693,1719,1807,
                1899,1933,2023,2161,2187,2269,2367,2479,2533,2703,2739,2799,2967,3019,3147,3199,3327,3421,3529,3619,
                3807,3841,3913,4083,4203,4249,4407,4603,4623,4783,4891,5067,5163,5293,5401,5547,5667,5767,5971,6109,
                6159,6387,6559,6589,6799,6927,7069,7219,7369,7483,7741,7849,7963,8173,8401,8419,8607,8847,8923,9193,
                9303,9511,9679,9889,10047,10143,10467,10603,10707,10969,11043,11341,11479,11731,11827,12091,12267,
                12483,12649,12859,13107,13239,13411,13711,13903,14041,14283,14503,14799,14967,15183,15379,15559, 15883,
                16009,16273,16407,16779,16927,17203,17307,17749,17953,18109,18391,18649,18871,19087,19443,19539,19951};
        if (Arrays.equals(arr, specialArr)) {
            System.out.println("isSpecial Test: Returned OK for isSpecial check, good job! :D");
        }


    }
}
