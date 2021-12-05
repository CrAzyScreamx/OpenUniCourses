
/**
 * Write a description of class one here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class one
{
    // instance variables - replace the example below with your own
    public static boolean allPositive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) return false;
        }
        return true;
    }
}
