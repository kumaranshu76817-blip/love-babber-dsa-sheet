// square root using binary search

public class squareRoot {
    
    public static double sqrt(int n){
        int start = 0;
        int end = n;
        double ans = -1;
        while(start<=end){
            int mid = start + (end -start)/2;
            //agar mid * mid overflow ho gya to newly method to solve kare
            if ((mid * mid == n) ) {//second method of if( mid == n/mid);
                return mid;
            }
            else if(mid * mid > n){ //  mid == n/mid;
                
                //move to left
                end = mid -1;
            }
            else{
                //mid * mid <n;
                //potential answer to store kar lo
                ans = mid;
                start = mid +1;
            }
        }
        double factor = 1;
        int toatalround = 3;
        for(int round = 0; round <=toatalround; round++){
            factor = factor/10;
            for(int i = 1; i<=10; i++){
                double newAns = ans + factor;
                if(newAns * newAns == n){
                    return newAns;
                }
                else if(newAns * newAns < n){
                    ans = newAns;
                }
                else{
                    //newAns * newAns >n;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n =56;
        System.out.println(sqrt(n));
    }     
}
