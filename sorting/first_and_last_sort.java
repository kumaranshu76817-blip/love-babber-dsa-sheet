import java.util.ArrayList;
import java.util.Arrays;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

public class first_and_last_sort {
    ArrayList<Integer> find(int [] arr, int x){

        ArrayList<Integer> result = new ArrayList<>();

        int first = -1;
        int last = -1;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == x){
                if(first == -1){
                    first = i;
                }
                last = i;
            }
        }
        result.add(first);
        result.add(last);

        return result;
    }

    public static void main(String[] args) {
        
        int [] arr = {1,2,2,3,4,5,5};

        int x = 3;

        first_and_last_sort obj = new first_and_last_sort();

        ArrayList<Integer> result = obj.find(arr, x);

        System.out.println(result);
    }
}
