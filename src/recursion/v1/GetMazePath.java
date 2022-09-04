package recursion.v1;

import java.util.ArrayList;
import java.util.List;

public class GetMazePath {
    /**
     *  2D Maze is having N,M rows and columns. You are in (0,0) position and
     *       you need to go to (n,m) position. At every step, you can either go 1 step vertical or horizental.
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
        List<String> mazePathsHorizental = new ArrayList<>();
        List<String> mazePathsVertical = new ArrayList<>();

        if(srcCol < desCol) {
            mazePathsHorizental = getMazePaths(srcRow , srcCol + 1, desRow, desCol);// Moving horizontal

            for (String path : mazePathsHorizental) {
                result.add("h" + path);
            }
        }

        if(srcRow < desRow) {
             mazePathsVertical = getMazePaths(srcRow + 1, srcCol, desRow, desCol);// Moving vertical

            for (String path : mazePathsVertical) {
                result.add("v" + path);
            }
        }

        return result;

    }



}
