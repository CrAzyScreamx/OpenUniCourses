package maman13;

/**
 * Constructs a sudoku 9x9 board
 * @author Amit Y
 * @version 20/10/2021
 */
public class Sudoku {

    private Square3x3[][] _sudoku = new Square3x3[3][3];

    public Sudoku() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                _sudoku[row][col] = new Square3x3();
            }
        }
    }

    public Square3x3[][] getSudoku() {
        return _sudoku;
    }
}
