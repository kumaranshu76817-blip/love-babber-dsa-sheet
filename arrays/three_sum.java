import java.util.*;

public class three_sum {


    //brute force  
     public static List<List<Integer>> threeSum(int [] arr){
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(arr);

        int n = arr.length;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k= j+1; k<n; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        ArrayList<Integer> temp = new ArrayList<>();

                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);

                        result.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(result);
     }
    // and many function of add after learn of this code
     public static void main(String[] args) {
        int [] arr = {-1,0,1,-2,1,-4,2};

        List<List<Integer>> ans = threeSum(arr);

        System.out.println("thripplets are");

        for(List<Integer> triplet: ans){
            System.out.println(triplet);
        }
     }
}
