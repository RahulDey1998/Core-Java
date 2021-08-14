package recursion;

public class DecimalToBinary {

    public static void main(String[] args) {

     decimalToBinary(8);
        System.out.println(decimalToBinary1(10));
    }

    public static void decimalToBinary(int number) {
        int quotient = number / 2;
        if(quotient == 0) {
            System.out.println(number);
            return;
        }
        int reminder = number % 2;
        decimalToBinary(quotient);
        System.out.println(reminder);
    }

    public static int decimalToBinary1(int number) {
        if(number == 0) {
            return 0;
        }
       return number%2 + 10 * decimalToBinary1(number/2);
    }
}
