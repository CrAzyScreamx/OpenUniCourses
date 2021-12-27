package testForPeopel;

public class Ex14 {

    public static int findMinDiff(int[] a, int x, int y) {

        // max num in array a
        final int MIN_MUN = 0;
        // int maxNum = MIN_MUN;
        int minIndex;
        int[] indexX = new int[a.length];
        int[] indexY = new int[a.length];
        int counterX = MIN_MUN;
        int counterY = MIN_MUN;

        // find all index of x, y values
        for (int i = 0; i < a.length; i++) {
            if (x == a[i]) {
                indexX[counterX] = i;
                counterX++;
            } else if (y == a[i]) {
                indexY[counterY] = i;
                counterY++;
            }
        }

        if (counterX != MIN_MUN && counterY != MIN_MUN) {
            // found index of x y
            minIndex = Math.abs(indexX[MIN_MUN] - indexY[MIN_MUN]);

            for (int i = 0; i < counterX; i++) {
                for (int j = 0; j < counterY; j++) {
                    if (Math.abs(indexX[i] - indexY[j]) < minIndex) {
                        minIndex = Math.abs(indexX[i] - indexY[j]);
                    }
                }
            }
            return minIndex;
        } else
            // return Integer.MAX_VALUE
            return Integer.MAX_VALUE;

    }

    public static boolean search (int [][] mat, int num)
    {
        // inputes
        int sqrNum , stC, stR, firstQuadrant, secondQuadrant, thirdQuadrant, fourQuadrant, something;
        sqrNum= mat.length/2; //4
        stC =0;  //0
        stR = mat.length-1; //7
        something = stR - sqrNum ; //3

        while (true)
        {

            // locate the highest number in each Quadr
            firstQuadrant = mat[stR - sqrNum][stC];
            secondQuadrant = mat[stR - sqrNum][sqrNum + stC ];
            thirdQuadrant = mat[stR][sqrNum + stC ];
            fourQuadrant = mat[stR][stC];
            if (firstQuadrant == secondQuadrant && secondQuadrant == thirdQuadrant && thirdQuadrant == fourQuadrant) return false;

            if(firstQuadrant >= num)
            {
                if (firstQuadrant == num)
                    return true;

                //stC = stC
                stR -= sqrNum ; //3
                sqrNum= sqrNum /2; //2

            }

            else if(secondQuadrant >= num)
            {
                if (secondQuadrant == num)
                    return true;

                stC += sqrNum; // 4
                stR -= sqrNum ; //3
                sqrNum = sqrNum /2; //2

            }
            else if(thirdQuadrant >= num)
            {
                if (thirdQuadrant == num)
                    return true;

                //stR = stR; // 7
                stC += sqrNum ; // 4
                sqrNum = sqrNum /2 ; //2

            }
            else if(fourQuadrant >= num)
            {
                if (fourQuadrant == num)
                    return true;

                //stC = stC // 0=0
                //stR = stR; // 7=7;
                sqrNum= sqrNum /2 ; //2
            }
            else
            {
                return false;
            }
        }
    }

    private static boolean between(int min, int max, int num) {
        return (num >= min) && (num <= max);
    }

    private static int getIndex(int arr[][], int num) {

        int qu = -1; // 1 top left, 2 top right, 3 less right, 4 less left
        // each qu
        int n = arr.length / 2; // 4

        // while qu not define and i <
        for (int i = 0; (i <= n) && (qu == -1); i += n) {
            // left
            int minL = arr[i][0];
            int maxL = arr[i + n - 1][0];

            if (between(minL, maxL, num)) {
                if (i == 0)
                    qu = 1;
                else
                    qu = 4;
            }
            // right
            int minR = arr[i][n];
            int maxR = arr[i + n - 1][n];

            if (between(minR, maxR, num)) {
                if (i == 0)
                    qu = 2;
                else
                    qu = 3;
            }

            // min 0,0
            // max 3,0

            // min 0,4
            // max 3,4

            // min 4,0
            // max 7,0

            // min 4,4
            // max 7,4

        }

        return qu;
    }
}