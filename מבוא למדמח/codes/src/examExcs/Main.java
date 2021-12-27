package examExcs;

/**
 * Main class of the Java program.
 *
 */
public class Main {

    public static void main(String[] args) {

        IntVector v1 = new IntVector(5);
        v1.fillOption1();
        System.out.println("For call equalSum() with _arr = [2,1,6,5,4], result is " + v1.equalSum());

        IntVector v2 = new IntVector(5);
        v2.fillOption2();
        System.out.println("For call equalSum() with _arr = [2,1,3,5,4], result is " + v2.equalSum());

        IntVector v3 = new IntVector(3);
        v3.fillOption3();
        System.out.println("For call equalSum() with _arr = [3,1,2], result is " + v3.equalSum());
    }
}
