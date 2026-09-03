
public class merge_sort {

    static void merge(int [] arr, int s, int e , int mid){
        
        //right and left arr length
        int leftArrLen = mid - s +1;
        int rightArrLen = e - mid;

        //empty array define
        int [] leftArr = new int[leftArrLen];
        int [] rightArr = new int[rightArrLen];

        //copy left array to new array and then merge 
        int k = s;
        for(int i = 0; i<leftArrLen; i++){
            leftArr[i] = arr[k];
            k++;
        }

        //copy right array to new array k

        for(int j=0; j<rightArrLen; j++){
            rightArr[j] = arr[k];
            k++;
        }

        // exact logic for merge
        int i=0; 
        int j=0;
        k = s;
        while (i<leftArrLen && j<rightArrLen) {
            if(leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;
                k++;
            }
            else{
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }

        //when the left array is full consumed and right array is not
        //then copy the element of right array into the ans aray
        while (j<rightArrLen) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        //when the right array is full consumed and left is not
        //then copyt the element of left array into the ans
        while (i<leftArrLen) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

    }
    
    public static  void mergeSort(int [] arr, int s, int e){
        if(s >= e){
            //invalid array 
            return;
        }

        //break in two halves
        int mid = (s+e)/2;

        //lets sort the left array
        mergeSort(arr, s, mid);

        //lets sort the right array
        mergeSort(arr, mid+1, e);

        //merge both halves
        merge(arr, s, e, mid);

        
    }

    public static void main(String[] args) {
        int [] arr = {8,4,2,6,3,1,7,9};
        int start = 0;
        int end = arr.length-1;

        System.out.println("before sorting array:");
        for(int num: arr){
            System.out.print(num+" ");
        }
        
        mergeSort(arr, start, end);

        System.out.println("\nafter sorting array");
        for(int num: arr){
            System.out.print(num+" ");
        }
    }
}
