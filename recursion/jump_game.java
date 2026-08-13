public class jump_game {
    //using brute force
    // public static  void loop(int [] nums){
    //     int index = 0;
    //     int value = nums[index];
    //     for(int i=0; i<nums.length; i++){
    //         if(nums[i] > value ){
    //             index++;
    //         }
    //     }
    // }


    static boolean solve(int []nums , int index){
        if(index == nums.length-1){
            return true;
        }
        if(index >= nums.length){
            return false;
        }
        if(nums[index] == 0){
            return false;
        }


        int jumpValue = nums[index];

        boolean overAllAns = false;
        for(int jump = 1; jump <= jumpValue; jump++){
            boolean recAns = solve(nums, index+jump);
            overAllAns = overAllAns|| recAns;

        }
        return overAllAns;

    }

    //using recursion
    public static boolean jump(int []nums){
        int index = 0;
        boolean ans = solve(nums, index);
        return ans;

    }

    public static void main(String[] args) {
        int nums[] = {2,3,0,4};
        int nums2[] = {3,2,1,0,4};
        System.out.println(jump(nums2));
    }
}
