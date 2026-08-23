import java.util.ArrayList;
import java.util.List;

public class combination_sum3 {

    static void solve(int [] candidates, int target, int index, List<Integer> output, List<List<Integer>> ans, int count, int k){
        if(count == k && target == 0){
            ans.add(new ArrayList<>(output));
            return;

        }
        if(count >= k || index >= candidates.length || target< 0){
            return;
        }

        output.add(candidates[index]);
        solve(candidates, target - candidates[index], index+1, output, ans, count+1, k);

        output.remove(output.size()-1);
        solve(candidates, target, index+1, output, ans, count, k);
        

    }


    public static  List<List<Integer>> combination3(int k, int n){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        int count = 0;
        int [] candidates = {1,2,3,4,5,6,7,8,9};
        int target = n;
        solve(candidates, target, index, output, ans, count, k);
        return ans;
    }

    public static void main(String[] args) {
        int k = 9;
        int n = 45;

        List<List<Integer>> result = combination3(k, n);

        System.out.println("Output:");
        System.out.println(result);
    }
}
