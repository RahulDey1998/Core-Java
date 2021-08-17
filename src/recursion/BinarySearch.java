package recursion;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr,79,0,arr.length-1));

    }

    public static int binarySearch(int[] arr, int key, int beg, int end) {
        int mid = (beg + end)/2;
        if(beg <= end){
            if(arr[mid] == key) {
                return mid;
            }
            else if(arr[mid] > key) {
                return binarySearch(arr, key, beg, mid-1);
            }
            else {
                return binarySearch(arr, key, mid+1, end);
            }
        }
        else {
            return -1;
        }
    }
}
