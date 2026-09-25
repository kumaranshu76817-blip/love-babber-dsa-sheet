
public class sort_0_1and_2 {

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

    public sort_0_1and_2() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add node at the end
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

    // Sort 0, 1 and 2
    public void sort01and2() {

        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;

        Node oneHead = new Node(-1);
        Node oneTail = oneHead;

        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        Node temp = head;

        // Separate 0, 1 and 2
        while (temp != null) {

            Node nodeToInsert = temp;
            temp = temp.next;

            // Remove old connection
            nodeToInsert.next = null;

            if (nodeToInsert.data == 0) {

                zeroTail.next = nodeToInsert;
                zeroTail = nodeToInsert;

            } else if (nodeToInsert.data == 1) {

                oneTail.next = nodeToInsert;
                oneTail = nodeToInsert;

            } else if (nodeToInsert.data == 2) {

                twoTail.next = nodeToInsert;
                twoTail = nodeToInsert;
            }
        }

        // Connect 0 list -> 1 list -> 2 list
        zeroTail.next = (oneHead.next != null)
                ? oneHead.next
                : twoHead.next;

        oneTail.next = twoHead.next;

        // Update head
        head = zeroHead.next;

        // Update tail
        if (twoHead.next != null) {
            tail = twoTail;
        } else if (oneHead.next != null) {
            tail = oneTail;
        } else {
            tail = zeroTail;
        }
    }

    // Display linked list
    public void printList() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        sort_0_1and_2 list = new sort_0_1and_2();

        // Add elements
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);

        System.out.println("Before sorting:");
        list.printList();

        // Sort 0, 1 and 2
        list.sort01and2();

        System.out.println("After sorting:");
        list.printList();
    }
}

