public class circularSingleLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public circularSingleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }


    //=======================================
    //       inserting
    //=======================================


    public void insertAtHead(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
            size++;
            return;
        }
        

        else{
        newNode.next = head;
        head = newNode;

        // for circular linkedList
        tail.next = head;
        size++;
        }

        
    }

    public void insertAtTail(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;

            tail.next = head;
            size++;
            return;
        }
        else{
            tail.next = newNode;
            tail = newNode;

            // for circular linkedlist
            tail.next = head;
        }
    }

    public void insertAtPosition(int position, int data){
        if(position == 1){
            insertAtHead(data);
            return;
        }

        if(position == size+1 ){
            insertAtTail(data);
            return;
        }


        if(position<1 || position> size+1){
            System.out.println("linkedlist is empty cannot be print");
            return;
        }

        Node newNode = new Node(data);
        Node prevNode = head;
        for(int i=1; i<=position-2; i++){
            prevNode = prevNode.next;
        }

        Node currNode = newNode;
        Node nextNode = prevNode.next;

        prevNode.next = currNode;
        currNode.next = nextNode;

        //for circular linkedlist
        tail.next = head;

        

        size++;


       
        
    }

    
    //print the list
    public void printList(){
        if(head == null){
            System.out.println("linkedlist is empty cannot be print");
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while(temp != head);

        System.out.println("(back to head)");

    }

    //=========================================================
    //                      searching
    //==========================================================

    public boolean searchLinkdedList(int target){
        if(head == null){
            return false;
        }

        Node temp = head;
        do {
            if(temp.data == target){
                return true;

            }
            
                temp = temp.next;
            
        } while (temp != head);
        return false;
    }

    // ===================================
    // deletion
    // =====================================

    public void deletAtHead(){
        if(head == null){
            System.out.println("linkedlist is empty cannot be print");
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
        tail.next = head;
        temp.next = null;
    
        
        size--;
    }

    public void deletAtTail(){
        if(head == null){
            System.out.println("linkedlist is empyt cannot be delete");
            return;
        }

        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node prevNode = head;
        for(int i=0; i<=size-1; i++){
            prevNode = prevNode.next;
        }

        
        prevNode.next = head;
        
        tail.next = null;
        tail  = prevNode;



        // tail = prevNode;
        // prevNode.next = null;
        // tail.next = head;

        size--;
    }
    public void deleteAtPosition(int position){
        if(position < 1 || position > size+1){
            System.out.println("cannot be delete because linkedlist is empty");
            return;
        }
        if(position == 1){
            deletAtHead();
            return;
        }
        if(position == size){
            deletAtHead();
            return;
        }

        Node prevNode = head;
        for(int i=1; i<= position -2; i++){
            prevNode = prevNode.next;
        }

        Node curNode = prevNode.next;
        Node nextNode = curNode.next;

        prevNode.next = nextNode;
        curNode = null;

        size--;



    }

    public static void main(String[] args) {
        circularSingleLinkedList mylist = new circularSingleLinkedList();

        mylist.insertAtHead(20);
        mylist.printList();

        mylist.insertAtHead(10);
        mylist.printList();

        mylist.insertAtTail(30);
        mylist.printList();

        mylist.insertAtPosition(1, 5);
        mylist.printList();

        mylist.insertAtPosition(3, 15);
        mylist.printList();

        mylist.insertAtPosition(5,50 );
        mylist.printList();

        System.out.println("found or not:"+ mylist.searchLinkdedList(20));

        mylist.deletAtHead();
        mylist.printList();

        mylist.deletAtTail();
        mylist.printList();

        mylist.deleteAtPosition(3);
        mylist.printList();
        
    }


}
