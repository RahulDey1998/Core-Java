package recursion.v1;

import java.util.stream.Stream;

/**
 * @author rahul_dey
 */
public class PrintArray {

    public static void main(String[] args) {
//        printArray(new int[]{10, 11, 23, 45, 67, 89}, 0);
//        printArrayReverse(new int[]{10, 11, 23, 45, 67, 89}, 0);
//        System.out.println(getMaxV2(new int[]{10, 11, 23, 45, 67, 89}, 0));
//        System.out.println(getLastIndex(new int[]{10, 11, 67, 9, 23, 45, 9, 67, 89}, 67, 0));
        int[] allIndex = getAllIndex(new int[]{10, 11, 67, 9, 23, 45, 9, 67, 89}, 9, 0, 0);
        for(int val : allIndex){
            System.out.println(val);
        }


    }

    public static void printArray(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        System.out.println(arr[index]);
        printArray(arr, ++index);
    }

    public static void printArrayReverse(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        printArrayReverse(arr, index + 1);
        System.out.println(arr[index]);
    }

    public static int getMaxV2(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        int maxValue = getMaxV2(arr, index + 1);
        if (maxValue > arr[index]) {
            return maxValue;
        } else {
            return arr[index];
        }
    }

    public static int getFirstIndex(int[] arr, int value, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == value) {
            return index;
        } else {
            return getFirstIndex(arr, value, index + 1);
        }
    }

    public static int getLastIndex(int[] arr, int value, int index) {
        if(index == arr.length){
            return -1 ;
        }
        int lastIndex = getLastIndex(arr, value, index + 1);
        if (lastIndex == -1 && arr[index] == value) {
            return index;
        } else return lastIndex;
    }

    public static int[] getAllIndex(int[] arr, int value, int index, int count ) {
        if(index == arr.length){
            return new int[count];
        }

        if(arr[index] == value){
            count++;
        }
        int[] result = getAllIndex(arr, value, index + 1, count);
        if(arr[index] == value){
            result[--count] = index;
        }
        return result;
    }
}
