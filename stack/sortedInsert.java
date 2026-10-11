
import java.util.*;

public class sortedInsert {

    public static void insertValue(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int topValue = st.peek();

        if (topValue < x) {
            st.pop();

            insertValue(st, x);

            st.push(topValue);
        } else {
            st.push(x);
            return;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        // Stack elements (bottom to top)
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(50);

        System.out.println("Original Stack: " + st);

        int x = 40;
        insertValue(st, x);

        System.out.println("After Insertion: " + st);
    }
}
