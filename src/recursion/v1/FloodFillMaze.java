package recursion.v1;

import java.util.Scanner;

public class FloodFillMaze {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row & column number :");
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] arr = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        floodFill(arr, 0, 0, "", new boolean[row][column]);

    }

    public static void floodFill(int[][] maze, int row, int col, String pathSoFar, boolean[][] visited) {

        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col]) {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(pathSoFar);
            return;
        }

        visited[row][col] = true;
        floodFill(maze, row - 1, col, pathSoFar + "t", visited); // moving top
        floodFill(maze, row, col - 1, pathSoFar + "l", visited); // moving left
        floodFill(maze, row + 1, col, pathSoFar + "b", visited); // moving bottom
        floodFill(maze, row, col + 1, pathSoFar + "r", visited); // moving right
        visited[row][col] = false;

    }
}
