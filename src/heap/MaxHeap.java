package heap;

public class MaxHeap {
    public static void main(String[] args) {
        int[] arr = {1,5,6,8,12,14,16};
        buildMaxHeap(arr);

        print(arr);



    }

    public static void buildMaxHeap(int[] arr) {
        for(int i = arr.length/2 -1 ; i >= 0 ; i--) {
            heapify(arr,i);
        }
    }

    public static void heapSort(int[] arr){
        for(int i = 0 ; i < arr.length; i++) {
            swap(arr, 0, arr.length-1);
            heapify(arr, 0);
        }

    }

    public static void heapify(int[] arr, int i){
        int leftChild = i*2 + 1;
        int rightChild = i*2 + 2;
        int largest = 0;

        if(leftChild < arr.length && arr[leftChild] > arr[i]) {
            largest = leftChild;
        }
        else {
            largest = i;
        }

        if(rightChild < arr.length &&  arr[rightChild] > arr[i]) {
            largest = rightChild;
        }

        if(largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }

    }

    public static boolean isLeaf(int[] arr, int node) {
        if(node > arr.length/2 && node <= arr.length) {
            return true;
        }
        return false;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for(int i = 0 ; i < arr.length/2 ; i++) {
            System.out.println("Parent : - " + arr[i]);
            System.out.println("Left Child : - " + arr[2*i]);
            System.out.println("Right Child : - " + arr[2*i + 1]);
        }
    }
}
