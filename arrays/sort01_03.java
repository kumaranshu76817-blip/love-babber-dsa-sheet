public class sort01_03 {
    public static int []sort0and1(int [] arr){
        int n = arr.length;
        int left = 0; 
        int right = n - 1;
        while(left<= right){
            if(arr[left] == 1 && arr[right] == 0){
                arr[left] = 0;
                arr[right ] = 1;
            }
            if(arr[left] == 0){
                left++;
            }
            if(arr[right] == 1){
                right--;
            }
        }
        return arr;
    }

    public static void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }

            else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }

    }

    public static void main(String[] args) {
        int [] arr = {0,1,2,2,1,0};

       
        sort012(arr);

        for(int num: arr){
            System.out.print(num+" ");
        }
         

    }
}
