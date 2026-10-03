public class doublyFlattendLinkedList {

    // Node class
    public class Node {
        Node next;
        Node prev;
        Node child;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            this.child = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public doublyFlattendLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    // Flatten multilevel doubly linked list
    public Node flatten(Node head) {

        if (head == null) {
            return head;
        }

        Node p = head;

        while (p != null) {

            // If there is no child, move to next node
            if (p.child == null) {
                p = p.next;
            }

            // If child exists
            else {

                // Store child list
                Node temp = p.child;

                // Go to the end of child list
                while (temp.next != null) {
                    temp = temp.next;
                }

                // Connect child list's last node
                // with p's next node
                temp.next = p.next;

                if (p.next != null) {
                    p.next.prev = temp;
                }

                // Connect p with child list
                p.next = p.child;
                p.child.prev = p;

                // Remove child pointer
                p.child = null;
            }
        }

        // Update tail
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        tail = temp;

        return head;
    }

    // Print list
    public void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Print list in reverse using prev
    public void printReverse(Node tail) {

        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("NULL");
    }

    // Main method
    public static void main(String[] args) {

        doublyFlattendLinkedList list =
                new doublyFlattendLinkedList();

        /*
             Main List:

             1 <-> 2 <-> 3 <-> 4

                     |
                     7 <-> 8 <-> 9

                           |
                           10 <-> 11

             Expected flattened list:

             1 <-> 2 <-> 3 <-> 7 <-> 8 <-> 9
             <-> 10 <-> 11 <-> 4
        */

        // Main list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        // Save node references
        Node node1 = list.head;
        Node node2 = node1.next;
        Node node3 = node2.next;

        // Create child list of 3
        Node child1 = list.new Node(7);
        Node child2 = list.new Node(8);
        Node child3 = list.new Node(9);

        child1.next = child2;
        child2.prev = child1;

        child2.next = child3;
        child3.prev = child2;

        node3.child = child1;
        child1.prev = node3;

        // Create child list of 9
        Node child4 = list.new Node(10);
        Node child5 = list.new Node(11);

        child4.next = child5;
        child5.prev = child4;

        child3.child = child4;
        child4.prev = child3;

        // Print before flattening
        System.out.println("Before Flattening:");
        list.printList(list.head);

        // Flatten
        list.head = list.flatten(list.head);

        // Print after flattening
        System.out.println("\nAfter Flattening:");
        list.printList(list.head);

        // Print reverse
        System.out.println("\nReverse Order:");
        list.printReverse(list.tail);
    }
}