
import java.util.Scanner;

public class chek_pallidrome_02 {
    public static boolean isPallidrom(String str) {
        str = str.toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPallidrome2(String str){
        for(int i=0; i<str.length()/2; i++){
            int n = str.length();
            if(str.charAt(i) != str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str ="madam";

        System.out.println(isPallidrom(str));
        System.out.println(isPallidrome2(str));
    }
}
