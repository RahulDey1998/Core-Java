package recursion.v1;

/**
 * @author rahul_dey
 */
public class XtoThePowerN {

    public static void main(String[] args) {

        System.out.println(xToThePowerN(2.0,32));
        System.out.println(xToThePowerNLogarithmic(2.0,32));

    }


    public static Double xToThePowerN(Double number, int power){
        if(power == 0){
            return 1.0;
        }
        return number * xToThePowerN(number, power - 1);
    }

    public static Double xToThePowerNLogarithmic(Double number, int power){
        if(power == 0){
            return 1.0;
        }
        Double xToThePowerNby2 =   xToThePowerNLogarithmic(number, power / 2);
        Double xToThePowerN = xToThePowerNby2 * xToThePowerNby2;

        if(power % 2 != 0){
            xToThePowerN = xToThePowerN * number;
        }

        return xToThePowerN;
    }

}
