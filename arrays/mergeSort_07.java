import java.util.*;

public class mergeSort_07 {
    public static List<Integer> sortedArray(int [] arr1, int [] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int num: arr1){
            set.add(num);

        }
        for(int num: arr2){
            set.add(num);
        }

        ArrayList<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};
        int b[] = {1,2,3,4,5,6,7,8,9};

        List<Integer> result = sortedArray(a, b);
        System.out.println(result);
    }

}
