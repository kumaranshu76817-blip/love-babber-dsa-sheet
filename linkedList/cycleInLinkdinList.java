public class cycleInLinkdinList {

    // ================ NODE CLASS =================

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // ================ CONSTRUCTOR =================

    cycleInLinkdinList() {
        head = null;
        tail = null;
        size = 0;
    }

    // ================ INSERT AT TAIL =================

    public void insertAtTail(int data) {

        Node newNode = new Node(data);

        // If linked list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        // Connect last node to new node
        tail.next = newNode;

        // Update tail
        tail = newNode;

        size++;
    }

    // ================ CREATE CYCLE =================

    public void createCycle() {

        if (head == null || tail == null) {
            return;
        }

        // Connect tail to head
        tail.next = head;

        System.out.println("Cycle created successfully!");
    }

    // ================ CHECK CYCLE =================

    public boolean chekCycleInLinkedList(Node head) {

        Node slow = head;
        Node fast = head;

        // Fast pointer moves two steps
        // Slow pointer moves one step
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // If both pointers meet
            // Cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches null
        // Cycle does not exist
        return false;
    }

    // ================ MAIN METHOD =================

    public static void main(String[] args) {

        // Create object of linked list
        cycleInLinkdinList list = new cycleInLinkdinList();

        // Insert nodes
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(50);

        // Create cycle
        list.createCycle();

        // Check cycle
        boolean result = list.chekCycleInLinkedList(list.head);

        if (result) {
            System.out.println("Cycle is present in Linked List");
        } else {
            System.out.println("Cycle is not present in Linked List");
        }
    }
}