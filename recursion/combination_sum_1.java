import java.util.ArrayList;
import java.util.List;

public class combination_sum_1 {

    static void solve(int [] candidates, int target,int index, List<Integer> output , List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(output));
            return;
        }
        if(index >= candidates.length){
            return;
        }
        if(index < 0){
            return;
        }

        output.add(candidates[index]);
        solve(candidates, target - candidates[index], index, output, ans);

        output.remove(output.size()-1);

        solve(candidates, target, index+1, output, ans);



    }
    public static List<List<Integer>> combination(int [] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(candidates, target, index, output , ans);
        return ans;
    }


    public static void main(String[] args) {
        int candidates [] = {2,2,3,7};
        int target = 7;
        System.out.println(combination(candidates, target));
    }
}
