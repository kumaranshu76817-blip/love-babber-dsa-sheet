//this question says if robbers theifs one house then not continous theif neighbhours house because they have smart alert system are obtain in the house because they theif one house leave and theif in third house 

// the ans is not succes because they time limit exceed 
//dynamic programming se accha se solve karnenge 


public class house_robber {
    static int solve(int []nums,int index){
        if(index>=nums.length){
            return 0;

        }
        //ek case solve karna hai baki recursion sambal lega
        //isme hmm first house ko le kar and next house leave kar rahe hai
        int include = nums[index] + solve(nums, index+2);
        //isem hmm first house ko leave kar diya and next house me robbery karnenge
        int exclude = 0 + solve(nums, index+1);
        //ab dono ka maxium paise kisme ayega decide karne ke liye hmm math.max ka use kar lenge is hmko malum chalega ki kisma jayada paise ayega
        int ans = Math.max(include, exclude);
        //then return the ans
        return ans;
    }

    static int rob(int []nums){
        int index = 0;
        int ans = solve(nums, index);
        return ans;
    }

    //main function
    public static void main(String[] args) {
        int [] nums = {1,3,5,5,4,1};
        int index = 0;
        System.out.println(solve(nums, index));
    }
}
