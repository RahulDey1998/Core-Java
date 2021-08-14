package recursion;

public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println(sum(1234));
        System.out.println(sum1(1234,0));

    }

    public static int sum(int number){
        if(number <= 0) {
            return 0;
        }
        else {
            int lastDigit = number%10;
            return lastDigit + sum(number/10);
        }

    }

    public static int sum1(int number, int acc){
        if(number <= 0) {
            return acc + number;
        }
        else {
            int lastDigit = number%10;
            return sum1(number/10, acc + lastDigit);
        }

    }

}
