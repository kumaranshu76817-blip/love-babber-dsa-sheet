public class reverseLinkdeLIst {
    class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    reverseLinkdeLIst(){
        head = null;
        tail = null;
        size = 0;
    }

    public Node reverseNode(Node head){
        Node prev = null;
        Node curr = head;
        Node forward = head.next;


        while(prev != tail){
            curr.next = prev;
            curr = prev;
            curr = forward;
        }
        return prev;
    }


     // Display Linked List
    public void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        reverseLinkdeLIst list = new reverseLinkdeLIst();

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

        // Original list
        System.out.println("Original Linked List:");
        list.display(list.head);

        // Reverse
        list.head = list.reverseNode(list.head);

        // Update tail
        list.tail = first;

        // Reversed list
        System.out.println("Reversed Linked List:");
        list.display(list.head);
    }

    

}
