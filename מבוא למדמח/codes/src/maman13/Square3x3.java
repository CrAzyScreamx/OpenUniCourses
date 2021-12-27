package maman13;

/**
 * Represents a 3 by 3 square containing numbers
 * @author Amit Y
 * @version 20/10/2021
 */
public class Square3x3 {

    private int[][] _square3x3;
    private static final int DEFAULT_CELL_VALUE = -1;
    private static final int DEFAULT_ROW_COL = 3;
    private static final int MAX_VALUE = 10;
    private static final int LAST_LOOP_INDEX = 2;
    private static final int FIRST_VALID_INDEX = 1;

    /**
     * Constructs a two-dimensional array with the values of -1 in each cell
     */
    public Square3x3() {
        _square3x3 = new int[DEFAULT_ROW_COL][DEFAULT_ROW_COL];
        for (int row = 0; row < _square3x3.length; row++) {
            for (int col = 0; col < _square3x3[row].length; col++) {
                _square3x3[row][col] = DEFAULT_CELL_VALUE;
            }
        }
    }

    /**
     * Constructs a two-dimensional array with values from another array and rest of unfilled values is -1
     * @param array another array of x dimensions
     */
    public Square3x3(int[][] array) {
        this();
        for (int row = 0; row < Math.min(_square3x3.length, array.length); row++) {
            for (int col = 0; col < Math.min(_square3x3[row].length, array[row].length); col++) {
                _square3x3[row][col] = array[row][col];
            }
        }

    }

    /**
     * Constructs a two-dimensional array using values from another Square3x3 two-dimensional array
     * @param other another Square3x3 array
     */
    public Square3x3(Square3x3 other) {
        this(other._square3x3);
    }

    /**
     * Returns cell at a specific row and column
     * @param row row in the array
     * @param col column in the array
     * @return value at row and column
     */
    public int getCell(int row, int col) {
        if (rowColInRange(row) && rowColInRange(col)) {
            return _square3x3[row][col];
        } else {
            return DEFAULT_CELL_VALUE;
        }
    }

    /**
     * Sets value at a specific cell
     * @param row row in the array
     * @param col column in the array
     * @param value value to set at row,column index
     */
    public void setXY(int row, int col, int value) {
        if (rowColInRange(row) && rowColInRange(col)) {
            _square3x3[row][col] = value;
        }
    }

    /**
     * Returns a String which looks like a square
     * @return a sentence in format: "x\ty\tz\n" 3 times
     */
    public String toString() {
        String square = "";
        for (int row = 0; row < _square3x3.length; row++) {
            for (int col = 0; col < _square3x3[row].length; col++) {
                square += _square3x3[row][col];
                if (col == LAST_LOOP_INDEX) {
                    square += "\n";
                } else {
                    square += "\t";
                }
            }
        }
        return square;
    }

    /**
     * Checks if the board contains all values 1-9
     * @return if board contains 1-9
     */
    public boolean allThere() {
        boolean[] values = new boolean[MAX_VALUE];
        // Uses whosThereRow method to check numbers in each row specifically
        for (int row = 0; row < _square3x3.length; row++) {
            whosThereRow(row, values);
        }
        for (int row = FIRST_VALID_INDEX; row < values.length; row++) {
            if (!values[row]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets row number and boolean with 10 indexes, for each 1-9 cell values in the specific row it'll set the
     * value at the index ( cell values ) to true ( ex. 1,3,5 will set in the values array
     * values[1],values[5],values[3]=true )
     * @param row row between 0-2
     * @param values a boolean array
     */
    public void whosThereRow(int row, boolean[] values) {
        if (rowColInRange(row)) {
            for (int col = 0; col < _square3x3[row].length; col++) {
                int value = _square3x3[row][col];
                if (value > 0 && value < MAX_VALUE) {
                    values[value] = true;
                }
            }
        }
    }

    /**
     * Gets column number and boolean with 10 indexes, for each 1-9 cell values in the specific column it'll set the
     * value at the index ( cell values ) to true ( ex. 1,3,5 will set in the values array
     * values[1],values[5],values[3]=true )
     * @param col column between 0-2
     * @param values a boolean array
     */
    public void whosThereCol(int col, boolean[] values) {
        if (rowColInRange(col)) {
            for (int row = 0; row < _square3x3.length; row++) {
                int value = _square3x3[row][col];
                if (value > 0 && value < MAX_VALUE) {
                    values[value] = true;
                }
            }
        }
    }

    /**
     * This function checks if the number given is between 0 and 2.
     * @param rowCol the number given to the function
     * @return true if it's between 0-2, false otherwise
     */
    private boolean rowColInRange(int rowCol) {
        return rowCol >= 0 && rowCol < DEFAULT_ROW_COL;
    }



}

