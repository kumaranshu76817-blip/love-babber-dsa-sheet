

import java.util.Scanner;

public class makebeautiful_01 {
    
    public static int makeBeautiful(String str){
        int n = str.length();

        int count1 = 0;
        int count2 =0;

        for(int i=0; i<n; i++){
            char ch = str.charAt(i);


            if(n%2 == 0){
                if(ch != '0'){
                    count1++;
                }
                else{
                    if(ch != '1'){
                        count1++;
                    }
                }
            }

            if(n%2 == 0){
                if(ch != '0'){
                    count2++;
                }
                else{
                    if(ch != '1'){
                        count2++;
                    }
                }
            }
        }

        return Math.min(count1, count2);
    }

    public static void main(String[] args) {
        String str = "01011";
        System.out.println(makeBeautiful(str));
    }
}
