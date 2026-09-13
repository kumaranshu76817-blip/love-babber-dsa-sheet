public class circularDoubleLinkedList {
    public class Node{
        Node next;
        Node prev;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public circularDoubleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    //=======================================
    //           inserting
    //=======================================

    public void insertAtHead(int data){
        Node newNode = new Node(data);

        // linkded list is empty
        if(head == null){
            head = newNode;
            tail = newNode;

            tail.next = head;
            head.prev = tail;
            size++;
            return;

        }

        // when linkedlist is not empty
        else{

            newNode.next = head;
            head.prev = newNode;

            head = newNode;

            tail.next = head;
            head.prev = tail;

            

            size++;


        }
    }

        //===============================
        // insert at tail
        //==================================


        public void insertAtTail(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = newNode;
                tail = newNode;

                tail.next = head;
                head.prev = tail;
                size++;
                return;
            }
            else{
            newNode.prev = tail;
            newNode.next = head;

            head.prev = newNode;
            tail.next = newNode;

            tail = newNode;

            size++;
            }
        }
    

    //============================================
    //    insert at position
    //=======================================


    public void insertAtPosition(int position, int data){
        if(position == 1){
            insertAtHead(data);
            return;
        }

        // position mera last ho to user kar lengte tail
        if(position == size+1){
            insertAtTail(data);
            return;
        }

        // positin ise bahar ho linkedlist then use this
        if(position < 1 || position> size+1){
            System.out.println("linkedlist is empty cannot be print");
            return;
        }

        // when linked list is not empty 

        Node prevNode = head;
        for(int i=1; i<=position -2; i++){
            prevNode = prevNode.next;
        }

        Node currNode = new Node(data);
        Node nextNode = prevNode.next;

        currNode.prev = prevNode;
        prevNode.next = currNode;

        currNode.next = nextNode;
        nextNode.prev = currNode;

        size++;


    }

    //==============================================
    //      print the list
    //============================================

    public void printList(){
        if(head == null){
            System.out.println("Linkedlist is empty cannot be print");
            return;
        }

        Node current = head;
        do{
            System.out.print(current.data );
            current = current.next;

            if(current != head){
                System.out.print(" <-> ");
            }

        } while(current != head);
        System.out.println(" <-> (back to head)");
    }

    //========================================
    //        reverse print the list
    //==========================================

    public void reversePrintList(){
        if(head == null){
            System.out.println("linkedlist is empty cannot be print");
            return;
        }
        Node current = tail;
        do{
            System.out.print(current.data );
            current = current.prev;
            if(current != tail){
                System.out.print(" <-> ");
            }
        } while(current != head);

        System.out.println("(back to head) ");
    }

    //======================================
    // searching
    //=======================================

    public boolean search(int target){
        // if(position < 1 || position < size+ 1){
        //     Sytem.out.println("linked list is empty cannot be print");
        //     return;
        // }
        if(head == null){
            return false;
        }

        Node current = head;

        do{
            if(current.data == target){
                return true;
            }

            current = current.next;
        } while(current != head);

        return false;
    }


    // public int getSize(){
    //     return size;
    // }

    // public int isEmpty(){
    //     return head == null;
    // }

    // public int getHead(){
    //     if(head == null){
    //         throw new IllegalStatException(
    //             "cirular linked list is empty"
    //         );
    //     }
    //     return head.data;
    // }

    // public int getTail(){
    //     if(head == null){
    //         throw new IllegaStateException(
    //             "circular linked list is empty cannot be be get tail"
    //         );

    //     }
    //     return tail.data; 
    // }

    //===========================================
    // delteing
    //==========================================

    public void deleteAtHead(){
        if(head == null){
            System.out.println("linked list is empty cannto be delte");
            return;
        }

        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node temp = head;

        head = head.next;

        // disconnect dete node
        temp.next = null;
        temp.prev = null;

        //maninatain circular node
        tail.next = head;
        head.prev = tail;

        size--;
    }

    //================================
    // delte at tail
    //===============================

    public void deleteAtTail(){
        if(head == null){
            System.out.println("linked list is empty cannot be delte");
            return;
        }

        if(head == tail){
            head = null;
            tail = null;
            size = 0;
        }

        Node prevNode = tail.prev;

        //disconnect of node
        tail.next = null;
        tail.prev = null;

        tail = prevNode;
        

        // mainatain circula rotataion
        tail.next = head;
        head.prev = tail;

        size--;
    }

    //==========================
    //    delteing at posiston
    //===============================

    public void dleteAtPosition(int position){
        if(position<1 || position > size ){
            System.out.print("invalid position");
            return;
        }

        if(position == 1){
            deleteAtHead();
            return;
        }

        if(position == size){
            deleteAtTail();
            return;
        }

        Node prevNode = head;

        for(int i=1; i<= position -2; i++){
            prevNode = prevNode.next;
        }

        Node currNode = prevNode.next;
        Node nextNode = currNode.next;

        //disconnect of node
        currNode.next = null;
        currNode.prev = null;

        // maintaion the node

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;
    }


    public static void main(String [] args){
        circularDoubleLinkedList mylist = new circularDoubleLinkedList();
        

        mylist.insertAtHead(30);
        mylist.printList();

        mylist.insertAtHead(20);
        mylist.printList();

        mylist.insertAtHead(10);
        mylist.printList();

        mylist.insertAtTail(40);
        mylist.printList();

        mylist.insertAtTail(50);
        mylist.printList();

        // reverse print list
        mylist.reversePrintList();

        //searching in list
        System.out.println("found or not:" + mylist.search(30));


        mylist.deleteAtHead();
        mylist.printList();

        mylist.deleteAtTail();
        mylist.printList();

        mylist.dleteAtPosition(2);
        mylist.printList();
    }
}
