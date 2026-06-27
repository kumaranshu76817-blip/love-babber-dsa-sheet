public class maxiArray {
    static void maximumArray(int [] arr, int i, int maxi){
        //base case
        if(i >= arr.length){
            System.out.println("maxi value: " + maxi);
            return;
        }
        if(arr[i] > maxi){
            maxi = arr[i];
            
        }

        //recursive call
        maximumArray(arr, i+1, maxi);
        
    }


    //minimum value using recursion
    static void findMin(int [] arr, int i, int mini){
        //base case
        if(i >= arr.length){
            System.out.println("mini values:" + mini);
            return;
        }

        if(arr[i] < mini){
            mini = arr[i];
        }

        //recursive call
        findMin(arr, i+1, mini);
    }

    //find target using reacursion
    static int findTarget(int [] arr, int i, int target){
        //base case
        if(i >= arr.length){
            return -1;
        }

        //processing
        if(arr[i] == target){
            return arr[i];
        }

        //rc
        int ans = findTarget(arr, i+1, target);

        return ans;
    }


    //count target useing recursion

    static void countTarget(int [] arr, int i, int target, int count){
    
        if( i>= arr.length){
            System.out.println(count);
            return ;
        }

        if(arr[i] == target){
            count++;
        }

        countTarget(arr, i+1, target,count);
    }

    //print digit usei recursion

    static void printDigit(int n){
        if(n == 0){
            return ;
        }

        int digit = n%10;
        n = n/10;

        printDigit(n);
        System.out.println(digit);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};


        //maxi value of arr
        int i = 0;
        int maxi = Integer.MIN_VALUE;
        maximumArray(arr, i, maxi);


        //mini value of arr
        int mini = Integer.MAX_VALUE;
        findMin(arr, 0, mini);


        //fount target
        int target = 3;
        System.out.println(findTarget(arr, i, target));

        int [] arr2 = {10,10,10,10,20,30,40,50};
        int target2 = 10;
        
        countTarget(arr2, 0, target2,0);


        //print digit
        printDigit(999);
    }
}
