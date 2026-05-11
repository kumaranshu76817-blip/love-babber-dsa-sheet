import java.util.*;

public class missingelement {
    public List<Integer> findDissapereadnumber(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        //mark visited number
        for (int i = 0; i < n; i++) {
            int value = Math.abs(arr[i]);
            int position = value - 1;

            if (arr[position] > 0) {
                arr[position] = -arr[position];
            }

        }
        //find missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        missingelement obj = new missingelement();
        int [] arr = {4,3,2,7,2,3,1};
        List<Integer> result = obj.findDissapereadnumber(arr);
        System.out.println("missing number are" + result);
    }
}
