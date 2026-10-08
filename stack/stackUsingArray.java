public class stackUsingArray {
    static class Mystack{
        private int [] arr;
        private int capacity;
        private int top;

        public Mystack(int capacity){
            this.capacity = capacity;
            arr = new int[capacity];
            top = -1;
        }

        public void push(int value){
            if(top == capacity -1 ){
                System.out.println("stack is overflow");
                return;
            }
            else{
                top++;
                arr[top] = value;
            }
        }

        public void pop(){
            if(top == -1){
                System.out.println("stack is underflow");
                return;
            }
            else{
                top--;
            }
        }

        public int peek(){
            if(top == -1){
                System.out.println("stack is underflow");
                return -1;
            }

            return arr[top];
        }

        public int getSize(){
            return top +1;
        }

        public boolean isEmpty(){
            if(top == -1){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Mystack st = new Mystack(5);
        st.push(10);
        st.push(30);
        st.push(20);
        System.out.println(st.peek());


        //travseral the stack
        while(st.isEmpty()){
            System.out.println("st.peek()" + ", ");
            st.pop();
        }
    }
}
