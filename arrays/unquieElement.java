public class unquieElement {
    public  static int unique(int [] arr){
        int xorSum = 0;
        for(int n: arr){
            xorSum ^= n;
        }
        return xorSum;
    }

    public static void main(String[] args) {
    int [] arr = {1,1,2,2,4,4,5};

    System.out.println(unique(arr));
    }
}
