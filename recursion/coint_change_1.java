public class coint_change_1 {

    static int solve(int [] coin, int amount){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
        int mini = Integer.MAX_VALUE;

        for(int coins: coin){
            int recursionKaAns = solve(coin, amount-coins);
            if(recursionKaAns != Integer.MAX_VALUE){
                int totalCoinUsed = recursionKaAns +1;
                mini = Math.min(mini, totalCoinUsed);
            }
        }
        return mini;
    }

    public static int cointChanage(int [] coin, int amount){
        int ans = solve(coin, amount);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return ans;
        }
    }
    public static void main(String[] args) {
        int [] coin = {1,2,5};
        int amount = 11;
        System.out.println(solve(coin, amount) );
    }
}
