import java.util.HashMap;

public class get_order {
    public static void getMode(int [] arr){
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int n: arr){
            freq.put(n, freq.getOrDefault(n, 0)+1);

        }

        for(int i: freq.keySet()){
            System.out.println(i + " -> " + freq.get(i));
        }
    }
    public static void main(String[] args) {
        int [] arr = {1,1,2,2,3,3,3,4,4,4};
        getMode(arr);
    }
}
