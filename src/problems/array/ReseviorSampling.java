package problems.array;

/**
 * @author rahul_dey
 */

import java.util.Random;
import java.util.stream.Stream;

/**
 * Algorithm to find random k values from an array with n elements.
 */
public class ReseviorSampling {
    public static void main(String[] args) {

        int[] arr = {4,6,54,67,23,5,87,54,32,34,56,1,34,67,76};

        Stream.of(getKItems(arr, 6)).forEach(System.out::println);

    }

    public static int[] getKItems(int[] arr, int k){
        Random random = new Random();

        int[] result = new int[k];
        for(int i = 0 ; i < k ; i++){
            result[i] = arr[i];
        }

        //choosing the randomindex probablity is j/k
        for(int j = k+1 ; j < arr.length; j++){
           int randomIndex = random.nextInt(j);
           if(randomIndex < k){
               result[randomIndex] =  arr[j];
           }
        }

        return result;
    }

}
