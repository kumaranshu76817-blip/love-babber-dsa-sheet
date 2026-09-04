public class iversion_count_01 {
    static int merge(int [] arr, int s , int e , int mid){
        int leftArrLen = mid - s +1;
        int rightArrLen = e- mid;

        int [] leftArr = new int[leftArrLen];
        int [] rightArr = new int[rightArrLen];

        // temporary array me copy karne ke liye logic
        int k = s;
        for(int i=0; i<leftArrLen; i++){
            leftArr[i] = arr[k];
            k++;
        }

        //same for right array compy from temp array
        for(int j=0; j<rightArrLen; j++){
            rightArr[j] = arr[k];
            k++;
        }


        int i =0; 
        int j = 0;
        k = s;
        int invCount = 0;
        //merge karne ka logic 
        while (i<leftArrLen && j<rightArrLen) {
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++; 
                k++;
            }
            else{
                arr[k] = rightArr[j];
                j++;
                k++;

                invCount = invCount + (leftArrLen-i);

            }
            
        }


        //when the right array is fully consumed and left is not, then
        while (i<leftArrLen) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // when the left array is full consumed and right is not, then
        while (j<rightArrLen) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        return invCount;
    }
    static int mergeSort(int[] arr, int s, int e){
        if(s> e){
            return 0;
        }
        if(s == e){
            return 0;
        }
        int mid = s + (e-s)/2;

        //left side ke sorting ke liye
        int leftInversion = mergeSort(arr, s, mid);

        //right side ke sorting ke liye
        int rightInversion = mergeSort(arr, mid+1, e);

        int intermidateInversion = merge(arr, s, e, mid);

        //inversion count ke liye
        int invCount = leftInversion + rightInversion + intermidateInversion;

        return invCount;
    }
    public static  int inversionCount(int [] arr){
        int s=0;
        int e = arr.length-1;
        

        int ans = mergeSort(arr, s, e);
        return ans;
    }

    public static void main(String[] args) {
        // int [] arr = {8,3,5,4,7,6,1,2};
        int[] arr = {2, 4, 1, 3, 5};

        System.out.println("Inversion Count: " + inversionCount(arr));

        System.out.println("Sorted Array:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
