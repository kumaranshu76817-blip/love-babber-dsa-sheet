
public class plusOneLinkedlist {

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public plusOneLinkedlist() {
        head = null;
        tail = null;
        size = 0;
    }

    // Insert node at end
    public void insert(int data) {
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

    // Reverse Linked List
    public Node reverseLinkedList(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node forw = curr.next;

            curr.next = prev;

            prev = curr;
            curr = forw;
        }

        return prev;
    }

    // Add 1 to Linked List
    public Node plusOne(Node head) {

        // Step 1: Reverse the linked list
        head = reverseLinkedList(head);

        // Step 2: Add 1
        Node curr = head;

        int carry = 1;

        while (curr != null) {

            int sum = curr.data + carry;

            int digit = sum % 10;

            // Update current node
            curr.data = digit;

            // Calculate carry
            carry = sum / 10;

            // If no carry, we are done
            if (carry == 0) {
                break;
            }

            // If last node and carry is still present
            if (curr.next == null && carry > 0) {

                curr.next = new Node(carry);
                carry = 0;
                break;
            }

            curr = curr.next;
        }

        // Step 3: Reverse again
        head = reverseLinkedList(head);

        return head;
    }

    // Display Linked List
    public void display(Node head) {

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data);

            if (curr.next != null) {
                System.out.print(" -> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        plusOneLinkedlist list = new plusOneLinkedlist();

        // Example: 1 -> 2 -> 3
        list.insert(1);
        list.insert(2);
        list.insert(3);

        System.out.println("Before plus one:");
        list.display(list.head);

        list.head = list.plusOne(list.head);

        System.out.println("After plus one:");
        list.display(list.head);
    }
}
