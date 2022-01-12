package examQuestions.exam1;

public class answers {
    public static void main(String[] args) {
        int[] arr = new int[]{4,7,1,2,3,5};
        System.out.println(split3(arr));
        int[] arr2 = new int[]{1,4,13,6,0,19};
        int test = smallestSub(arr2, 2);
        System.out.println(test);
    }

    public static boolean split3(int[] arr) {
        return split3(arr, 0, 0, 0, 0);
    }

    private static boolean split3(int[] arr, int i, int sum1, int sum2, int sum3) {
        if (i == arr.length && sum1 == sum2 && sum1 == sum3) {
            return true;
        }
        if (i == arr.length) {
            return false;
        }
        return split3(arr, i+1, sum1+arr[i], sum2, sum3) ||
                split3(arr, i+1, sum1, sum2+arr[i], sum3) ||
                split3(arr, i+1, sum1, sum2, sum3+arr[i]);
    }

    public static int smallestSub(int[] a, int k) {
        int countSub = a.length+1;
        int currentCount = 0;
        int indexToStart = 0;
        int index = indexToStart;
        int sum = 0;
        while (index != a.length) {
            if (sum == 0 && a[indexToStart] > k) {
                return 1;
            }
            sum+= a[index];
            index++;
            currentCount++;
            if (sum > k) {
                sum = 0;
                indexToStart++;
                index = indexToStart;
                if (currentCount <= countSub) {
                    countSub = currentCount;
                }
                currentCount = 0;
            }
        }
        return countSub;
    }
}


