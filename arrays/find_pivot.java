public class find_pivot {
    public static int pivotIndex(int [] arr){
        int n = arr.length;
        int leftsum []= new int[n];
        int rightsum[] = new int[n];

       leftsum[0] = arr[0];

        //leftsum of wala arraya add kar do
        for(int i=1; i<n; i++){
            leftsum[i] = leftsum[i-1] + arr[i];
        }

        //fill right sum wala arrays
        rightsum[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            rightsum[i] = rightsum[i+1] + arr[i];
        }

        for(int i=0; i<n; i++){
            if(leftsum[i] == rightsum[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr [] = {1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));
    }
    
}