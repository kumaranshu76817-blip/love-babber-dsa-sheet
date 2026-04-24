
//slection sort 
// in letter push to first array index this is called selection sort

public class slection_sort {
    
    public static void selctionSort(int [] arr){
        for(int i=0; i<arr.length-1; i++){
            int minvalue = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[minvalue] > arr[j]){
                    minvalue = j;
                }
            }
            int temp = arr[minvalue];
            arr[minvalue] = arr[i];
            arr[i] = temp;
        }
    }
    public static void printarr(int [] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int [] arr = {6,4,3,2,1};
        selctionSort(arr);
        printarr(arr);
    }
}
