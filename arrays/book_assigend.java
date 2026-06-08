public class book_assigend {
    public static boolean isValidAns(int [] arr, int k, int maxPages){
        int studenCount = 1;
        int pages = 0;
        for(int i=0; i<arr.length; i++){
            if(pages + arr[i] <= maxPages){
                //iska matlb current book assigned
                //as it not out in limit 
                //the assigned it

                pages = pages + arr[i];
            }
            else{
                //current student ko current wala case
                //agar ek student ko pura pages ho gya ko next student ko dena wala case 
                studenCount++;
                if(studenCount > k || arr[i] > maxPages){
                    return false;
                }
                else{
                    pages = 0;
                    pages = pages + arr[i];
                }
            }

        }
        return true;
    }
    public static int findPages(int [] arr, int k){
        // agar pages kam hai aur student jada hai to ye wala case hoga arr.length < student count
        if(arr.length < k){
            return -1;
        }
        int start = 0;
        int n = arr.length;
        int sum = 0;
        int ans = -1;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        int end = sum;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(isValidAns(arr,k,mid)){
                //if ture case
                ans = mid;
                end = mid -1;
            }
            else{
                //false case
                
                start = mid +1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {10,20,30,40,50};
        int k =2;
        System.out.println(findPages(arr, k));
    }
}
