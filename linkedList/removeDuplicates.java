public class removeDuplicates {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Insert at end
    public void insert(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Remove duplicates
    public void removesDuplicates() {

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;

        while (curr != null) {

            if (curr.next != null &&
                curr.data == curr.next.data) {

                int value = curr.data;

                while (curr != null &&
                       curr.data == value) {

                    curr = curr.next;
                }

                prev.next = curr;

            } else {

                prev = curr;
                curr = curr.next;
            }
        }

        head = dummy.next;
    }

    // Display
    public void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        removeDuplicates list = new removeDuplicates();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(3);
        list.insert(4);
        list.insert(4);
        list.insert(5);

        System.out.println("Before:");
        list.display();

        list.removesDuplicates();

        System.out.println("After:");
        list.display();
    }
}