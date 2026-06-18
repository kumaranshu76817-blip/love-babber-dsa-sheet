public class prematation_string {
    public static boolean comarefreq(int [] count1, int [] count2){
        for(int i=0; i<26; i++){
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean premutation(String s1, String s2){


        //algo wise 
        //basic check -> s1 character prsent in s2 or not
        //s1 ka table ready kar lete hai
        //s2 ks first widow ka process kar lete hai
        //s2 ka remaninng ka process kar lete hai



        if(s1.length() > s2.length()){
            return false;
        }

        //s1 ka freq table
        int count1 [] = new int[26];
        for(int i=0; i<s1.length(); i++){
            char currChar = s1.charAt(i);
            count1[currChar- 'a']++;

        }   

        //s2 ka freq table
        int i=0; 
        int windowLength = s1.length();
        int [] count2 = new int[26];
        for(i=0; i<windowLength; i++){
            char currChar = s2.charAt(i);
            count2[currChar - 'a']++;
        }

        if(comarefreq(count1, count2) == true){
            return true;
        }
        else{
            //both the freq table are not matches
            //process reamaning widows
            while (i<s2.length()) {

                // new widow pr move karte ho  to new character ka freq table add kar do
                char newChar = s2.charAt(i);
                int newCharIndex = newChar - 'a';
                count2[newCharIndex]++;

                //old character ko entry table se reamove kar 
                int oldCharRemo = i - windowLength;
                int oldChar = s2.charAt(oldCharRemo);
                int oldCharIndex = oldChar - 'a';
                count2[oldCharIndex]--;


                if(comarefreq(count1, count2) == true)
                    return true;
                i++;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "pqrabce";
        System.out.println(premutation(s1, s2));
    }
}
