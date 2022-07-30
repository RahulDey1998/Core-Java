//package recursion.tree;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class PrintZigZag {
//
//    public static void main(String[] args) {
////        Integer[] arr = {1, 2, 3, 5, 4, 7, 10};
////        sortOddDescEvenAsc(arr);
//        sprialMatrix();
//
//    }
//
//    public static void sortOddDescEvenAsc(Integer [] arr) {
//        Integer[] mainArr = arr;
//        List<Integer> resultList = new ArrayList<>();
//        Arrays.sort(arr);
//        for(int i = arr.length-1; i >= 0; i--) {
//            if(arr[i] % 2 != 0) {
//                resultList.add(arr[i]);
//            }
//        }
//        for(int i = 0 ; i < arr.length; i++) {
//            if(arr[i] % 2 == 0) {
//                resultList.add(arr[i]);
//            }
//        }
//        resultList.forEach(value -> System.out.print(value + " "));
//
//    }
///*
//    Input:  1    2   3   4
//            5    6   7   8
//            9   10  11  12
//            13  14  15  16
//    Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
//
// */
//
//
//
//
//}
