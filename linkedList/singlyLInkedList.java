
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
    }
}
