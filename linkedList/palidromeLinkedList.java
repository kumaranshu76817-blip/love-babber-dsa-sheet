public class palidromeLinkedList {

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

    palidromeLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Insert node at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // Find middle node
    public Node midOfLinkedList(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Reverse linked list
    public Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node forward = curr.next;

            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;
    }

    // Check palindrome
    public boolean isPaldirome(Node head) {

        // Empty or single-node list
        if (head == null || head.next == null) {
            return true;
        }

        // Find middle
        Node middle = midOfLinkedList(head);

        // Reverse second half
        Node head2 = reverseLinkedList(middle);

        // Compare first half and second half
        Node temp1 = head;
        Node temp2 = head2;

        while (temp2 != null) {

            if (temp1.data != temp2.data) {
                return false;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    // Display linked list
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Main method
    public static void main(String[] args) {

        palidromeLinkedList list = new palidromeLinkedList();

        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(2);
        list.insertAtTail(1);

        System.out.println("Linked List:");
        list.display();

        boolean result = list.isPaldirome(list.head);

        if (result) {
            System.out.println("Linked List is Palindrome");
        } else {
            System.out.println("Linked List is NOT Palindrome");
        }
    }
}