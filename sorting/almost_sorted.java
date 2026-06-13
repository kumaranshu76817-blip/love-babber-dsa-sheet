public class almost_sorted{
    public static int findNerarestElement(int [] arr, int k){
        int start =0; 
        int end = arr.length -1;
        while(start<=end){
            int mid = start +(end - start)/2;
            if(mid - 1 >=0 && arr[mid -1]== k)
                return mid;
            if(arr[mid] == k)
                return mid;
            if(mid +1 < arr.length && arr[mid+1] == k)
                return mid;
            if(arr[mid]<k){
                start = mid +1;
            }
            else{
                end  = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {10,30,20,50,40,70,60,80};
        int k = 70;
        System.out.println(findNerarestElement(arr, k));
    }
}