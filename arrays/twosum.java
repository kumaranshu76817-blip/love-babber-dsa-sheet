public class twosum {
    //two sum by brute forcce
    public static int[] twoSum(int[] arr, int target){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] + arr[j] == target){
                    int ans[] = {arr[i], arr[j]};
                    return ans;

                }
            }
        }
        
        return new int[] {};
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int target = 5;

        int [] result = twoSum(arr, target);

        for(int num: result){
            System.out.print(num +" ");
        }
    }
}
