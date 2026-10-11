import java.util.ArrayDeque;
import java.util.Deque;

public class validParnthesis {

    public static boolean validString(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            // Step 1: Push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {

                // Step 2: If stack is empty, brackets are invalid
                if (st.isEmpty()) {
                    return false;
                }

                // Step 3: Check matching closing brackets
                if (ch == ')' && st.peek() != '(') {
                    return false;
                } else if (ch == ']' && st.peek() != '[') {
                    return false;
                } else if (ch == '}' && st.peek() != '{') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        // Step 4: Stack must be empty at the end
        return st.isEmpty();
    }

    public static void main(String[] args) {

        String s1 = "{[()]}";
        String s2 = "{[(])}";
        String s3 = "(((";

        System.out.println(s1 + " -> " + validString(s1));
        System.out.println(s2 + " -> " + validString(s2));
        System.out.println(s3 + " -> " + validString(s3));
    }
}