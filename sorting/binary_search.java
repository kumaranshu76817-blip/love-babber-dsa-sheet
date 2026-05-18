public class binary_search {
        public static int binarySearch(int [] arr, int target){
            int n = arr.length;
            int start = 0;
            int end = n-1;
            int mid = start +(end - start)/2;
            while (start<=end) {
                if(arr[mid] == target){
                    //target found 
                    return mid;
                }
                else if (arr[mid]<target) {
                    //agar target mid se bara then 
                    start = mid+1;
                }
                else{
                    //when target is lower than mid se then apply the code
                    end = mid-1;
                }
                mid = start + (end - start)/2;
            }
            return -1;
        }
        public static void main(String[] args) {
            int [] arr = {4,2,5,7,1};
            int target = 7;
            System.out.println(binarySearch(arr, target));

        }
}

