public class subsequence_with_k {


    static boolean solve(int [] arr, int k, int sum, int index){
        if(index >= arr.length){
            if(sum == k){
                return true;
            }
            else{
                return false;
            }
        }
        //include and exclude ka method use karnenge
        int currIndex = arr[index];
        boolean excludeAns = solve(arr, k, sum, index+1);
        boolean includeAns = solve(arr, k, sum + currIndex, index+1);
        return excludeAns || includeAns;
    }

    public static boolean subsequnce(int [] arr, int k){
        int index = 0;
        int sum = 0; 
        boolean ans = solve(arr, k, sum, index);
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,4,5,6};
        int k = 9;
        System.out.println(subsequnce(arr, k));
    }
}
