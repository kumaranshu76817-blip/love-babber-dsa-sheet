import java.util.* ;
import java.io.*; 

public class reverse_array_01
{
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        int left = m + 1;
        int right = arr.size() - 1;

        while (left < right) {
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int m = 3;

        reverseArray(arr, m);

        System.out.println(arr);
    }
}