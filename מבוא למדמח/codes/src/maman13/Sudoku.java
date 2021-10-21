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

    public Sudoku(Square3x3[][] square3x3Array) {
        _sudoku = square3x3Array;
    }

    public boolean isValid() {
        int cSudokuRow = 0;
        for (int row = 0; row < _sudoku.length; row++) {
            boolean[] values = new boolean[10];
            for (int col = 0; col < _sudoku[row].length; col++) {
                Square3x3 square = _sudoku[row][col];
                square.whosThereRow(cSudokuRow, values);
            }
            for (int i = 0; i < values.length; i++) {
                if (!values[i]) {
                    return false;
                }
            }
            cSudokuRow += 1;
            if (cSudokuRow % 3 == 0) cSudokuRow = 0;
        }
        return true;
    }

    public Square3x3[][] getSudoku() {
        return _sudoku;
    }
}
