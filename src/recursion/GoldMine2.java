package recursion;

import java.util.ArrayList;
import java.util.List;

public class GoldMine2 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,4,2,8,2},{4,3,6,5,0,4},{1,2,4,1,4,6},{2,0,7,3,2,2},{3,1,5,9,2,4},{2,7,0,8,5,1}};
        getMaxGold(matrix);

    }


    public static void getMaxGold(int[][] matrix) {

        boolean[][] visited = new boolean[6][6];
        int maxGoldCollected = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] != 0 && visited[row][col] == false){
                    List<Integer> bagToCollectGold = new ArrayList<>();
                    travelAndCollectGold(matrix, row, col, bagToCollectGold, visited);

                    int totalCollectedGold = bagToCollectGold.stream().mapToInt(v->v).sum();
                    if(totalCollectedGold > maxGoldCollected){
                        maxGoldCollected = totalCollectedGold;
                    }
                }
            }
        }

        System.out.println(maxGoldCollected);
    }

    private static void travelAndCollectGold(int[][] matrix, int row, int col, List<Integer> goldCollected, boolean[][] visited) {

        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] == 0 || visited[row][col] == true){
            return;
        }

        visited[row][col] = true;
        goldCollected.add(matrix[row][col]);

        travelAndCollectGold(matrix, row - 1, col, goldCollected, visited);

        travelAndCollectGold(matrix, row, col + 1, goldCollected, visited);

        travelAndCollectGold(matrix, row + 1, col, goldCollected, visited);

        travelAndCollectGold(matrix, row, col - 1, goldCollected, visited);

    }

}
