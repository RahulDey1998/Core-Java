package recursion.v1;

/**
 * @author rahul_dey
 */
public class TowerOfHanoi {

    public static void main(String[] args) {
        toh(3, 10, 11, 12);

    }

    public static void toh(int n, int t1, int t2, int t3) {
        if (n == 0) {
            return;
        }
        toh(n - 1, t1, t3, t2);
        System.out.println(n + " [" + t1 + " -> " + t2 + " ]");
        toh(n - 1, t3, t2, t1);
    }

}
