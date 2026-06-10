import java.util.Arrays;

public class aggresive_cows {
    static boolean isValidAns(int [] stalls , int k, int minDistance){
        //brute force
        int cowCount = 1;
        //first cows placed at 0 index
        int lastPosition = 0;

        for(int i=0; i<stalls.length; i++){
            //current cow ko current position par tabhi place karunga
            //jab current cow ka and previous cow ka distance 
            //>=minDistance hoga
            if(stalls[i] - stalls[lastPosition] >= minDistance){
                //can place safely
                cowCount++;
                //kyki new cow place ho chuki hai position k change karna
                //position ko update karna parega
                lastPosition = i;
                if(cowCount == k){
                    return true;
                }
            }
        }
        return false;
    }
    public static int agressiveCows(int [] stalls , int k){
        Arrays.sort(stalls);
        int n = stalls.length;
        int start = 0;
        int end = stalls[n-1] - stalls[0];
        int ans = -1;
        while (start<=end) {
            int mid = start + (end - start)/2;
            if(isValidAns(stalls, k, mid)){
                //hum possible ans mil gya 
                //ans ko store kar 
                //move to right;
                ans = mid;
                start  = mid +1;
            }
            else{
                //mid ke saath possible ans ho to aggressive 
                //cows
                //move to left;
                end = mid -1;
            }
        } return ans;
    }
    public static void main(String[] args) {
        int [] stalls = {1,2,8,4,9};
        int k = 3;
        System.out.println(agressiveCows(stalls, k));
    }
}
