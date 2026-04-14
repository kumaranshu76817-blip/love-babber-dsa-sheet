public class moveNegativepostive_03 {
    public static void moveNegative(int []arr){
        int left =0;
        int right = arr.length - 1;
        while(left<=right){
            if(arr[left]<0){
                left++;
            }
            else if(arr[right]>=0){
                right--;
            }
            else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args) {
        int [] arr ={0,1,6,5,-1,-2,-3,7};
        moveNegative(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
