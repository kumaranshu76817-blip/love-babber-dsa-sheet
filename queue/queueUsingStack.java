import java.util.Stack;

public class queueUsingStack {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    

    static class Queue{
        public  boolean isEmpty(){
            return s1.isEmpty();

        }

        public void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("cannot be print");
                return -1;
            }

            return s1.pop();
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("cannot be print");
                return -1;
            }

            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
