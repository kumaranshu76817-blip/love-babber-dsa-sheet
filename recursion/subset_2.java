import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset_2 {

    static void solve(int [] nums, int index, List<Integer> output, List<List<Integer>> ans){
        if(index >= nums.length){
            ans.add(new ArrayList<>(output));
            return;
        }

        // include and exclude ka use karneng
        int currValue =  nums[index];
        output.add(currValue);
        solve(nums, index+1, output, ans);

        //backtracking
        output.remove(output.size()-1);
        //3 3 3 3 4
        //isko skip karne ke liye hamlog while loop a use karnenge
        //because this is subset 2 
        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }

        solve(nums, index+1, output, ans);
    }

    public List<List<Integer>> subset(int [] nums){

        // they pahle se sort karna parege then given integer ka ans aa jayega
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(nums, index, output, ans);
        return ans;
    }
    public static void main(String[] args) {
        

        subset_2 obj = new subset_2();

        int[] nums = { 1, 2, 3 };

        List<List<Integer>> ans = obj.subset(nums);

        System.out.println(ans);
    }
}
