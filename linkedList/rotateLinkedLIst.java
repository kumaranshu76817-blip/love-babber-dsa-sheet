public class rotateLinkedLIst {

    // Node class represents one node of the linked list
    class Node {

        Node next;   // Stores address of the next node
        int data;    // Stores data of the current node

        // Constructor to create a new node
        Node(int data) {
            this.next = null;  // Initially next is null
            this.data = data;  // Store given data
        }
    }

    // Head points to the first node
    private Node head;

    // Tail points to the last node
    private Node tail;

    // Stores size of linked list
    private int data;

    // Constructor of rotateLinkedLIst class
    public rotateLinkedLIst() {
        head = null;  // Initially list is empty
        tail = null;  // Initially tail is also null
        data = 0;     // Initially size is 0
    }

    // Method to insert a node at the end
    public void add(int value) {

        // Create a new node
        Node newNode = new Node(value);

        // If linked list is empty
        if (head == null) {
            head = newNode;  // New node becomes head
            tail = newNode;  // New node also becomes tail
            return;          // Stop the method
        }

        // Connect current tail to new node
        tail.next = newNode;

        // Make new node the new tail
        tail = newNode;
    }

    // Method to rotate linked list to the right by k positions
    public Node rotateNode(Node head, int k) {

        // If list is empty, has only one node, or k is 0
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // temp starts from head
        Node temp = head;

        // Start length from 1 because head is already one node
        int len = 1;

        // Find the last node and calculate length
        while (temp.next != null) {
            len++;              // Increase length
            temp = temp.next;   // Move temp to next node
        }

        // If k is bigger than length,
        // we only need the remainder
        k = k % len;

        // If k becomes 0, no rotation is required
        if (k == 0) {
            return head;
        }

        // Connect last node to first node
        // Now the linked list becomes circular
        temp.next = head;

        // Start again from head
        temp = head;

        // Move to the node just before the new head
        for (int i = 1; i <= len - k - 1; i++) {
            temp = temp.next;
        }

        // The next node will become the new head
        Node forward = temp.next;

        // Break the circular linked list
        temp.next = null;

        // Return the new head
        return forward;
    }

    // Method to print the linked list
    public void printList(Node head) {

        // Start from head
        Node temp = head;

        // Continue until temp becomes null
        while (temp != null) {

            // Print current node's data
            System.out.print(temp.data + " -> ");

            // Move to next node
            temp = temp.next;
        }

        // Print null at the end
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        // Create object of rotateLinkedLIst
        rotateLinkedLIst list = new rotateLinkedLIst();

        // Add elements to linked list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Print original linked list
        System.out.println("Original Linked List:");
        list.printList(list.head);

        // Number of positions to rotate
        int k = 2;

        // Rotate the linked list
        list.head = list.rotateNode(list.head, k);

        // Print rotated linked list
        System.out.println("After rotating by " + k + " positions:");
        list.printList(list.head);
    }
}