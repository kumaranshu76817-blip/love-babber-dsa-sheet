
public class circularQueue {

    static class Queue {
        int arr[];
        int front = -1;
        int rear = -1;
        int size;

        public Queue(int size) {
            this.size = size;
            arr = new int[size];
        }

        // Check whether queue is empty
        public boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        // Check whether queue is full
        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add element
        public void add(int data) {
            if (isFull()) {
                System.out.println("Cannot add, queue is full");
                return;
            }

            // First element
            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Remove element
        public int remove() {
            if (isEmpty()) {
                System.out.println("Cannot remove, queue is empty");
                return -1;
            }

            int result = arr[front];

            // Only one element
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        // Get front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println("Front element: " + q.peek());
        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());

        q.add(6);
        q.add(7);

        System.out.println("Front element: " + q.peek());
    }
}
