package problems.array;

import java.util.Arrays;

/**
 * @author rahul_dey
 */
public class FindDuplicates {

    public static void main(String[] args) {
        int[] arr ={2,4,3,5,1,2,3};

        System.out.println("Duplicates are :");
        for(int i = 0 ; i < arr.length; i++){
            if(arr[Math.abs(arr[i])] > 0){
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
            else {
                System.out.println(Math.abs(arr[i]));
            }
        }
    }

}
