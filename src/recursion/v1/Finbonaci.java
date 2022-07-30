package recursion.v1;

/**
 * @author rahul_dey
 */
public class Finbonaci {

    public static void main(String[] args) {
        System.out.println(findNthFobonaci(7));
    }

    public static int findNthFobonaci(int n){
        if(n == 0){
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        else {
            return findNthFobonaci(n-1) + findNthFobonaci(n-2);
        }
    }

}
