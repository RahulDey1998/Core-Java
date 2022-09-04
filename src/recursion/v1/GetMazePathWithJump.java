package recursion.v1;

import java.util.ArrayList;
import java.util.List;

public class GetMazePathWithJump {
    /**
     *  2D Maze is having N,M rows and columns. You are in (0,0) position and
     *       you need to go to (n,m) position. At every step, you can go multiple steps vertical or horizontal and diagonal.
     *       Determine possible no of ways.
     */

    public static void main(String[] args) {
        getMazePaths(1,1, 3, 3).forEach(System.out::println);

    }

    public static List<String> getMazePaths(int srcRow, int srcCol, int desRow, int desCol){

        if(srcCol == desCol && srcRow == desRow){
            List<String> output = new ArrayList<>();
            output.add("");
            return output;
        }


        List<String> result = new ArrayList<>();

        //horizontal move
        for(int moveSize = 1 ; moveSize <= desCol - srcCol ; moveSize++){
            List<String> mazePaths = getMazePaths(srcRow, srcCol + moveSize, desRow, desCol);
            for (String path : mazePaths){
                result.add("h" + moveSize + path);
            }
        }

        //vertical move
        for(int moveSize = 1 ; moveSize <= desRow -srcRow; moveSize++){
            List<String> mazePaths = getMazePaths(srcRow + moveSize, srcCol , desRow, desCol);
            for (String path : mazePaths){
                result.add("v" + moveSize + path);
            }
        }

        //diagonal move
        for(int moveSize = 1 ; moveSize <= desRow -srcRow && moveSize <= desCol -srcCol; moveSize++){
            List<String> mazePaths = getMazePaths(srcRow + moveSize, srcCol + moveSize, desRow, desCol);
            for (String path : mazePaths){
                result.add("d" + moveSize + path);
            }
        }

        return result;

    }



}
