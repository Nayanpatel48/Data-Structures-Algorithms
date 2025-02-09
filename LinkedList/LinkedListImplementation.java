package LinkedList;

public class LinkedListImplementation {
    static Node head=null;
    static int size;

    public LinkedListImplementation(){
        this.size = 0;
    }

    static class Node{
        String data;
        Node next;

        public Node(String data){
            this.data=data;
            next=null;
            size++;
        }
    }

    //add-first
    public void addFirst(String data){
        Node newNode = new Node(data);

        //check if the LinkedList is empty or not
        if (head == null){
            head=newNode;
            return;
        }

        //if linked list is not empty
        newNode.next=head;
        head=newNode;
    }

    //add-last
    public void addLast(String data){
        Node newNode = new Node(data);

        //check if the LinkedList is empty or not
        if (head == null){
            head=newNode;
            return;
        }

        //if LinkedList is not empty then traverse till last node
        Node currentNode = head;
        while (currentNode.next != null){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
    }

    //print
    public void printList(){
        //check if the LinkedList is empty
        if (head == null){
            System.out.println("LinkedList is empty.");
        }

        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode.data+"->");
            currentNode=currentNode.next;
        }
        System.out.println("NULL");
    }

    //delete first
    public void deleteFirst(){
        if (head == null){
            System.out.println("LinkedList is empty.");
            return;
        }

        size--;
        head=head.next;
    }

    //delete last
    public void deleteLast(){
        //if linked list is empty
        if (head == null){
            System.out.println("LinkedList is empty.");
            return;
        }

        size--;
        //if last is null
        if (head.next == null){
            head=null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next; //head.next = null -> last node null
        while (lastNode.next != null){
            lastNode=lastNode.next;
            secondLast=secondLast.next;
        }

        secondLast.next=null;
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args){
        LinkedListImplementation list = new LinkedListImplementation();
        list.addFirst("Nayan");
        list.addFirst("Jay");
        list.addFirst("Bajaj");
        list.printList();

        list.addLast("Him");
        list.addLast("Jim");
        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();

        System.out.println("LinkedList size is :"+list.getSize());
        list.addLast("Hill");
        System.out.println("LinkedList size is :"+list.getSize());
    }
}