public class remove_all_adjacent {
    public static String removeElement(String s){
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char currenChar = s.charAt(i);


            if(ans.length() > 0 && ans.charAt(ans.length() - 1) == currenChar){
                ans.deleteCharAt(ans.length() - 1);
            }
            else{
                //if these are 2 different
                ans.append(currenChar);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeElement(s));
    }
    
}
