import java.util.*;

public class reverseStack {

    public static void insertAtBottom(Stack<Integer> st, int value){
        if(st.empty()){
            st.push(value);
            return;
        }

        int topValue = st.peek();
        st.pop();

        insertAtBottom(st,value);
        st.push(topValue);


    }

    public static void reverse(Stack<Integer> st){

        //base case

        
        if(st.empty()){
            return;
        }

        // 1 case hamm solve karenege baki recursinon slve kar leaga

        
        st.pop();
        int value = st.peek();

        insertAtBottom(st,value);
        
    }

    public static void main(String [] args){
        Stack<Integer> st = new Stack<>();


        


        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);


        System.out.println("before reversing.....");
        while(!st.empty()){
            System.out.println(st.peek()+ " ");
            st.pop();
        }

        reverse(st);


        System.out.println("after revsing....");
        while(!st.empty()){
            System.out.println(st.peek()+ " ");
            st.pop();
        }
    }
}
