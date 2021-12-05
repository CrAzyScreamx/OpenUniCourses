 

/**
 * Creates a 3x3 Square
 * @author Amit Y
 * @version 20/10/2021
 */
public class Square3x3 {

    private int[][] _square3x3;
    private static final int MIN_VALUE = 0;
    private static final int DEFAULT_ROW = 3;
    private static final int DEFAULT_COL = 3;
    private static final int MAX_VALUE = 10;

    /**
     * Constructs a two-dimensional array with the values of -1 in each cell
     */
    public Square3x3() {
        _square3x3 = new int[DEFAULT_ROW][DEFAULT_COL];
        for (int row = 0; row < _square3x3.length; row++) {
            for (int col = 0; col < _square3x3[row].length; col++) {
                _square3x3[row][col] = -1;
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
     * Constructs a two-dimensional array using values from another Square3x3 array
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
        if (row < _square3x3.length && row >= MIN_VALUE && col < _square3x3[row].length && col >= MIN_VALUE) {
            return _square3x3[row][col];
        } else {
            return -1;
        }
    }

    /**
     * Sets value at a specific cell
     * @param row row in the array
     * @param col column in the array
     * @param value value to set at row,column index
     */
    public void setXY(int row, int col, int value) {
        if (row < _square3x3.length && row >= MIN_VALUE && col < _square3x3[row].length && col >= MIN_VALUE) {
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
                if (col == 2) {
                    square += _square3x3[row][col] + "\n";
                } else {
                    square += _square3x3[row][col] + "\t";
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
        boolean[] values = new boolean[10];
        // Uses whosThereRow method to check numbers in each row specifically
        for (int row = 0; row < _square3x3.length; row++) {
            whosThereRow(row, values);
        }
        for (int row = 1; row < values.length; row++) {
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
        if (row < _square3x3.length && row >= MIN_VALUE) {
            for (int col = 0; col < _square3x3[row].length; col++) {
                int value = _square3x3[row][col];
                if (value > MIN_VALUE && value < MAX_VALUE) {
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
        if (col < _square3x3[MIN_VALUE].length && col >= MIN_VALUE) {
            for (int row = 0; row < _square3x3.length; row++) {
                int value = _square3x3[row][col];
                if (value > MIN_VALUE && value < MAX_VALUE) {
                    values[value] = true;
                }
            }
        }
    }



}

