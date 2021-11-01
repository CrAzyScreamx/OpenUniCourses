package maman13;

import java.util.Arrays;

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
        return validateRow(_sudoku) && validateRow(transposeBoard());
    }

    private boolean validateRow(Square3x3[][] board) {
        int rowCounter = 0;
        boolean checkRows = true;
        for (int row = 0; row < board.length; row++) {
            boolean[] values = new boolean[10];
            for (int col = 0; col < board[row].length; col++) {
                board[row][col].whosThereRow(rowCounter, values);
            }
            System.out.println(Arrays.toString(values));
            rowCounter++;
            if (rowCounter == 3) rowCounter = 0;
            for (int val = 1; val < values.length; val++) {
                if (!values[val] && checkRows) {
                    checkRows = false;
                    break;
                }
            }
        }
        return checkRows;
    }

    private Square3x3[][] transposeBoard() {
        Square3x3[][] transposed = new Square3x3[3][3];
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                transposed[row][col] = new Square3x3(transpose3x3Board(_sudoku[col][row]));
            }
        }
        return transposed;
    }

    private Square3x3 transpose3x3Board(Square3x3 board) {
        Square3x3 transposed = new Square3x3();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                transposed.setXY(row, col, board.getCell(col, row));
            }
        }
        return transposed;
    }
}
