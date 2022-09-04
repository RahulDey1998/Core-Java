package recursion.v1.chess;

public class PrintNQueen {

    // Given a n*n chess board and n queen, print the maximum possible ways to place the queen so that everyone is safe from each other.

    public static void main(String[] args) {
        printNQueen(new int[4][4], "", 0);

    }

    public static void printNQueen(int[][] chessBoard, String queens, int row) {

        if (row == chessBoard.length) {
            System.out.println(queens +".");
            return;
        }

        for (int col = 0; col < chessBoard[0].length; col++) {
            if (isQueenNotPresentVertically(chessBoard, row, col) && isQueenNotPresentDiagonally(chessBoard, row, col)) {
                chessBoard[row][col] = 1;
                printNQueen(chessBoard, queens + row + "-" + col + ", ", row + 1);
                chessBoard[row][col] = 0;
            }
        }


    }

    private static boolean isQueenNotPresentVertically(int[][] chessBoard, int row, int col) {
        for (int theRow = row - 1; theRow >= 0; theRow--) {
            if (chessBoard[theRow][col] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isQueenNotPresentDiagonally(int[][] chessBoard, int row, int col) {
        for (int i = row -1, j = col -1 ; i >= 0 && j >= 0 ; i--, j--) { //Left diagonal search
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }
        for (int i = row -1, j = col +1 ; i >= 0 && j < chessBoard.length ; i--, j++) { //right diagonal serach
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
