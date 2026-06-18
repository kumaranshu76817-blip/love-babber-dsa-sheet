public class reverse_word {
    public static String revrseWord(String s){
        StringBuilder ans = new StringBuilder();
        int i = s.length() -1;
        while (i>=0) {
            //remove all the traling spaces
            while (i>=0 && s.charAt(i) ==  ' ') {
                i--;
            }
            //check value of i
            if(i < 0){
                break;
            }
            int j = i;
            //find the start index of word
            while (j>=0 && s.charAt(j) != ' ') {
                j--;
            }
            //jaise hi space wala index par aya , to ruk jayenge
            // ab iss word ko appne ans me append kare
            ans.append(s.substring(j+1, i+1));
            //remove faltue ke spaec in where j standing add space in ans
            while (j>=0 && s.charAt(j) == ' ') {
                j--;
            }
            //j<0, iska matlb first word ke upar tha main -> no space need
            //j>=0 , space needed

            if (j>=0) {
                ans.append(' ');
            }
            //place i at index of the reamaing 
            i = j;
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "my name is anshu";
        System.out.println(revrseWord(s));
    }
}
