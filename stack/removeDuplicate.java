
import java.util.ArrayDeque;
import java.util.Deque;

public class removeDuplicate {
    public void remove(String s){
        Deque<Character> st = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(ch== 'a' || ch == 'b' || ch == 'c'){
                st.push(ch);
            }
            else{
                int topValue = st.peek();
                if(topValue == 'c' && topValue == 'c'){
                    st.pop();
                }
                else if(topValue == 'b' && topValue == 'b'){
                    st.pop();
                }
                else if(topValue == 'a' && topValue == 'a'){
                    st.pop();
                }
                
            }
        }
    }
}
