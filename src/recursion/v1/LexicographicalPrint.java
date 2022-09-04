package recursion.v1;

import java.util.stream.IntStream;

public class LexicographicalPrint {

    public static void main(String[] args) {

//        print("1000", "0");

        IntStream.range(1, 10).forEach(val -> dfs(1000, val));

    }


    //Aproach 1
    public static void print(String maxNumber, String number) {

        if (isGrater(number, maxNumber)) {
            return;
        }
        System.out.println(number);

        for (int i = 0; i <= 9; i++) {
            if (!isZero(number + i)) {
                print(maxNumber, String.valueOf(intValue(number + i)));
            }
        }
    }

    //Aproach 2
    public static void dfs(int max, int currNumber){

        if(currNumber > max){
            return;
        }

        System.out.println(currNumber);
        for(int i = 0 ; i < 10 ; i++){
            dfs(max, currNumber * 10 + i);
        }
    }


    public static boolean isGrater(String number1, String number2) {
        if (Integer.parseInt(number1) > Integer.parseInt(number2)) {
            return true;
        }
        return false;
    }

    public static boolean isZero(String number) {
        return Integer.parseInt(number) == 0;
    }

    public static int intValue(String value){
        return Integer.parseInt(value);
    }
}
