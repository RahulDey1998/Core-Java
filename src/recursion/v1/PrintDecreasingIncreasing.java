package recursion.v1;

/**
 * @author rahul_dey
 */
public class PrintDecreasingIncreasing {

    public static void main(String[] args) {
        pdi(5);

    }

    public static void pdi(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }

}
