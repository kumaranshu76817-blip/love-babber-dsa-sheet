
import org.w3c.dom.Node;

public class singlyLInkedList {

    
    
    static class  Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private  Node head;
    private Node tail;
    private int size;


    //constructor
    public singlyLInkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    //======================
    //    instertion
    //=========================

    //intsert at beginnnign
    public void insertAtHead(int data){
        Node newNode = new Node(data);
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    //insert at tail 
    public void insertAtTail(int data){
        Node newNode = new Node(data);
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    //insert at position in middle
    public void insertAtMiddle(int position, int data){
        //base case
        Node previous = head;
        if(position<1 && position > size+1){
            //insertion is not possible
            System.out.println("insertion is not possible");
            return;
        }
        if(position == 1){
            //insert at head
            insertAtHead(data);
        }
        if(position == size+1){
            insertAtTail(data);
        }
        //insert at middle , then
        Node newNode = new Node(data);

        for(int i=1; i<=position-2; i++){
            previous = previous.next;
        }

        newNode.next = previous.next;
        previous.next = newNode;
        size++;



    }
    public  void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpyt(){
        return head == null;
    }

    public int getHead(){
        if(head == null){
            return -1;
        }
        else{
            return head.data;
        }

    }

    public int getTail(){
        if(tail == null){
            return -1;
        }
        else{
            return tail.data;
        }
    }

    public void clear(){
        
    }

    //===================================
    //       serching
    //===================================


    //searching ke liye hai
    public boolean getSearch(int target){
        Node temp = head;
        while (temp != null) {
            if(temp.data == target){
                return true;
            }
            else{
                temp  = temp.next;
                
            }
        }
        return  false;
    }
    

    //find position of linked list , the they use 
    public int getFindPosition(int target){
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if(temp.data == target){
            return  position;
        }
        else{
            temp = temp.next;
            position++;
        }
        }
        return -1;
    }
    //========================================
    //            updating
    //========================================

    public void updatAtPosition(int position, int newValue){
        Node temp = head;
        if(position < 1 || position > size+1){
            System.out.println("cannot update beauser of out of range");
        }
        for(int i=0; i<position-1; i++){
            temp = temp.next;
        }
        temp.data = newValue;
    }

    // update value at linkedlist
    public void updateValue(int element , int newValue){
        Node temp = head;
        while(temp != null){
            if(temp.data == element){
                temp.data = newValue;
                
            }
            temp = temp.next;
        }
    }

    //======================================
    //         deleting
    //======================================

    //delete at head 
    public void deletAtHead(){
        if(head == null){
            System.out.println("linkedlist is empty cannot be delete ");
            return;
        }

        head = head.next;
        size--;

        return;
    }

    // delete at tail , means last of node
    public void deleteTail(){
        if(head == null){
            System.out.println("linkedlist is empty tail doesnt exist");
            return;
        }

        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return ;
        }

        Node temp = head;
        for(int i=1; i<=size-2; i++){
            temp = temp.next;
        }

        //now temp is position last second of nodes 
        temp.next = null;
        tail = temp;
        size--;


    }

    // delete at position
    public void deleteAtPosition(int position){
        if(position < 1 && position > size + 1){
            System.out.println("invalid position");
            return;
        }

        if(position == 1){
            deletAtHead();
            return;

        }

        if(position == size){
            deleteTail();
            return;
        }

        Node prev = head;
        for(int i=1; i<= position-1; i++){
            prev = prev.next;
        }

        Node curr = prev.next;

        Node forward = curr.next;

        prev.next = forward;
        curr = null;

        size--;


    }


    // delete at value of element
    public boolean  deleteAtVale(int position){
        if(position>1 && position < size+1){
            System.out.println("ll is empty value cannot be delete");
            return false;
        }

        if(head.data == position){
            deletAtHead();
            return true;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if(curr.data == position){
                //delteting ka logic 
                Node forward = curr.next;

                prev.next = forward;
                curr.next = null;

                if(tail == curr){
                    tail = prev;
                }
                size--;
                return true;
            }

            else{
                prev = prev.next;
                curr = curr.next;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        singlyLInkedList myList = new singlyLInkedList();
        if(myList.isEmpyt()){
            System.out.println("ll is empyt");

        }

        System.out.println("size of linkedlist:"+myList.getSize());

        myList.insertAtHead(10);
        myList.printList();

        myList.insertAtHead(20);
        myList.printList();

        myList.insertAtTail(100);
        myList.printList();
 
        myList.insertAtTail(110);
        myList.printList();
 
        myList.insertAtTail(120);
        myList.printList();
 
        myList.insertAtTail(130);
        myList.printList();
 
        myList.insertAtTail(140);
        myList.printList();
 
        myList.insertAtTail(150);
        myList.printList();
 
        myList.insertAtTail(200);
        myList.printList();

        myList.insertAtMiddle(3, 5);
        myList.printList();
 
        System.out.println("head data:"+ myList.getHead());

        System.out.println("tail data:"+ myList.getTail());

        System.out.println("search in likedlist is 130"+myList.getSearch(130));

        System.out.println("find position of 200 in linked list:"+ myList.getFindPosition(150));


        myList.updatAtPosition(4, 4000);
        myList.printList();

        myList.updateValue(5, 500);
        myList.printList();

        myList.deletAtHead();
        myList.printList();

        myList.deletAtHead();
        myList.printList();

        myList.deletAtHead();
        myList.printList();

        // myList.deleteTail();
        // myList.printList();


        myList.deleteAtPosition(3);
        myList.printList();

        myList.deleteAtVale(150);
        myList.printList();

    }
}
