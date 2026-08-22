import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_sum_2 {


    static void solve(int [] candidate, int target,int index,List<List<Integer>> ans, List<Integer> output){
        if(target == 0){
            ans.add(new ArrayList<>(output));
            return;
        }
        if(index >= candidate.length){
            return;
        }
        if(index < 0){
            return;
        }


        //1 case hamko solve karna hai baki recursion sambal lega
        //include and exclude ka pattern use hoga
        output.add(candidate[index]);
        //list me stored karnege


        //ifinite value dega list me store karne ke liye
        solve(candidate, target-candidate[index], index+1, ans, output);

        //backtracking ka set use kar reahe hai
        output.remove(output.size()-1);
        //duplicate value ko remove karenge
        while (index < candidate.length && candidate[index] == candidate[index+1]) {
            index++;
        }
        solve(candidate, target, index+1,ans, output);
    }

    public static List<List<Integer>> combination2(int [] candidate, int target){
        // Arrays.sort(candidate);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(candidate, target, index, ans, output);
        return ans;
    }

    public static void main(String[] args) {
        
        int [] candidate = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combination2(candidate, target));
    }
}
