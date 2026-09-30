public class partition_list {
    public class Node{
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

    public partition_list() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node partition(Node head, int x){
        Node lesserHead = new Node(-1);
        Node lesserTail = lesserHead;

        Node greaterHead = new Node(-1);
        Node greaterTail = greaterHead;

        Node temp = head;

        while(temp != null){
            if(temp.data < x){
                Node nodeToInsert = temp;
                temp = temp.next;
                nodeToInsert.next = null;
                lesserTail.next = nodeToInsert;
                lesserTail = nodeToInsert;
            }
            else{
                Node nodeToInsert = temp;
                temp = temp.next;
                nodeToInsert.next = null;
                greaterTail.next = nodeToInsert;
                greaterTail = nodeToInsert;
            }
        }
        lesserTail.next = greaterHead.next;
        greaterTail.next = null;
        lesserHead = lesserHead.next;

        return lesserHead;
    }
    // Display linked list
    public void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Main method
    public static void main(String[] args) {

        // Create object of partition_list
        partition_list list = new partition_list();

        // Create nodes
        Node head = list.new Node(1);
        head.next = list.new Node(4);
        head.next.next = list.new Node(3);
        head.next.next.next = list.new Node(2);
        head.next.next.next.next = list.new Node(5);
        head.next.next.next.next.next = list.new Node(2);

        // Value around which we want to partition
        int x = 3;

        // Print original list
        System.out.println("Original List:");
        list.display(head);

        // Partition the list
        head = list.partition(head, x);

        // Print partitioned list
        System.out.println("After Partition:");
        list.display(head);
    }

    
}
