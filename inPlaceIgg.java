import java.util.Arrays;

public class inPlaceIgg{
    public static void main(String[] arg){
        int[] arr = {4, 5, 3, 7, 2, 1, 6,7,1};
        quicksort(arr, 0, arr.length - 1);
    }
    public static int partition(int[] arr , int low, int high){
        
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low ; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i +1;
    } 
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            System.out.println(Arrays.toString(arr));
            quicksort(arr, low, pivotIndex - 1);
            System.out.println(Arrays.toString(arr));
            quicksort(arr, pivotIndex + 1, high);
            System.out.println(Arrays.toString(arr));
        }
    }
}