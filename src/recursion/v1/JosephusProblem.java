package recursion.v1;

public class JosephusProblem {

    public static void main(String[] args) {


    }

    public static int solution(int n, int k) {

        if(n == 1){
            return 0;
        }

        int result = solution (n - 1, k);
        return (result + k) % n;
    }
}
