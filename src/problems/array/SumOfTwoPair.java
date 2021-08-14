package problems.array;

    public class SumOfTwoPair {
        public static void main(String[] args) {
            int arr[] = {1,4,7,4,5,9,3};
            findPair(arr,12);

        }

        public static void findPair(int[] arr, int number) {

            for(int i = 0 ; i < arr.length; i++) {
                for(int j = i+1 ; j < arr.length ; j++) {
                    if(arr[i] + arr[j] == number) {
                        System.out.println("Two numbers are : " + arr[i] +", " +arr[j]);
                        return;
                    }
                }
            }
            System.out.println("No such pair found.");
        }
}
