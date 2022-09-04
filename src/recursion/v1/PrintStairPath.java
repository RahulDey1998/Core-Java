package recursion.v1;

public class PrintStairPath {

    public static void main(String[] args) {

        printStairPath(5, "");

    }


    public static void printStairPath(int n, String path) {

        if (n == 0) {
            System.out.println(path);
            return;
        }
        if (n < 0) {
            return;
        }

        printStairPath(n - 3, path + "3");

        printStairPath(n - 2, path + "2");

        printStairPath(n - 1, path + "1");

    }
}
