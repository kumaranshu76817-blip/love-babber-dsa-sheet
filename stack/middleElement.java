
import java.util.Stack;

public class middleElement {

    public static void getMiddleElement(Stack<Integer> st, int size, int count){
        if(count == size/2){
            int getElement = st.peek();
            System.out.println("middle element is:" + getElement);
            return;

        }
        st.pop();
        count++;
        getMiddleElement(st, size, count);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);

        int count = 0;

        int size = st.size();

        getMiddleElement(st,size, count);
    }
}
