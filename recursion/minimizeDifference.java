// in this question says ek matrix aur ek target hai
// matrix ke row wise jitne sum uske target se minius karnes pe jo
// minimum ans aarrah hai usko return kar de

public class minimizeDifference {

    static int solve(int sum, int target, int[][] mat, int row){
        // base case solve 
        // last me kya hoga
        if(row >= mat.length){
            //invalid row 
            //sum is ready 
            //calculate the difference btw target and sum
            //store and return the diff
            return Math.abs(target - sum);
        }

        int mini = Integer.MAX_VALUE;
        //mai row index pe khada hu matlb isme multiple columns

        // ek case hmm solve karngen baaki recursion saambal lega
        for(int num: mat[row]){
            int ans = solve(sum + num, target, mat, row+1);
            mini = Math.min(mini, ans);
        }
        return mini;
    }

    public static int minimizeDiff(int [][] mat, int target){
        int row = 0;
        int sum = 0;
        int ans = solve(sum, target, mat, row);
        return ans;
    }


    public static void main(String[] args) {
        int [][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int target = 13;
        System.out.println(minimizeDiff(mat, target));
    }
}
