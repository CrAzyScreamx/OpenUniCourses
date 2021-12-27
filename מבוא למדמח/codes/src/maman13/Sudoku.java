package maman13;

/**
 * Constructs a sudoku 9x9 board
 * @author Amit Y
 * @version 20/10/2021
 */
public class Sudoku {

    private Square3x3[][] _sudoku;
    private static final int DEFAULT_ROW_COL = 3;
    private static final int BOOLEAN_ARRAY_VALUE = 10;
    private static final int FIRST_VALID_INDEX = 1;

    /**
     * Constructs a new Sudoku board filled with -1 in all cells using Square3x3 constructor
     * @see Square3x3
     */
    public Sudoku() {
        _sudoku = new Square3x3[DEFAULT_ROW_COL][DEFAULT_ROW_COL];
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                _sudoku[row][col] = new Square3x3();
            }
        }
    }

    /**
     * Constructs a new Sudoku board and copies all values from a two-dimensional array of Square3x3
     * @param square3x3Array - A two-dimensional 3x3 array of Square3x3
     * @see Square3x3
     */
    public Sudoku(Square3x3[][] square3x3Array) {
        _sudoku = new Square3x3[square3x3Array.length][square3x3Array[0].length];
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                _sudoku[row][col] = new Square3x3(square3x3Array[row][col]);
            }
        }
    }

    /**
     * Checks if the Sudoku board is valid, true if it's valid and false otherwise
     * @return true if valid and false otherwise
     */
    public boolean isValid() {
        /*
         * This function does this step for every square in the Sudoku board:
         * It takes the block and checks if it's null, if not it checks if all numbers ( 1-9 ) are there.
         * Then it checks for each row in the Sudoku if it's a valid row ( 1-9 numbers are present )
         * The final validation is the same thing as the row but for the column
         */
        for (int row = 0; row < _sudoku.length; row++) {
            for (int col = 0; col < _sudoku[row].length; col++) {
                if (_sudoku[row][col] == null || !_sudoku[row][col].allThere() || !validateRow(row, col) || !validateCol(row, col)) return false;
            }
        }
        return true;
    }

    /**
     * Private function responsible to check every row in the sudoku board
     * @param rowSudoku - the Row of the block ( where the Square3x3 is taken from )
     * @param rowBlock - the row it should check in the square itself
     * @return true if all numbers ( 1-9 ) are valid and false otherwise
     */
    private boolean validateRow(int rowSudoku, int rowBlock) {
        /*
         * The function takes the current row of the Sudoku and the row it should check inside the square
         * After taking both of these it's checking for board 0 to board 2 the numbers in the same row and
         * returns true if all numbers present in the same Sudoku board
         */
        boolean[] values = new boolean[BOOLEAN_ARRAY_VALUE];
        for (int col = 0; col < _sudoku[rowSudoku].length; col++) {
            Square3x3 squareBlock = _sudoku[rowSudoku][col];
            squareBlock.whosThereRow(rowBlock, values); // Checks the same row in each square inside the board for its values.
        }
        return isValidArray(values);
    }

    /**
     * Private function responsible to check every column in the Sudoku board
     * @param col - the column of the block ( where the Square3x3 is taken from )
     * @param colBlock - the column it should check in the square itself
     * @return true if all numbers are valid ( 1-9 ) and false otherwise
     */
    private boolean validateCol(int col, int colBlock) {
        /*
         * The function takes the current column of the Sudoku and the column should check inside the square
         * After taking both of these it's checking for board 0 to board 2 the numbers in the same column and
         * returns true if all numbers present in the same Sudoku board
         */
        boolean[] values = new boolean[BOOLEAN_ARRAY_VALUE];
        for (int row = 0; row < _sudoku.length; row++) {
            Square3x3 squareBlock = _sudoku[row][col];
            squareBlock.whosThereCol(colBlock, values); // Checks the same column in each square inside the board for its values.
        }
        return isValidArray(values);
    }

    /**
     * Private function which receives a boolean array and checks if all indexes from 1-9 are true.
     * His purpose is to check if the given row or column is valid or not ( has all values 1-9 )
     * @param values - the value boolean array
     * @return true if indexes 1-9 are true, false otherwise
     */
    private boolean isValidArray(boolean[] values) {
        for (int i = FIRST_VALID_INDEX; i < values.length; i++) {
            if (!values[i]) return false;
        }
        return true;
    }
}
