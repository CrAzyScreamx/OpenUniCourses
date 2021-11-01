package maman13.mytesters;

import maman13.Square3x3;

public class Square3x3Tester {

    // Don't touch these, it's for colour purposes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    // Don't touch these, it's for colour purposes

    public static void main(String[] args) {
        System.out.println("This is a tester for Square3x3 class, it's checking anything I could think of");
        print("Checking first constructor: ");
        Square3x3 b1 = new Square3x3();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b1.getCell(i,j) == -1) count++;
            }
        }
        if (count == 9) ok();
        else error("-1\t-1\t-1\n-1\t-1\t-1\n-1\t-1\t-1\n", b1);

        print("Checking second constructor ( 3x3 array ): ");
        int[][] a1 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        printSecondConstructor(a1, 3, 3);
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

    private static void error(Object expected, Object actual) {
        System.out.print(ANSI_RED + "Returned ERROR\n" + ANSI_RESET + "Expected Board:\n" + expected);
        System.out.println(ANSI_RED + "Actual Board:\n" + actual);
    }

    private static int[][] get3x3Array(int rows, int cols) {
        int[][] actual = new int[rows][cols];
        int count = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                actual[r][c] = count;
                count++;
            }
        }
        return actual;
    }

    private static void printSecondConstructor(int[][] expectedArray, int rows, int cols) {
        int[][] a1 = get3x3Array(rows, cols);
        Square3x3 board = new Square3x3(a1);
        boolean checkBoard = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a1[i][j] != board.getCell(i, j) && checkBoard) {
                    checkBoard = false;
                }
            }
        }
        if (checkBoard) ok();
        else {
            StringBuilder sen = new StringBuilder();
            for (int i= 0; i < expectedArray.length; i++) {
                for (int j = 0; j < expectedArray[i].length; j++) {
                   if (j==2) sen.append(expectedArray[i][j]).append("\n");
                   else sen.append(expectedArray[i][j]).append("\t");
                }
            }
            error(sen, board);
        }
    }
}
