
public class queueUsingLInkedLIst {

    // Node class
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue class
    static class Queue {
        static Node head = null;
        static Node tail = null;

        // Check whether queue is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Add element
        public void add(int data) {
            Node newNode = new Node(data);

            if (tail == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        // Remove element
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove");
                return -1;
            }

            int front = head.data;
            head = head.next;

            // If queue becomes empty
            if (head == null) {
                tail = null;
            }

            return front;
        }

        // Get front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Front element: " + q.peek());
        System.out.println("Removed: " + q.remove());
        System.out.println("Front element: " + q.peek());
        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());

        System.out.println("Is queue empty? " + q.isEmpty());
    }
}
