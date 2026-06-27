public class basic {
    static void print1ton(int n, int count){
        //base case
        if(count> n){
            return;
        }

        //proccessing
        System.out.println(count);
        //count++;
        print1ton(n, count+1);
    }

    static void printNto1(int n){
        //base case
        if(n == 0){
            return;
        }
        //processing
        System.out.println(n);

        //recursive part
        printNto1(n-1);
    }

    //another method print to 1 to n
    static void print1ToN(int n, int count){
        //base case
        if(count>n){
            return;
        }

        //recursive call
        print1ToN(n, count+1);

        //processing
        System.out.println(count);
    }

    //print array to using recursion
    static void printArray(int [] arr,int i){
        if(i>= arr.length){
            return;
        }
        //processing
        System.out.println(arr[i]);

        //recursive call
        printArray(arr, i+1);
    }

    public static void main(String[] args) {
        //call the function
        // print1ton(5, 1);



        // printNto1(5);

        // print1ToN(5, 0);

        int [] arr = {1,2,3,4,5};
        printArray(arr, 0);
    }
}
