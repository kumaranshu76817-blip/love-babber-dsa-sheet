import java.util.ArrayList;
import java.util.List;

public class subset_1 {

    static void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> ans) {
        if (index >= nums.length) {
            // subsequnce mil gya to
            ans.add(new ArrayList(output));
            return;
        }

        // include and exclude wala pattern lagayenge
        
        output.add(nums[index]);
        solve(nums, index +1, output, ans);

        // backtracking ka concept lagyenge
        output.remove(output.size() - 1);

        // exclude
        solve(nums, index + 1, output, ans);

    }

    public List<List<Integer>> subsetwitDup(int[] nums) {
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        solve(nums, index, output, ans);
        return ans;
    }

    public static void main(String[] args) {

        subset_1 obj = new subset_1();

        int[] nums = { 1, 2, 3 };

        List<List<Integer>> ans = obj.subsetwitDup(nums);

        System.out.println(ans);
    }
}
