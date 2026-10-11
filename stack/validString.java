
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class validString {

    public static boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (ch == 'a' || ch == 'b') {
                st.push(ch);
            } else {
                if (st.size() < 2) {
                    return false;
                }

                if (st.peek() != 'b') {
                    return false;
                }
                st.pop();

                if (st.peek() != 'a') {
                    return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        if (isValid(s)) {
            System.out.println("Valid String");
        } else {
            System.out.println("Invalid String");
        }

        sc.close();
    }
}
