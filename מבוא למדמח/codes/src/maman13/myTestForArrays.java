package maman13;

public class myTestForArrays {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] transed = new int[3][3];
        for (int r = 0; r < test.length; r++) {
            for (int c = 0; c < test[r].length; c++) {
                transed[r][c] = test[c][r];
            }
        }
    }

}
