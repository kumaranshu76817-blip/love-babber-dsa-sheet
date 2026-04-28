import java.util.ArrayList;
import java.util.*;

class Pair<U,V>{
    U first;
    V second;
    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
}
public class two_sum_06 {

    //brute force
    public static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target){

        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();

        
        
        for(int i = 0; i<arr.size(); i++){
            for(int j=i+1; j<arr.size(); j++){
                if(arr.get(i) + arr.get(j) == target){
                    result.add(new Pair<>(arr.get(i), arr.get(j)));
                }
            }
        }
        if(result.size() == 0){
            result.add(new Pair<>(-1,-1));
            
        }
        return result;

    }

    //two pointer (sorting Approach)
    public static ArrayList<Pair<Integer, Integer>> twoSum1(ArrayList<Integer> arr, int target){
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        Collections.sort(arr);

        int left = 0;
        int right = arr.size() - 1;
        while(left<right){
            if(arr.get(right) + arr.get(left) == target){
                result.add(new Pair<>(arr.get(right), arr.get(left)));
                left++;
                right--;
            }
            else if(arr.get(right)+ arr.get(left) < target){
                left++;
            }
            else{
                right--;
            }
        }
        if(result.size() == 0){
            result.add(new Pair<>(-1,-1));

        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        ArrayList<Pair<Integer, Integer>> ans = twoSum1(arr, 6);

        for(Pair<Integer, Integer> p: ans){
            System.out.println(p.first+" "+ p.second);
        }
    }
}
