public class coin_chang {
    static int solve(int amount, int [] coin, int index){
        if(amount == 0){
            return 1;
        }
        if(amount<0){
            return 1;
        }
        if(index >= coin.length){
            return 0;
        }
        //ek case solve kar lu
        //baki recursion sambhal lega
        int include = solve(amount-coin[index], coin, index);
        int exclude = solve(amount, coin, index+1);
        int ans = include + exclude;
        return ans;
    }
    public static int coinChange(int amount, int [] coin){
        int index = 0;
        int ans = solve(amount, coin, index);
        return ans;
    }
    public static void main(String[] args) {
        int amount = 5;
        int [] coin = {1,2,5};
        System.out.println(coinChange(amount, coin));
    }
}
