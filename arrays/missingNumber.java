public class missingNumber {
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
    }
}
