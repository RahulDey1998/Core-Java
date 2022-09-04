package recursion.v1;

public class PrintPermutation {

    public static void main(String[] args) {

        printPermutation("abc", "");

    }

    public static void printPermutation(String input, String result){

        if(input.length() == 0){
            System.out.println(result);
            return;
        }

        for(int i = 0 ; i < input.length() ; i++){
            char currentChar = input.charAt(i);
            String restString = new StringBuffer(input).deleteCharAt(i).toString();
            printPermutation(restString, result + currentChar);
        }
    }
}
