public class peakindexArray {
    public static int peakIndexArray(int [] arr){
        int n = arr.length;
        int s = 0;
        int e = n -1;
        int ans = -1;
        while(s<= e){
            int mid = s + (e - s)/2;
            if(arr[mid] < arr[mid+1]){
                // to main asscending order me hu
                // mai left part me hu
                // to muje right part me move karna parega
                s = mid + 1;

            }
            else{
                //arr[mid] >= arr[mid+1];
                // to main right part me hu
                //to muje ans to store karna parega
                ans = mid;
                //now i havae to find final answer
                //mujr pata right part asscending order me hai
                // to bada number exist karta hai , to pakka left me hoga
                //left me move karo
                e = mid -1;

            }
            
        }
        return ans;
    }

    public static int peakIndexArray2(int[] arr){
        int i = 0;
        while(arr[i] < arr[i+1]){
            i++;
        }
        return i;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,5,3,2,1};
        System.out.println(peakIndexArray2(arr));
    }
}
