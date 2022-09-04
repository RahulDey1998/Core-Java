package recursion.v1;

public class PrintSubSequence {

    public static void main(String[] args) {

        printSubSequence("abc", "");

    }

    public static void printSubSequence(String input, String result){

        if(input.length() == 0){
            System.out.println(result);
            return;
        }

        char currentChar = input.charAt(0);
        String subString = input.substring(1);

        printSubSequence(subString, result + currentChar);
        printSubSequence(subString, result + "");
    }
}
