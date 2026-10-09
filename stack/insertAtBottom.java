import java.util.*;

public class insertAtBottom {

    public static void helper(Stack<Integer> st , int value){
        //base case
        if(st.empty()){
            st.push(value);
            return;
        }

        // 1 case hamm solve karenege baki recursinon slve kar leaga

        int topElement = st.peek();
        st.pop();

        helper(st, value);
        st.push(topElement);
    }


    public static Stack<Integer> insertBottom(Stack<Integer> st, int value){


        helper(st, value);

        return st;
    }
    public static void main(String [] args){
        Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        insertBottom(st,5);
        
        while(!st.empty()){
            System.out.print(st.peek()+" ");
            st.pop();
        }
    }
}
