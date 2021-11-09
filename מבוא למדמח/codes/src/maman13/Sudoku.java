package maman13;

/**
 * Constructs a sudoku 9x9 board
 * @author Amit Y
 * @version 20/10/2021
 */
public class Sudoku {

    private Square3x3[][] _sudoku = new Square3x3[3][3];

    public Sudoku() {
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                _sudoku[row][col] = new Square3x3();
            }
        }
    }

    public Sudoku(Square3x3[][] square3x3Array) {
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                _sudoku[row][col] = new Square3x3(square3x3Array[row][col]);
            }
        }
    }

    public boolean isValid() {
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                Square3x3 board = new Square3x3(_sudoku[row][col]);
                if (!board.allThere()) return false;
            }
        }
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                if (!validateRow(row, col) || !validateCol(col, row)) return false;
            }
        }
        return true;
    }

    private boolean validateRow(int rowSudoku, int rowBoard) {
        boolean[] values = new boolean[10];
        for (int col = 0; col < _sudoku[rowSudoku].length; col++) {
            Square3x3 board = new Square3x3(_sudoku[rowSudoku][col]);
            board.whosThereRow(rowBoard, values);
        }
        for (int val = 1; val < values.length; val++) {
            if (!values[val]) return false;
        }
        return true;
    }

    private boolean validateCol(int colSudoku, int colBoard) {
        boolean[] values = new boolean[10];
        for (int row = 0; row < _sudoku.length; row++) {
            Square3x3 board = new Square3x3(_sudoku[row][colSudoku]);
            board.whosThereCol(colBoard, values);
        }
        for (int val = 1; val < values.length; val++) {
            if (!values[val]) return false;
        }
        return true;
    }
}
