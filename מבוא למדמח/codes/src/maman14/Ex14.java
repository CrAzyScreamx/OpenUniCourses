package maman14;

public class Ex14 {

    /**
     * This function receives an array of n values, x and y as parameters, it searches both parameters in the array
     * and determines the minimal distance between them, if one of the parameters is not in the array the function will
     * return Integer.MAX_VALUE ( integer max value )
     *
     * @param a the array with n values
     * @param x a parameter which may or may not be in the array
     * @param y a parameter which mar or may not be in the array
     * @return the distance between x and y, if one of them doesn't exist in the array it'll return Integer.MAX_VALUE
     */
    public static int findMinDiff(int[] a, int x, int y) {
        // We have total of 4 values which makes the Space O(4) = O(1)
        // Because we have one for which goes from 0 to n it gives us O(n)
        // Time Complexity: O(n) || Space Complexity: O(1)
        int firstIndex = -1, secondIndex = -1, distance = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if ((x == a[i] || y == a[i]) && (firstIndex == -1 || a[firstIndex] == a[i])) {
                // Checks if x or y are in the array and if it hasn't found first index
                firstIndex = i;
            } else if ((x == a[i] || y == a[i]) && secondIndex == -1) {
                // This statement requires other one to be false, here it checks again if one of them in the array
                // but this time checks for the last index, this is to prevent same index to be counted twice
                if (a[firstIndex] != a[i]) {
                    secondIndex = i;
                }
            }
            if (firstIndex != -1 && secondIndex != -1) {
                if (Math.abs(firstIndex - secondIndex) < distance) { // Checks if the distance lower than stored distance value
                    distance = Math.abs(firstIndex - secondIndex);
                    // If the distance between two indexes is 1 because it's the minimal distance possible just stop with 1
                    if (distance == 1) {
                        return 1;
                    }
                }
                if (firstIndex < secondIndex) { // Saves the first index ( to check for other distances as well it saves one of them
                    firstIndex = -1;
                } else {
                    secondIndex = -1;
                }
            }
        }
        return distance;
    }

    /**
     * This function searches a number in a circular-sorted two-dimensional array, if it finds the number the function
     * prints the row, column and returns true, if it didn't find the number it'll return false.
     * NOTE: a circular-sorted array is mandatory for this function, a circular-sorted array is an array where
     * every quarter is circular-sorted and so on up to 1x1 cell, also, the two-dimensional array must be a complete
     * power of two.
     *
     * @param mat the circular-sorted two-dimensional array
     * @param num the number we're searching for
     * @return true if number is found, false otherwise
     */
    public static boolean search(int[][] mat, int num) {
        // total of 3 values, making the space complexity O(1)
        // At the worst case it'll do 4n steps, it cuts the array into for ( n^2 ), afterwards it'll be log(n^2),
        // once we take 2log(n) to log(n) it brings the Time Complexity to O(logn)
        // Time Complexity: O(logn) || Space Complexity: O(1)
        int squareNum = mat.length / 2, startRow = mat.length - 1, startCol = 0;
        if (startRow == 0) {
            return mat[startCol][startCol] == num;
        }
        if (num > mat[mat.length - 1][0] || num < mat[0][0]) {
            // Checks if the number is between the smallest and largest number in the array
            return false;
        }
        while (true) {
            /*
             * These statements take the lowest and largest number in each quarter and checks if the number in between them
             * If a statement is correct it eliminates all other quarters from the equation and focusing on the quarter where
             * the number is in, afterwards it'll do the same for its quarters and so on up to the cell where the number is.
             */
            if (num <= mat[startRow][startCol] && num >= mat[startRow - (squareNum - 1)][startCol]) {
                // Checks if num is between the biggest and lowest numbers in the fourth quarter
                squareNum /= 2;
            } else if (num <= mat[startRow][startCol + squareNum] && num >= mat[startRow - (squareNum - 1)][startCol + squareNum]) {
                // Checks if num is between the biggest and lowest numbers in the third quarter
                startCol += squareNum;
                squareNum /= 2;
            } else if (num <= mat[startRow - squareNum][startCol + squareNum] &&
                    num >= mat[startRow - (2 * squareNum - 1)][startCol + squareNum]) {
                // Checks if num is between the biggest and lowest numbers in the second quarter
                startCol += squareNum;
                startRow -= squareNum;
                squareNum /= 2;
            } else if (num <= mat[startRow - squareNum][startCol] && num >= mat[startRow - (2 * squareNum - 1)][startCol]) {
                startRow -= squareNum;
                squareNum /= 2;
            } else {
                return false;
            }
            if (mat[startRow][startCol] == num) {
                return true;
            }
        }
    }

    /**
     * This method gets an array and checks if there are two combinations of n/2 numbers ( n represents the length of the
     * array ) that when we sum each combination we get the same result.
     * Example: for array [-3,5,12,14,-9,13] there combinations are: -3+5+14 and 12+-9+13 which both give 16.
     * The method will return true if it finds two combinations which meet the requirements from above and false otherwise.
     * @param arr the array we check the combinations from
     * @return true if the method can find two combination which meet the requirements from above, false otherwise
     * NOTE: this method is a recursion method
     */
    public static boolean equalSplit(int[] arr) {
        if (arr.length % 2 != 0) return false;
        return equalSplit(arr, 0, 0, 0, 0, 0);
    }

    private static boolean equalSplit(int[] arr, int i, int firstSum, int secondSum, int firstCount, int secondCount) {
        if (i == arr.length && firstSum == secondSum && firstCount == secondCount) { // checks if we found a valid combination
            return true;
        } else if (i == arr.length) {
            return false;
        }
        /*
         * This return is checking for a few things:
         * first - it goes to the first option where every number is in the sum of the first one until it gets
         * to the end, if it doesn't find it goes back an option and checks the other path, it continues
         * like this and searches for a valid combination which can meet the requirements.
         * second - the second statement is checked only after all combinations have been tested on the first statement
         * it does the same thing but checks where it starts from the second statement and so on.
         * If it finds one of the paths as the correct one it returns true, false otherwise.
         */
        return equalSplit(arr, i + 1, firstSum + arr[i], secondSum, firstCount + 1, secondCount) ||
                equalSplit(arr, i + 1, firstSum, secondSum + arr[i], firstCount, secondCount + 1);
    }

    /**
     * This method checks if a given number is a special number.
     * Special number: a number is called a special number if you take all natural numbers and remove all numbers in
     * the second places, afterwards third places and so on..., however, this number stays in the sequence.
     * @param n a given number to check
     * @return true if n is a special number, false otherwise
     * NOTE: this method is a recursion method
     */
    public static boolean isSpecial(int n) {
        return isSpecial(n, 2); // we begin from two because we start removing all even numbers
    }

    private static boolean isSpecial(int n, int i) {
        if (n <= 0) { // checks if the given number is negative
            return false;
        }
        if (i > n) { // if 'i' is bigger it means n will never be removed and return true.
            return true;
        }

        if (n % i != 0) { // if we remove all i numbers and division of n with 'i' gives us a decimal number it can't be removed
            return isSpecial(n-(n/i), i+1);
            /* because the equation involves the position of the numbers we take n as the position of number 'n'
             *(for example: the position of number 19 is 19) and decrement the amount of positions taken from the sequence.
             * (the position of 19 is now 10 because 9 numbers have been removed before him)
             */
        }
        return false;
    }


}
