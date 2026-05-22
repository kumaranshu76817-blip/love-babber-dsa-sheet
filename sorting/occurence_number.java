public class occurence_number {
    public static int lowerBound(int[] arr, int target) {
        int n = arr.length ;
        int start = 0;
        int end = n - 1;
        int ans = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    // uper bound off array
    public static int uperBound(int[] arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int ans = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {

                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
            
        }
        return ans;

    }
    public static void main(String[] args) {
        int [] arr = {10,20,30,30,30,30,40,50};
        int target = 30;
        
        //for lower bound of an array
        System.out.println(lowerBound(arr, target));

        //upper bound of array
        System.out.println(uperBound(arr, target)  );

        //number of occurence
        int index1 = uperBound(arr, target);
        int index2 = lowerBound(arr, target);
        int total = index1 - index2;
        System.out.println(total);
    }
}
