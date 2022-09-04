package recursion.v1;

public class PrintMazePath {

    public static void main(String[] args) {

//        printMazePath(1,1,4,4, "");
        printMazePathWithJump(1,1,4,4, "");

    }

    public static void printMazePath(int srcRow, int srcCol, int desRow, int desCol, String path) {

        if(srcRow > desRow || srcCol > desCol){
            return;
        }
        if (srcRow == desRow && srcCol == desCol) {
            System.out.println(path);
            return;
        }

            printMazePath(srcRow + 1, srcCol, desRow, desCol, path + "v"); //vertical move

            printMazePath(srcRow, srcCol + 1, desRow, desCol, path + "h"); //horizontal move
    }

    public static void printMazePathWithJump(int srcRow, int srcCol, int desRow, int desCol, String path) {

        if (srcRow == desRow && srcCol == desCol) {
            System.out.println(path);
            return;
        }

        for(int i = 1 ; i <= desRow - srcRow ; i++ ) {
            printMazePath(srcRow + i, srcCol, desRow, desCol, path + "v" + i); //vertical move
        }

        for(int i = 1 ; i <= desCol - srcCol ; i++) {
            printMazePath(srcRow, srcCol + i, desRow, desCol, path + "h" + i); //horizontal move
        }

        for(int i = 1 ; i <= desCol && i <= desRow ; i++) {
            printMazePath(srcRow + i, srcCol + i, desRow, desCol, path + "d" + i); //diagonal move
        }
    }
}
