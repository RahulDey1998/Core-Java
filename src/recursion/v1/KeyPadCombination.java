package recursion.v1;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rahul_dey
 */
public class KeyPadCombination {

    //
//
//
    public static void main(String[] args) {
        char[][] keyList = {{'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'} ,
                {'p','q','r'}, {'s','t','u'}, {'v','w','x'}, {'y','z'}, {'?', '!'}};
        getCombination(keyList, "01").forEach(System.out::println);
        System.out.println();
        System.out.println(getCombination(keyList, "01").size());
        System.out.println();
        printKeyPadCombination(keyList, "01", "");


    }

    public static List<String> getCombination(char[][] keyPadNumbers, String digit) {
        if (digit == null || digit.length() == 0) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        int currentDigit = Integer.parseInt(digit.substring(0,1));
        List<String> combinationList = getCombination(keyPadNumbers, digit.substring(1));
        List<String> result = new ArrayList<>();

        for (char character : keyPadNumbers[currentDigit]) {
            for (String combination : combinationList) {
                result.add(character + combination);
            }
        }
        return result;
    }


    public static void printKeyPadCombination(char[][] keyPadNumbers, String digit, String result){

        if(digit.length() == 0){
            System.out.println(result);
            return;
        }

        int currentDigit = Integer.valueOf(String.valueOf(digit.charAt(0)));
        String subString = digit.substring(1);

        for(int i = 0 ; i <keyPadNumbers[currentDigit].length; i++){
            printKeyPadCombination(keyPadNumbers, subString, result + keyPadNumbers[currentDigit][i]);
        }

    }


}
