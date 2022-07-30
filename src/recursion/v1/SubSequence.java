package recursion.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rahul_dey
 */
public class SubSequence {

    //example of subsequence of abc -> [abc, ab-, a-c, -bc, -b-, --c, a--, ---]

    public static void main(String[] args) {
       getSubsequence("ABC").forEach(System.out::println);
        System.out.println(getSubsequence("ABC").size());

    }

    public static List<String> getSubsequence(String s){
        if(s == null || s.length() == 0){
            List<String> sequenceList = new ArrayList<>();
            sequenceList.add("");
            return sequenceList;
        }
        char currentChar = s.charAt(0); // a
        List<String> sequenceList = getSubsequence(s.substring(1)); // bc [ b-, bc, -c, --]
        List<String> outputList = new ArrayList<>(); //[abc, ab-, a-c, -bc, -b-, --c, a--, ---]

        for(String sequence : sequenceList){
           outputList.add(sequence);
        }
        for(String sequence : sequenceList){
           outputList.add(currentChar+sequence);
        }
        return outputList;
    }


}
