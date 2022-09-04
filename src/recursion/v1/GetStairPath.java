package recursion.v1;

import java.util.ArrayList;
import java.util.List;

public class GetStairPath {
    //No of ways to climb from stair. One can take 1, 2, 3 step at a time.


    public static void main(String[] args) {

        getStairPath(7).forEach(System.out::println);


    }

    public static List<String> getStairPath(int stairNo) {

        if (stairNo == 0) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        else if(stairNo < 0){
            return new ArrayList<>();
        }


        List<String> result = new ArrayList<>();

        List<String> stairPath1 = getStairPath(stairNo - 1);
        for (String path : stairPath1) {
            result.add("1" + path);
        }


        List<String> stairPath2 = getStairPath(stairNo - 2);
        for (String path : stairPath2) {
            result.add("2" + path);
        }

        List<String> stairPath3 = getStairPath(stairNo - 3);
        for (String path : stairPath3) {
            result.add("3" + path);
        }

        return result;

    }
}
