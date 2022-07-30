package sorting;

import java.util.stream.Stream;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
       print(arr);

        mergeSort(arr, 0, arr.length - 1);
        print(arr);


    }

    public static void mergeSort(int[] arr, int left, int right) {
          if(left < right) {
              int mid = left + ((right - left) / 2);
              mergeSort(arr,left, mid);
              mergeSort(arr, mid + 1, right);
              merge(arr, left, mid, right);

          }
    }

    public static void merge(int[] arr, int beg, int mid, int end) {
        int length1 = mid - beg + 1;
        int length2 = end - mid;
        int[] arr1 = new int[length1];
        int[] arr2 = new int[length2];

        for(int i = 0 ; i < length1 ; i++) {
            arr1[i] = arr[beg + i];
        }
        for(int j = 0 ; j < length2 ; j++) {
            arr2[j] = arr[j + mid + 1];
        }

        int counter = beg;
        int firstPointer = 0;
        int secondPointer = 0;
       while(firstPointer < length1 && secondPointer < length2) {
         if(arr1[firstPointer] <= arr2[secondPointer]) {
             arr[counter] = arr1[firstPointer];
             firstPointer++;
         }
         else {
             arr[counter] = arr2[secondPointer];
             secondPointer++;
         }
         counter++;
       }

       while (firstPointer < length1){
           arr[counter] = arr1[firstPointer];
           firstPointer++;
           counter++;
       }
        while (secondPointer < length2){
            arr[counter] = arr2[secondPointer];
            secondPointer++;
            counter++;
        }

    }

    public static void print(int[] arr) {
        for(int i : arr){
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
