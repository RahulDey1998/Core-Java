package recursion;

public class Factorial {
    public static void main(String[] args) {

        System.out.println(fact(5));
    }

    public static int fact(int number){
        if(number == 0 || number ==1 ) {
            return 1;
        }
        else
        {
            return number * fact(number-1);
        }
    }
}
