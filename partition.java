import java.util.ArrayList;
import java.util.List;


public class partition {
    public static void main(String[] args){
        int[] arr = {4, 5, 3, 7, 2, 1, 6};
        func(arr);
    }
    public static void func(int[] arr ){
        int pivot = arr[0];

    List<Integer> left = new ArrayList<>();
    List<Integer> equal = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    for (int num : arr) {
        if (num < pivot) {
            left.add(num);
        } else if (num == pivot) {
            equal.add(num);
        } else {
            right.add(num);
        }
    }

    List<Integer> result = new ArrayList<>();
    result.addAll(left);
    result.addAll(equal);
    result.addAll(right);

     System.out.println(result);
    }
}