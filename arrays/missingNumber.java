import java.util.Arrays;

public class missingNumber {
    public static int binarySearch(int[] arr){
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == mid){
                start = mid +1;

            }
            else{
                end = mid -1;
            }
        }
        return start ;
    }
    public static int  missing(int [] arr){
        int xorSum = 0;
        // xor the each element in the array
        for(int n: arr){
            xorSum = xorSum ^ n;
        }
        // xor with all element in range

        for(int i=0; i<= arr.length; i++){
            xorSum = xorSum ^ i;
        }
        return xorSum;
    }
    public static void main(String[] args) {
        int [] arr = {0,1,2,3,5};
        
        System.out.println(missing(arr));
        System.out.println(binarySearch(arr));

    }
}
