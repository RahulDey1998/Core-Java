package recursion.v1;

public class PrintAbbreviation {

    public static void main(String[] args) {

        printAbbr("pep", "", 0);

    }


    public static void printAbbr(String input, String output, int count){

        if(input.length() == 0){
            if(count > 0){
                System.out.println( output + count);
            }
            else {
                System.out.println(output);
            }
            return;
        }

        char currentChar = input.charAt(0);
        String restString = input.substring(1);

        if(count > 0) {
            printAbbr(restString, output + count + currentChar, 0);
        }
        else{
            printAbbr(restString, output + currentChar, count);
        }
        printAbbr(restString, output, count + 1);
    }
}
