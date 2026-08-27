import java.util.ArrayList;
import java.util.List;

public class phone_number_02 {

    static void solve(String digit , int index, String[] mapping, List<String> result, StringBuilder  output){
        if(index >=digit.length()){
           result.add(output.toString());
            return;
        }

        int value = digit.charAt(index) - '0';
        String mappingString = mapping[value];

        for(int i=0; i<mappingString.length(); i++){
            output.append(mappingString.charAt(i));
            solve(digit, index+1, mapping, result, output);
            output.deleteCharAt(output.length()-1);
        }
    }
    
    public static List<String> letterCompination(String digit){
        List<String> result = new ArrayList<>();
        int index = 0;
        String [] mapping = {" ", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        StringBuilder output = new StringBuilder();
        solve(digit, index, mapping, result , output);
        return result;
    }

    public static void main(String[] args) {
        String digit = "2345678";
        List<String> result = letterCompination(digit);
        System.out.println(result);
    }
}
