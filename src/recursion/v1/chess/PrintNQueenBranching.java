package recursion.v1.chess;

public class PrintNQueenBranching {

    // Given a n*n chess board and n queen, print the maximum possible ways to place the queen so that everyone is safe from each other.

    public static void main(String[] args) {
        int length = 4;
        printNQueen(new boolean[length][length], "", 0,
                new boolean[length], new boolean[length * 2 - 1], new boolean[length * 2 - 1]);

    }

    public static void printNQueen(boolean[][] chessBoard, String queens, int row,
                                   boolean[] vertical, boolean[] fwdDiagonal, boolean[] revDiagonal) {

        if(row == chessBoard.length){
            System.out.println(queens + ".");
            return;
        }

        for (int col = 0; col < chessBoard[0].length; col++) {
            if (vertical[col] == false && fwdDiagonal[row + col] == false &&
                    revDiagonal[row - col + chessBoard.length - 1] == false) {
                chessBoard[row][col] = true;
                vertical[col] = true;
                fwdDiagonal[row + col] = true;
                revDiagonal[row - col + chessBoard.length - 1] = true;
                printNQueen(chessBoard, queens + row + "-" + col + ", ", row + 1, vertical, fwdDiagonal, revDiagonal);
                vertical[col] = false;
                fwdDiagonal[row + col] = false;
                revDiagonal[row - col + chessBoard.length - 1] = false;
                chessBoard[row][col] = false;
            }
        }

    }

}
