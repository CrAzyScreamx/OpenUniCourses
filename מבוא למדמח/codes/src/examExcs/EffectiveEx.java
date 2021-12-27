package examExcs;

public class EffectiveEx {
    public static void main(String[] args) {
        System.out.println(smallestSub(new int[]{2, 1, 0, 0, 12, 15, 17, 1,4,13,6,0,19, 15, 16, 18, 19, 2}, 20));
    }

    private static int smallestSub(int[] a, int k) {
        int countSize, prevSize = a.length+1, sum, sumArray = 0;
        boolean sumBigger;
        for (int i= 0; i < a.length; i++) {
            sum = 0;
            countSize = 0;
            sumBigger = false;
            for (int j = i; j < a.length && !sumBigger; j++) {
                if (a[j] > k) return 1;
                sum += a[j];
                countSize++;
                if (sum > k || countSize >= prevSize) sumBigger = true;
                sumArray += a[j];
            }
            if (prevSize > countSize && sumBigger) prevSize = countSize;
            if (sumArray < k && i == 0) return a.length+1;
        }
        return prevSize;
    }
}
