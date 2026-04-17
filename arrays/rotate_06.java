import java.util.ArrayList;
import java.util.Arrays;

public class rotate_06 {
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k){
        int n = arr.size();

        k = k%n;

        //reverse first k element
        reverse(arr, 0 , k-1);

        //reverse remaning element
        reverse(arr, k, n-1);

        //reverse whole element
        reverse(arr, 0, n-1);

        return arr;
        
    }

    public static void reverse(ArrayList<Integer> arr, int start, int end){
        while(start<end){
            int temp;
            temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer>  arr = new ArrayList<>(Arrays.asList(1,2,3,3,4,5,6));
        rotateArray(arr, 3);
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i)+" ");
        }
    }
}
