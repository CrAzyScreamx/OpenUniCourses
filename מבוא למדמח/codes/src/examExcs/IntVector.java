package examExcs;

public class IntVector {

    private int[] _arr;

    public IntVector(int size) {
        _arr = new int[size];
    }

    /* Complete your code here */
    public int equalSum() {
        if (_arr.length == 1) {
            return 0;
        }

        return equalSum(0);
    }

    private int equalSum(int i) {

        if (i == _arr.length) {
            return -1;
        }

        if (sumTo(i) == sumFrom(i+1)) {
            return i;
        }

        return equalSum(i+1);
    }

    private int sumTo(int i) {

        if (i == -1) {
            return 0;
        }
        return _arr[i] + sumTo(i-1);
    }

    private int sumFrom(int i) {
        if (i == _arr.length) {
            return 0;
        }

        return _arr[i] + sumFrom(i+1);
    }








    /* Ignore */
    public void fillOption1() {
        _arr = new int[5];
        _arr[0] = 2;
        _arr[1] = 1;
        _arr[2] = 6;
        _arr[3] = 5;
        _arr[4] = 4;
    }

    public void fillOption2() {
        _arr = new int[5];
        _arr[0] = 2;
        _arr[1] = 1;
        _arr[2] = 3;
        _arr[3] = 5;
        _arr[4] = 4;
    }

    public void fillOption3() {
        _arr = new int[3];
        _arr[0] = 3;
        _arr[1] = 1;
        _arr[2] = 2;
    }
}