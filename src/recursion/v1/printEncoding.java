package recursion.v1;

public class printEncoding {

    public static void main(String[] args) {

        printEncoding("12103", "");

    }

    public static void printEncoding(String input, String output){
        if(input == null || input.length() == 0){
            System.out.println(output);
            return;
        }
        if(input.charAt(0) == 48){
            return;
        }

        String firstDigit = String.valueOf((input.charAt(0) - 48));
        String firstTwoDigit = null;

        if(input.length() > 2)
         firstTwoDigit = input.substring(0,2);

        if(firstDigit != "0")
        printEncoding(input.substring(1), output + toChar(firstDigit));

        if(firstTwoDigit != null && firstDigit != "0" && Integer.valueOf(firstTwoDigit) < 27)
        printEncoding(input.substring(2), output + toChar(firstTwoDigit));

    }

    private static char toChar(String digit){
        int value = Integer.parseInt(digit) + 96;
        char charValue = (char)value;
        return charValue;
    }
}
