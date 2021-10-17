package maman13;

public class Square3x3 {

    private int[][] _squareArray = new int[3][3];

    public Square3x3() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                _squareArray[i][j] = -1;
            }
        }
    }

    public Square3x3(int[][] array) {

    }

    public Square3x3(Square3x3 other) {
        _squareArray = other.getSquareArray();
    }

    public int[][] getSquareArray() {
        return _squareArray;
    }
}

