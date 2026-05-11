public class subarrayProduct {
    //brute force
    public static int productsub(int [] arr){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int product = 1;
            for(int j = i; j<n; j++){
                product *= arr[i];
                maxi = Math.max(maxi,product);
            }
        }
        return maxi;

    }
    //best solution
    public static int productsub1(int [] arr){
        int n = arr.length; 
        int prefix = 0;
        int suffix = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix *= arr[i];
            suffix *= arr[n-i-1];
            maxi = Math.max(maxi, Math.max(prefix, suffix));
        }
        return maxi;
    }

    public static void main(String[] args) {
        int [] arr = {1,5,-3,5,-2,3};
        System.out.println(productsub(arr));
        System.out.println(productsub1(arr));
    }
}
