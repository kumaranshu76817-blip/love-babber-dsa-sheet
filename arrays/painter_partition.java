public class painter_partition {
    public static boolean isValidAns(int [] boards , int k, int MaxLength){
        int painter = 1;
        int paintUnit = 0;
        for(int i=0; i< boards.length; i++){
            if(paintUnit + boards[i] <= MaxLength){
                //agar mera boads and unit of paint ho gya ek admi ke liye to sahi hai
                //to assign kar do
                //then
                paintUnit += boards[i];
            }
            else{
                //one person ko unit assign ho gya to next person ke liye pianter plus kar do
                //
                painter++;
                paintUnit = 0;
                if(painter>k || boards[i] > MaxLength){
                    return false;
                }
                else{
                    paintUnit += boards[i];
                }
            }
        }
        return true;
    }
    public static int minTime(int[] boards, int k){
        int sum = 0;
        for(int i=0; i<boards.length; i++){
            sum += boards[i];
        }
        int start = 0;
        int end = sum;
        int ans = -1;
        while (start<=end) {
            int mid = start + (end - start)/2;
            if(isValidAns(boards, k, mid)){
                ans = mid;
                end = mid -1;

            }
            else{
                //if ans nahi mila to
                start = mid +1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] boards = {5,10,30,15,20};
        int k = 3;
        System.out.println(minTime(boards, k));
    }
}
