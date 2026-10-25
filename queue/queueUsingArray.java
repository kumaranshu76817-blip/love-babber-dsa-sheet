

public class queueUsingArray {

    static class Queue{
        int size;
        int arr [];
        int rear = -1;

        public Queue(int size) {
            this.size = size;
            arr = new int[size];
        }

        public boolean isEmpty(){
            return rear == -1;
        }


        //enqueue
        public  void add(int data){
            if(rear == size-1){
                System.out.println("queue is full cannot be add");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        //deque
        public int delete(){
            if(isEmpty()){
                System.out.println("cannot be delete ");
                return -1;
            }
            int front = arr[0];
            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }

            rear--;
            return front;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("cannot be print");
                return -1;
            }
            return arr[0];
        }
        
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println(q.peek());   // 10
        System.out.println(q.delete()); // 10
        System.out.println(q.peek());   // 20
    }
    
    
}
