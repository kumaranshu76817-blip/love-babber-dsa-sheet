import java.util.Arrays;

public class kthElement_02 {
    public static void main(String[] args) {
        int arr[] = {1,4,5,2,3};
        int k = 3;

        Arrays.sort(arr);

        int kthsmallest = arr[k-1];
        int kthLargest = arr[arr.length - k];

        System.out.println("smallest element"+kthsmallest);
        System.out.println("largset element:" + kthLargest);
    }
}
