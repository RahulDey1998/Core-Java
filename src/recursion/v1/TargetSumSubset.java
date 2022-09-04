package recursion.v1;

public class TargetSumSubset {

    //Given an array and a number,  we need to find all the combination, whose sum is equal the given number.

    public static void main(String[] args) {

        printSubset(new int[]{10, 20, 30, 40, 50}, 0, "", 0, 70);


    }

    public static void printSubset(int[] arr, int index, String set, int sum, int target){
        if(index == arr.length){

            if(target == sum){
            System.out.println(set);}
            return;
        }

        printSubset( arr, index + 1, set +" " +arr[index], sum + arr[index], target);
        printSubset( arr, index + 1, set , sum , target);
    }
}
