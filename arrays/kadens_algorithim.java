//subarray sum;
public class kadens_algorithim {
    public static int subarraySum(int [] arr){
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
            maxi = Math.max(maxi, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,-3,4,1,-1,3,4,6};
        System.out.println(subarraySum(arr));

    }
}
