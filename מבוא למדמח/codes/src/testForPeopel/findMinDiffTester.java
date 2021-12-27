package testForPeopel;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Amit Yanay
 * findMinDiffTester
 */
public class findMinDiffTester extends Ex14 {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("--- Time complexity: O(n), Space Complexity: O(1) ---");
        System.out.print("How many tests do you want to check?: ");
        int input = scan.nextInt();
        System.out.printf("%s tests will be checked, please wait...%n", input);
        Thread.sleep(1000);
        boolean errored = false;
        while (!errored && input > 0) {
            Object[] obj = createMinDiff();
            int[] arr = (int[]) obj[0];
            int dist = (int) obj[1];
            int num1 = (int) obj[2];
            int num2 = (int) obj[3];
            input--;
            int distFromFunc = findMinDiff(arr, num1, num2);
            if (dist != distFromFunc) {
                errored = true;
                System.out.printf("check for: %s returned ERROR || array: %s || expected dist: %s, actual: %s" +
                        " || between %s and %s", input, Arrays.toString(arr), dist, distFromFunc, num1, num2);
                input = Integer.MIN_VALUE;
            }
        }
        if (input != Integer.MIN_VALUE) {
            System.out.println("All testers returned OK, good job! :D");
        }
    }

    private static Object[] createMinDiff() {
        Object[] obj = new Object[4];
        // obj0 = array, obj1 = distance, obj2 = num1, obj3 = num2
        int[] array = new int[ThreadLocalRandom.current().nextInt(15, 20)];
        int distance = ThreadLocalRandom.current().nextInt(1, 7);
        obj[1] = distance;
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 15);
        }
        obj[2] = ThreadLocalRandom.current().nextInt(16, 25);
        obj[3] = ThreadLocalRandom.current().nextInt(25, 30);
        int firstIndex = ThreadLocalRandom.current().nextInt(0, 6);
        array[firstIndex] = (int) obj[2];
        array[firstIndex + distance] = (int) obj[3];
        obj[0] = array;
        return obj;
    }
}
