package recursion;

public class PowerOfANumber {

    public static void main(String[] args) {
        System.out.println(powerOfNLogarithmic(5,3));
    }

    public static int powerOfN(int number, int power) {
        if(power == 0) {
            return 1;
        }
        return number * powerOfN(number, power-1);
    }

    public static int powerOfNLogarithmic(int number, int power) {
        if(power == 0) {
            return 1;
        }
       int xToThePowerNBy2 = powerOfNLogarithmic(number, power/2);
        int xn = xToThePowerNBy2 * xToThePowerNBy2;

        if(power % 2 != 0){
            xn = xn * number;
        }

        return xn;
    }
}
