public class valid_parnthesis_04 {
    public static boolean isValidPrameter(String s){

        char [] stack = new char[s.length()];
        int top = -1;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stack[++top] = ch;
            }

            else if(ch == ')' || ch == '}' || ch == ']'){

                if(top == -1){
                    return false;
                }

                char last = stack[top--];

                if(ch == ')' && ch == '('||
                ch == '}' && ch == '{' || 
                ch == ']' && ch == '[' ){
                    return false;
                }
            }
        }
        return top == -1;
    }

    public static void main(String[] args) {
        String str = "{()}";

        System.out.println(isValidPrameter(str) );

        
    }
}
