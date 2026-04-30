
import java.util.*;


public class dupllicate_06 {
    // brute force
    public static int findDuplicat(int [] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static int findDuplicat2(ArrayList<Integer> arr){
        HashSet<Integer> set = new HashSet<>();
        for(int num: arr){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    //sorting
    public static int findDuplicat3(ArrayList<Integer> arr){
        Collections.sort(arr);
        for(int i=1; i<arr.size(); i++){
            if(arr.get(i).equals(arr.get(i-1))){
                return arr.get(i);
            }
        }
        return -1;
    }

    public static void printArr(ArrayList<Integer> arr){
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i)+ " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,3,4,4,6,5));
            int ans = findDuplicat2(arr);
            System.out.println("duplicate "+ ans);
            printArr(arr);

        
            int [] a = {1,2,2,3,3,4,5};
            System.out.println("duplicate" + findDuplicat(a));
    }
    
}
