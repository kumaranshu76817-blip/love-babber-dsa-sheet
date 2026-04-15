import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class findSimilartiy_05 {
    public static ArrayList<Integer> findsimlarity (ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m){
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            set.add(arr1.get(i));
        }
        int intersection = 0;

        for(int i=0; i<m; i++){
             if(set.contains(arr2.get(i))){
                intersection++;
             }
             else{
                set.add(arr2.get(i));
             }
        }
        int union = set.size();

        ArrayList<Integer> result = new ArrayList<>();
        result.add(intersection);
        result.add(union);

        return  result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,7));

        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(5,6,7,2,8));

        ArrayList<Integer> ans = findsimlarity(arr1, arr2, arr1.size(), arr2.size());

        System.out.println("intersection count:" + ans.get(0));
        System.out.println("union count:"+ ans.get(1));
    }
}
