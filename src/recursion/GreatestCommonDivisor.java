package recursion;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(48, 18   ));

    }

    public static int gcd(int number1, int number2) {
        int reminder = number1 % number2;
        if (reminder == 0) {
            return number2;
        }
        return gcd(number2, reminder);
    }
}
