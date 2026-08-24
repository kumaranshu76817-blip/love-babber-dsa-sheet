import java.util.*;

public class premutation_string {

    static void solve(String s,String output, ArrayList<String> ans){
        if(s.isEmpty()){
            ans.add(output);
            return;
        }
        for(int i=0; i<s.length(); i++){
            String ch = String.valueOf(s.charAt(i));
            String resStirng = s.substring(0,i) + s.substring(i+1);
            solve(resStirng, output+ch, ans);
        }
    }
    public static ArrayList<String> premutation(String s){
        ArrayList<String> ans = new ArrayList<>();
        solve(s,"",ans);
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        ArrayList<String> ans =  premutation(s);

        System.out.println("Total permutations: " + ans.size());

        for (String str : ans) {
            System.out.println(str);
        }
    }
}
