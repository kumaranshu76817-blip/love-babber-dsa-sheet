
public class fibno {

    public static int fibnoccai(int n){
        if(n<=1){
            return n;
        }
        
        
        return fibnoccai(n-1) + fibnoccai(n-2);
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibnoccai(n));
    }   
}
