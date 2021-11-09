package maman13.mytesters;

import maman13.Square3x3;

import java.util.Arrays;
import java.util.Objects;

public class Square3x3Tester {

    // Don't touch these, it's for colour purposes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    // Don't touch these, it's for colour purposes

    public static void main(String[] args) {
        System.out.println("This is a tester for Square3x3 class, it's checking anything I could think of");
        print("First constructor: ");
        Square3x3 b1 = new Square3x3();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b1.getCell(i,j) == -1) count++;
            }
        }
        if (count == 9) ok();
        else error("-1\t-1\t-1\n-1\t-1\t-1\n-1\t-1\t-1\n", b1);

        print("Second constructor (3x3 array): ");
        printSecond(3,3);
        print("Second constructor (4x4 array): ");
        printSecond(4, 4);
        print("Second constructor (10x10 array): ");
        printSecond(10, 10);
        print("Second constructor (2x3 array): ");
        printSecond(2,3);
        print("Second constructor (2x4 array): ");
        printSecond(2,4);
        print("Second constructor (3x2 array): ");
        printSecond(3, 2);
        print("Second constructor (4x2 array): ");
        printSecond(4,2);
        print("Second constructor (2x2 array): ");
        printSecond(2,2);
        print("Second constructor (1x1 array): ");
        printSecond(1,1);
        print("Second constructor (30x30 array): ");
        printSecond(30, 30);
        print("Second constructor (4x1 array): ");
        printSecond(4,1);

        print("Third constructor (with first): ");
        Square3x3 b2 = new Square3x3();
        Square3x3 b3 = new Square3x3(b2);
        boolean ce1 = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b2.getCell(i, j) != b3.getCell(i,j)) ce1 = false;
            }
        }
        if (ce1) ok();
        else error(b2, b3);

        print("Third constructor (with second): ");
        Square3x3 b4 = new Square3x3(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
        Square3x3 b5 = new Square3x3(b4);
        boolean ce2 = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b4.getCell(i,j) != b5.getCell(i,j)) ce2 = false;
            }
        }
        if (ce2) ok();
        else error(b4, b5);

        System.out.println();
        print("getCell method (1,1): ");
        if (b4.getCell(1,2) == 6) ok();
        else rerror(6, b4.getCell(1,2));
        try {
            print("getCell method (1,4): ");
            if (b4.getCell(1,4) == -1) ok();
            print("getCell method (5,1): ");
            if (b4.getCell(5, 1) == -1) ok();
            print("getCell method (5,5): ");
            if (b4.getCell(5, 5) == -1) ok();

            print("setXY method (1,2,49): ");
            b4.setXY(1,2,49);
            if (b4.getCell(1, 2) == 49) ok();
            else rerror(49, b4.getCell(1,2));
            print("setXY method (2, 5, -4): ");
            b4.setXY(2,5, -4);
            ok();
            print("setXY method (5, 1, 40): ");
            b4.setXY(5,1,40);
            okn();
        } catch(ArrayIndexOutOfBoundsException exception) {
            System.out.println(ANSI_RED+ "Make sure you're checking if row and column between 1 and 3!!");
        }

        print("toString method: ");
        Square3x3 b6 = new Square3x3(new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}
        });
        if (Objects.equals(b6.toString(), "1\t2\t3\n6\t7\t8\n11\t12\t13\n")) ok();
        else rerror("1\t2\t3\n6\t7\t8\n11\t12\t13\n", b6);

        print("allThere method: ");
        Square3x3 b7 = new Square3x3(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
        if (b7.allThere()) ok();
        else rerror(true, b7.allThere());
        b7.setXY(1,2, 40);
        print("allThere method (second check): ");
        if (!b7.allThere()) ok();
        else rerror(false, b7.allThere());

        print("whosThereRow method: ");
        b7.setXY(1,2, 6);
        boolean[] values = new boolean[10];
        b7.whosThereRow(0, values);
        if (values[1] && values[2] && values[3]) ok();
        else rerror(true, "values[1]: " + values[1] + " | values[2]: " + values[2] + " | values[3]: " + values[3]);
        print("whosThereCol method: ");
        values = new boolean[10];
        b7.whosThereCol(0, values);
        if (values[1] && values[4] && values[7]) ok();
        else rerror(true,"values[1]: " + values[1] + " | values[4]: " + values[4] + " | values[7]: " + values[7]);
    }

    private static void print(String sentence) {
        System.out.print(ANSI_RESET + sentence);
    }

    private static void ok() {
        System.out.println(ANSI_GREEN + "Returned Ok");
    }

    private static void okn() {
        System.out.println(ANSI_GREEN + "Returned Ok\n");
    }

    private static void rerror(Object expected, Object actual) {
        System.out.println(ANSI_RED + "Returned ERROR - Expected: " + expected + " || Actual: " + actual);
    }

    private static void rerrorn(Object expected, Object actual) {
        rerror(expected, actual + "\n");
    }

    private static void error(Object expected, Object actual) {
        System.out.print(ANSI_RED + "Returned ERROR\n" + ANSI_RESET + "Expected Board:\n" + expected);
        System.out.println(ANSI_RED + "Actual Board:\n" + actual);
    }

    private static void printSecond(int rows, int cols) {
        int[][] expected = new int[3][3];
        fillValues(expected, rows, cols);
        int[][] requestedArr = new int[rows][cols];
        int c = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                requestedArr[i][j] = c++;
            }
        }
        Square3x3 board = new Square3x3(requestedArr);
        boolean valid = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (expected[row][col] != board.getCell(row, col) && valid) valid = false;
            }
        }
        if (valid) ok();
        else {
            StringBuilder sen = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sen.append(expected[i][j]);
                    if (j==2) sen.append("\n");
                    else sen.append("\t");
                }
            }
            error(sen, board);
        }
    }

    private static void fillValues(int[][] expected, int rows, int cols) {
        fillArrayValues(expected);
        int counter = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i < 3 && j < 3) expected[i][j] = counter;
                counter++;
            }
        }
    }

    private static void fillArrayValues(int[][] array) {
        for (int[] ints : array) {
            Arrays.fill(ints, -1);
        }
    }
}
