// import java.util.*;;

public class max_frequency {
    public static char maxFrequency(String s){
        int [] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);
            freq[currChar - 'a']++;
        }
        int maxFreq = -1;
        char ans = 'a';

        for(int i=0; i<26; i++){
            if(freq[i] > maxFreq ){
                maxFreq = freq[i];
                ans = (char)(i + 'a');
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "aabbccc";
        System.out.println(maxFrequency(s));
    }
}
