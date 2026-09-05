public class Quick_sort_03 {
    static void quickSort(int [] arr, int s, int e){
        //base case
        if(s >= e){
            return;
        }
        //ek case hmm solve karenge , baaki recursion saambal lega
        int pivotIndex = partition(arr, s, e);

        //left array ke liye solve karenge
        quickSort(arr, s, pivotIndex-1);

        //right array ke liye solve karenge
        quickSort(arr, pivotIndex+1, e);
    }
    private  static  int partition(int [] arr, int s, int e){

        int pivotElement= arr[s];
        int count = 0;

        for(int i= s+1; i<e; i++){
            if(arr[i]<pivotElement){
                count++;
            }
        }

        //pivot index count ho gya kaha pe hai 
        //ab usko sahi position pe place kar dung using swap
        int correctPosition = s+ count;
        int temp = arr[correctPosition];
        arr[correctPosition] = arr[s];
        arr[s] = temp;


        //ab bas left aur right walo ko apne position pe swap karna hoga
        int i = s;
        int j = s;
        while(i<correctPosition && j>correctPosition){
            
            //left ke liy hai
            while (i<=pivotElement ) {
                i++;
            }

            //right ke liye
            while (j>pivotElement) {
                j--;
            }

            //ab sorting karana hai left element ko right element ko swap karke
            if(i<correctPosition && j>correctPosition){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return correctPosition;
    }


    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Before Quick Sort:");

        for (int x : arr) {
            System.out.print(x + " ");
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\n\nAfter Quick Sort:");

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
