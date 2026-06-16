public class unboundArray {
    static class infinteArray {
        private int[] arr;

        public infinteArray(int[] nums) {
            this.arr = nums;
        }

        public int get(int index) {
            // Simulates an infinite array by returning Integer.MAX_VALUE for
            // out-of-bounds
            if (index >= arr.length) return Integer.MAX_VALUE;
                return arr[index];
            }
        }
    public static int unboundSearch(infinteArray arr, int target) {
        if (arr.get(0) == target) {
            return arr.get(0);
        }
        int i = 1;
        while (arr.get(i) <= target) {
            i = i * 2;
        }
        if (arr.get(i) > target) {
            int start = i / 2;
            int end = i;

            // normal binay search
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr.get(mid) == target) {
                    return mid;
                } else if (arr.get(mid) > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        } else {
            return -1;
        }
        return -1;
    }
    public static void main(String[] args) {
        //number of arrays
        int[] nums = {2, 5, 7, 10, 15, 20, 25, 30, 35, 40, 45, 50};
        //new object 
        infinteArray arr = new infinteArray(nums);

        int target = 35;

        int result = unboundSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
