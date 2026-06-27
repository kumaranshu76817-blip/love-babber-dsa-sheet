
/**
 * binary_search
 */
public class binary_search {

    static int solve(int arr[], int target, int s, int e){
        //1 case solve karte hai
        // binary search ka logic run karte hai

        int mid = s + ( e - s)/2;

        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid] > target){
            e = mid -1;
        }
        else if(arr[mid] < target){
            s = mid + 1;
        }
        return solve(arr, target, s, e);
    }

    static int binarySearch(int arr[], int target){
        int s = 0;
        int e = arr.length - 1;
        return solve(arr, target, s, e);
    }

    public static void main(String[] args) {
        int [] arr= {1,2,3,4,5,6};
        int target = 3;
        System.out.println(binarySearch(arr, target));
    }
}