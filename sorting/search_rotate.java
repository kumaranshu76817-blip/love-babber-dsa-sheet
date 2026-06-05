public class search_rotate {

    static int findPivot(int [] arr){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        if(arr[start]<arr[end]){
            return -1;
        }
        while(start<=end){
            int mid = start + (end - start)/2;

            //l1 index is 50,60,70 is stored
            //l1 me nahi to move on kar do l2 ke liye
            if(arr[mid] <= arr[n-1]){
                end = mid -1;
            }
            //l2 me mil gya ko answer ko return kar do
            else{
                ans = mid;
                start= mid +1;
            }
        }
        return ans;
    }
    static int binarySearch(int [] arr, int start, int end, int target){

        while(start<= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }
        return -1;
    }
    public static int search(int [] arr, int target){
        int pivotIndex = findPivot(arr);
        int n = arr.length;

        //if pivotindex = -1 the array is alerady sorted
        if(pivotIndex == -1){
            int ans = binarySearch(arr, 0, n-1, target);
            return ans;
        }
        else{
            //array is not sorted , rotated sorted

            //target L2 main hai to find karo
            //next l1 me jao
            int startArray = 0;
            int endArray = pivotIndex;
            if(target >= arr[startArray] && target<= arr[endArray]){
                int ans = binarySearch(arr, startArray, endArray, target);
                return ans;
            }

            //l1 ka code
            int startArray2 = pivotIndex +1;
            int endArray2 = n - 1;
            if(target >= arr[startArray2] && target<= arr[endArray2]){
                int ans = binarySearch(arr, startArray2, endArray2, target);
                return ans;
            }


            return -1;
        }
    }
    public static void main(String[] args) {
        int [] arr = {50,60,70,10,20,30,40};
        // int n = arr.length;

        //l1 ke liye pivot target
        int target = 70;

        //l2 ke liye pivot target
        int target2 = 30;
        
        //binary search function of runtime
        // System.out.println(binarySearch(arr, 0, arr.length, target));

        //pivot index chek karne ke liye 
        // System.out.println(findPivot(arr));
        

        //finally answer searh in l1 pivot karne ke liye
        System.out.println(search(arr, target));

        //finally answer search in l2 pivot ke liye
        System.out.println(search(arr, target2));

    }
}