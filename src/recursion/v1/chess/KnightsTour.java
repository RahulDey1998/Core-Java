package recursion.v1.chess;

public class KnightsTour {

    public static void main(String[] args) {

        printKnightsTour(new int[5][5], 2,3, 0);

    }


    public static void printKnightsTour(int[][] chess, int row, int col, int moveCount) {
        if (row < 0 || col < 0 ||  row >= chess.length || col >= chess.length || chess[row][col] > 0) {
            return;
        } else if ((chess.length * chess.length) == moveCount) {
            chess[row][col] = moveCount;
            displayChessBoard(chess);
            chess[row][col] = 0;
            return;
        }

        chess[row][col] = moveCount;

        printKnightsTour(chess, row - 2, col + 1, moveCount + 1);
        printKnightsTour(chess, row - 1, col + 2, moveCount + 1);
        printKnightsTour(chess, row + 1, col + 2, moveCount + 1);
        printKnightsTour(chess, row + 2, col + 1, moveCount + 1);
        printKnightsTour(chess, row + 2, col - 1, moveCount + 1);
        printKnightsTour(chess, row + 1, col - 2, moveCount + 1);
        printKnightsTour(chess, row - 1, col - 2, moveCount + 1);
        printKnightsTour(chess, row - 2, col - 1, moveCount + 1);

        chess[row][col] = 0;
    }

    private static void displayChessBoard(int[][] chess) {

        System.out.println("---------------------------------");
        for(int i = 0 ; i < chess.length ; i++){
            for(int j = 0 ; j < chess[0].length ; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }
}
