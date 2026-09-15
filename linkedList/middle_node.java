public class middle_node {
    public class Node {
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

    middle_node() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return slow;
    }

    public static void main(String[] args) {

        // Create linked list object
        middle_node list = new middle_node();

        // Create nodes
        Node first = list.new Node(10);
        Node second = list.new Node(20);
        Node third = list.new Node(30);
        Node fourth = list.new Node(40);
        Node fifth = list.new Node(50);

        // Connect nodes
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Set head and tail
        list.head = first;
        list.tail = fifth;
        list.size = 5;

        // Find middle node
        Node middle = list.middleNode(list.head);

        // Print middle node
        System.out.println("Middle Node: " + middle.data);
    }
}
