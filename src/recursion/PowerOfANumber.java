package recursion;

public class PowerOfANumber {

    public static void main(String[] args) {
        System.out.println(powerOfN(5,3));
    }

    public static int powerOfN(int number, int power) {
        if(power == 0) {
            return 1;
        }
        return number * powerOfN(number, power-1);
    }
}
