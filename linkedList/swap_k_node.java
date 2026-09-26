public class swap_k_node {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;   // FIX: int, not Node

    public swap_k_node() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add node at end
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // Swap kth node from beginning and kth node from end
    public Node swap(Node head, int k) {

        // Empty list
        if (head == null) {
            return head;
        }

        // Invalid k
        if (k <= 0 || k > size) {
            System.out.println("Invalid k");
            return head;
        }

        // Find kth node from beginning
        Node first = head;

        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Find kth node from end
        Node second = head;
        Node temp = first;

        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        // Swap data
        int swap = first.data;
        first.data = second.data;
        second.data = swap;

        return head;
    }

    // Print linked list
    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        swap_k_node list = new swap_k_node();

        // Create:
        // 10 -> 20 -> 30 -> 40 -> 50
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        System.out.println("Before swap:");
        list.printList();

        int k = 2;

        list.head = list.swap(list.head, k);

        System.out.println("After swapping kth nodes:");
        list.printList();
    }
}