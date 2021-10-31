package maman13;

import maman12.Point;
import maman12.RectangleB;

import java.util.Random;

public class mainTest {

    static int test = 6;

    public static void main(String[] args) {
        /*int[][] array = new int[3][3];
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
        System.out.println(sudoku.isValid());*/
        Point p1 = new Point(5, 5);
        Point p2 = new Point(1, 1);
        RectangleB r11 = new RectangleB(10, 8);
        RectangleB r12 = new RectangleB(p1, p2);
        System.out.println(r11.overlap(r12));
        System.out.println(r12.overlap(r11));
    }
}
