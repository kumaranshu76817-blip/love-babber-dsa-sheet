public class partion_equal {
    static boolean solve(int target, int [] nums, int index)
   { if(index == 0 ){
        return true;
    }
    if(index < 0){
        return false;

    }
    if(index >= nums.length){
        return false;
    }



    // include and exclude ka method lagegaa
    boolean includeAns = solve(target-nums[index], nums, index+1);
    boolean excludeAns = solve(target, nums, index+1);

    return includeAns || excludeAns;
}

    public static boolean sumEqual(int [] nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        

        // this is imprortant thing in flase and true
        if((sum & 1) == 1){
            return false;
        }

        int target = 0;
        int index = 0;
        boolean ans = solve(target, nums, index);
        return ans;
    }


    public static void main(String[] args) {
        int nums[] = {1,5,11,5};

        System.out.println(sumEqual(nums));
    }
}
