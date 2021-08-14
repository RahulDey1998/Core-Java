package problems.array;

import java.util.Arrays;
import java.util.stream.Stream;

public class RotateMatrix90 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr1 = {{1,2,3,4,6},{5,6,7,8,7},{1,2,3,4,4},{5,6,7,8,3},{9,8,7,6,1}};
        System.out.println("Original Array ->");
        printArray(arr1);
        System.out.println();
        rotateMatrix1(arr1);

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
        int flag = length -1;
        boolean isOdd = length % 2 == 0 ? false : true;
       for(int i = 0 ; i < length/2 ; i++) {
           int temp = arr[i][i]; // Storing the left uppermost value //(1,1) -> 6
           arr[i][i] = arr[flag][i]; // Setting up left uppermost value //(1,1) -> 6
           arr[flag][i] = arr[flag][flag]; //Setting up left below most value //(1,1) -> 6
           arr[flag][flag]= arr[i][flag]; // Setting up right below most vlaue
           arr[i][flag]=temp; // Setting up right top most most value

           for(int j = i ; j < length/ 2 ; j++) {
               if( isOdd && j == length/2 - 1) {
                   temp = arr[i][length/2];
                   arr[i][length/2] = arr[length/2][i];
                   arr[length/2][i] = arr[flag][length/2];
                   arr[flag][length/2] = arr[length/2][flag];
                   arr[length/2][flag] = temp;
               }

               else {
                   temp = arr[i][i + 1];
                   arr[i][i + 1] = arr[flag - 1][i];
                   arr[flag - 1][i] = arr[flag][flag - 1];
                   arr[flag][flag - 1] = arr[i + 1][flag];
                   arr[i + 1][flag] = temp;

                   temp = arr[i][flag - 1];
                   arr[i][flag - 1] = arr[i + 1][i];
                   arr[i + 1][i] = arr[flag][i + 1];
                   arr[flag][i + 1] = arr[flag - 1][flag];
                   arr[flag - 1][flag] = temp;
               }
           }

           flag--;
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
