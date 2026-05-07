//find duplicate in the arrays

import java.util.Arrays;
import java.util.HashSet;


public class findDuplicateArray {
    //brute force
    public static int findDuplicate(int [] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    return arr[i];
                }
            }
        }
        return -1;
    }

    //sorting Approach
    public static int findDuplicate2(int[] arr){
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i] == arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }

    // hashset approach
    public static int findDuplicate3(int [] arr){
        HashSet<Integer> set = new HashSet<>();

        for(int num: arr){
            if(set.contains(num)){
                return num;
            }
             set.add(num);
        }
        return -1;
    }

    //xorsum 
    public static int findDuplicate4(int [] arr){
        int xorsum = 0;
        for(int num: arr){
            xorsum ^= num;
        }
        int n = arr.length;
        for(int i=0; i<n; i++){
            xorsum ^= i;
        }
        return xorsum;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,5};

        System.out.println(findDuplicate(arr));
        System.out.println(findDuplicate2(arr));
        System.out.println(findDuplicate3(arr));
        System.out.println(findDuplicate4(arr));
        
    }    

}
