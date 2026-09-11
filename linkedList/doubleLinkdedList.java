public class doubleLinkdedList {
    static  class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        } 
    }

    private  Node head;
    private  Node tail;
    private  int size;

    doubleLinkdedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //=================================
    //         insertinon              
    //===================================

    public  void insertAtHead(int data){
        Node newNode = new Node(data);
        if(head == null && tail == null){
           head = newNode;
           tail = newNode;
        }
        else{
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

        }
        size++;
    }

    //insert at tail
    public void insertAtTail(int data){
        Node newNode = new Node(data);
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    //insert at position
    public void insertAtPosition(int position, int data){
        if(position == 1){
            insertAtHead(data);
            return;
        }
        if(position == size +1){
            insertAtTail(data);
            return;
        }

        if(position <1 || position> size+1){
            System.out.println("linkedlist is empty data cannot be stored");
            return;
        }

        Node temp = head;

        for(int i=1; i<position-1; i++){
            temp = temp.next;
        }
        Node prevNode = temp;
        Node nextNode = prevNode.next;
        Node newNode = new Node(data);

        

        newNode.prev = prevNode;
        prevNode.next = newNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;

        size++;

    }


    //print linkedlist
    public void printList(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    //revers print linkedlist
    public void printReverseList(){
        Node temp = tail;
        while(temp != null){
            System.out.print("<-" + temp.data);
            temp = temp.prev;
        }
        System.out.println();
    }

    //==================================
    //        searching
    //==================================

    public boolean searchLL(int target){
        if(head == null){
            System.out.println("linkedList is empty");
            return false;
        }
        Node temp = head;
        while (temp != null) {
            
        
        if(temp.data == target){
            return true;
        }
        else{
            temp = temp.next;
            
        }
    }
        return false;
    }

    //update linkedlist
    public void updateLinkedList(int postion, int newData){
        if(head == null){
            System.out.println("linkdelist is empyt cannot be update");
            return;
        }
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if(index == postion){
                temp.data = newData;
                return;
            }
            temp = temp.next;
            index++;
        }
        

        
    }
    //===========================
    //   deleting
    //===========================

    public void deletAtHead(){
        if(head == null){
            System.out.println("ll is empty cannot be print");
            return;
        }

        
        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return;
        }

        head = head.next;
        head.prev = null;
        size--;
    }


    //delete at tail
    public void deletAtTail(){
        if(head == null){
            System.out.println("linkelist is empty cannot be delete");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return;
        }

        // Node curNode = tail;
        // Node prevNode = tail.prev;

        // prevNode.next = null;
        // tail.prev = null;
        // // curNode.prev = null;
        

        // tail = prevNode;

        // size--;

    // tail = tail.prev;
    // tail.next = null;

    // size--;

    Node oldTail = tail;
    tail = tail.prev;
    tail.next = null;
    oldTail.prev = null;
    size--;

    }

    public void deletAtPosition(int position){
        if(position <1 || position > size ){
            System.out.println("cannot be delte ");
            return;
        }
        if(position == 1){
            deletAtHead();
            return;
        }
        if(position == size){
            deletAtTail();
            return;
        }
        Node currNode = head;
        for(int i=0; i<position -1 ; i++){
            currNode = currNode.next;
        }
        Node prevNode = currNode.prev;
        Node nexNode = currNode.next;

        prevNode.next = nexNode;
        nexNode.prev = prevNode;

        currNode.next = null;
        currNode.prev = null;

        size--;
    }

    //main method
    public static void main(String[] args) {
        doubleLinkdedList myList = new doubleLinkdedList();

        myList.insertAtHead(10);
        myList.printList();

        myList.insertAtTail(20);
        myList.printList();

        myList.insertAtTail(30);
        myList.printList();

        myList.insertAtPosition(3, 40);
        myList.printList();

        System.out.println("found or not " + myList.searchLL(20));

        myList.updateLinkedList(2, 5000);
        myList.printList();

        // myList.printReverseList();

        myList.deletAtHead();
        myList.printList();

        myList.deletAtTail();
        myList.printList();
        
        myList.deletAtPosition(2);
        myList.printList();
        
    }
}
