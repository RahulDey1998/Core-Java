package problems.array;

import java.util.Arrays;
import java.util.stream.Stream;

public class RotateMatrix90 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,5},{7,4,5,6},{1,7,8,9},{4,7,6,2}};
        int[][] arr1 = {{1,2,3,4,6,3},{5,6,7,8,7,4},{1,2,3,4,4,2},{5,6,7,8,3,5},{9,8,7,6,1,6},{3,5,1,4,7,6}};
        int[][] arr2 = {{1,2,3,4,6,3,4},{5,6,7,8,7,4,3},{1,2,4,3,4,4,2},{5,5,6,7,8,3,5},{9,8,7,7,6,1,6},{3,5,6,1,4,7,6},{6,4,3,7,8,5,9}};
        System.out.println("Original Array ->");
        printArray(arr2);
        System.out.println();
        rotateMatrix1(arr2);

        System.out.println("After 90 degree transformation ->");

    }

    public static int[][] rotateMatrix(int[][] arr) {
        int length = arr.length;
        int[][] result = new int[length][arr[0].length];
        int resultIndex = 0;
        for(int i = 0 ; i < length ; i ++) {
            for(int j = length-1 ; j >= 0; j --) {
                result[i][resultIndex++] = arr[j][i];
            }
            resultIndex = 0;
        }
        return result;
    }

    public static int[][] rotateMatrix1(int[][] arr) {
        int length = arr.length;
        for(int layer = 0 ; layer < length/2 ; layer++)  {
           int first = layer;
           int last = length - 1 - layer;
           for(int i = layer ; i < last ; i++) {
              int offset = i - layer;
              int temp = arr[first][i];
              arr[first][i] = arr[last-offset][first];
              arr[last-offset][first] = arr[last][last-offset];
              arr[last][last-offset] = arr[i][last];
              arr[i][last] = temp;
            }
        }

       printArray(arr);
       return arr;
    }

    public static void printArray(int[][] arr) {
        Stream<int[]> array = Arrays.stream(arr);
        array.forEach(a -> {
            Arrays.stream(a).forEach(e -> System.out.print(e + " "));
            System.out.println();
        });

    }
}
