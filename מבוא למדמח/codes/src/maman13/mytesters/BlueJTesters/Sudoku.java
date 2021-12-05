 

/**
 * Constructs a sudoku 9x9 board
 * @author Amit Y
 * @version 20/10/2021
 */
public class Sudoku {

    private Square3x3[][] _sudoku;
    private static final int DEFAULT_ROW = 3, DEFAULT_COL = 3;

    public Sudoku() {
        _sudoku = new Square3x3[DEFAULT_ROW][DEFAULT_COL];
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                _sudoku[row][col] = new Square3x3();
            }
        }
    }

    public Sudoku(Square3x3[][] square3x3Array) {
        _sudoku = new Square3x3[square3x3Array.length][square3x3Array[0].length];
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                _sudoku[row][col] = new Square3x3(square3x3Array[row][col]);
            }
        }
    }

    public boolean isValid() {
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                if (_sudoku[row][col] == null || !_sudoku[row][col].allThere() || !validateRow(row, col) || !validateCol(row, col)) return false;
            }
        }
        return true;
    }

    private boolean validateRow(int row, int rowBlock) {
        /*
         * block - square3x3 of row,col in the sudoku
         * row - check at x row (0-2) in the sudoku
         */
        boolean[] values = new boolean[10];
        for (int col = 0; col < _sudoku[row].length; col++) {
            Square3x3 squareBlock = _sudoku[row][col];
            squareBlock.whosThereRow(rowBlock, values);
        }
        for (int i = 1; i < values.length; i++) {
            if (!values[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean validateCol(int col, int colBlock) {
        /*
         * block - square3x3 of row,col in the sudoku
         * col - check at x column (0-2) in the sudoku
         */
        boolean[] values = new boolean[10];
        for (int row = 0; row < _sudoku.length; row++) {
            Square3x3 squareBlock = _sudoku[row][col];
            squareBlock.whosThereCol(colBlock, values);
        }
        for (int i = 1; i < values.length; i++) {
            if (!values[i]) {
                return false;
            }
        }
        return true;
    }

}
