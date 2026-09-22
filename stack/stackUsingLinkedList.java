public class stackUsingLinkedList{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next  = null;
        }
    }

    private Node head;
    private int size;

    stackUsingLinkedList(){
        head = null;
        size = 0;
    }


    public void push(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode;

        size++;
    }

    public  int pop(){

        if(head == null){
            System.out.println("stack is empty");
            return -1;
        }

        int top = head.data;
        head = head.next;
        
        return top;

    }

    public int peek(){
        if(head == null){
            System.out.println("stack is empty");
            return -1;
        }

        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getSize(){
        return size;
    }


    // display stack element
    public void display(){
        if(head == null){
            System.out.println("stack is empty");
            return;
        }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        stackUsingLinkedList stack = new stackUsingLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        stack.pop();
        stack.display();

        stack.peek();
        stack.display();

    }
    
}

