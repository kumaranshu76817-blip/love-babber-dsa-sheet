// remove duplicate form sorted array

import java.util.HashSet;


public class remove_duplicate {

    //using hashset
    public static int duplicate(int [] arr){
        HashSet<Integer> set = new HashSet<>();

        for(int num: arr){
            set.add(num);
        }
        return set.size();
    }

    //using two pointer
    public static int duplicate2(int [] arr){
        int n = arr.length;
        if(n == 0){
            return 0;
        }

        int j = 0;
        for(int i=0; i<n; i++){
            if(arr[i] != arr[j]){
                j++;
                arr[j] = arr[i];
            }
            
        }
        return j+1;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,2,2,2,3,3,4};
        System.out.println(duplicate2(arr));
    }
}
