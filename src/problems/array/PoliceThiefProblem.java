//package problems.array;
//
///*
//Given an array of size n that has the following specification
//1. Each element contains either police or theif
//2. Each police can catch one thief
//3. A police can catch a thief who is more than K units away
//from the policeman.
//
//[T,T,P,P,T,P], if K = 2 then result is 3
//[T,T,P,P,T,T,P,T,T,T,P,P,P]
// */
//
//public class PoliceThiefProblem {
//
//    public static void main(String[] args) {
//        char[] arr = {'T', 'T', 'P', 'P', 'T', 'P'};
//
//
//    }
//
//    public static int getNoOfThiefCaught(char[] arr, int k) {
//        boolean[] result = new boolean[arr.length];
//        int count = 0;
//
//        for(int i = 0 ; i < arr.length; i++) {
//
//            if(arr[i] == 'P') {
//                int iterationCount = 0;
//                int currentIndex = i;
//                int leftLastEncountered = 0;
//                while(iterationCount < k && currentIndex> 0) {
//                    if(arr[currentIndex-1] == 'T') {
//                        leftLastEncountered = i-1;
//                   }
//                    iterationCount++;
//                    currentIndex--;
//                }
//                iterationCount = 0;
//
//                int rightLastEncountered = 0;
//                while(iterationCount < k && i) {
//                    int lastEncountered = 0;
//                    if(arr[i-1] == 'P') {
//                        lastEncountered = i-1;
//                    }
//                    iterationCount++;
//                }
//            }
//
//
//
//        }
//
//    }
//
//}
