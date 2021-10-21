package maman13;

import java.util.Random;

public class mainTest {

    public static void main(String[] args) {
        int[][] array = new int[3][3];
        Square3x3[][] squareArray = new Square3x3[3][3];
        Random rnd = new Random();
        for (int sqar = 0; sqar < 3; sqar++) {
            for (int sqac = 0; sqac < 3; sqac++) {
                for (int r = 0; r < array.length; r++) {
                    for (int c = 0; c < array[r].length; c++) {
                        array[r][c] = rnd.nextInt(10-1) + 1;
                    }
                }
                squareArray[sqar][sqac] = new Square3x3(array);
                System.out.println(squareArray[sqar][sqac]);
            }
        }
        Sudoku sudoku = new Sudoku(squareArray);
        System.out.println(sudoku.isValid());
    }
}
