package LinkedList;
//space complexity:O(1)
//time complexity:O(n)

import java.util.*;

public class ReverseALinkedList {
    static Node head = null;
    static int size;

    public ReverseALinkedList(){
        this.size = 0;
    }

    public static class Node{
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

    //reverse a linked list
    public void reverseLinkList(Node head){
        //here we will use 3 variables: prev, curr, next.

        //if linked list is empty or single node
        if (head == null || head.next==null){
            System.out.println("LinkedList is empty.");
            return;
        }

        Node prevNode=head;
        Node currNode=head.next;

        while (currNode != null){
            Node nextNode = currNode.next;

            //make our current node pointing prev node
            currNode.next=prevNode;

            //now update the all nodes
            prevNode=currNode;
            currNode=nextNode;
        }

        head.next=null;
        head=prevNode;
    }

    //reverse a linked list using recursion
    public Node reverseLLRecursive(Node head){
        //base case for last node, empty LL, single node case
        if (head == null || head.next == null){
            return head;
        }

        Node newHead = reverseLLRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    //remove from Nth from end
    public Node removeNthFromEnd(Node head, int position){
        //if there is only one node in linked list
        if (head.next == null){
            return null;
        }

        //step 1 : finding size of linked list
        int size =0;
        //created below node for traversing purpose
        Node curr = head;
        while (curr != null){
            curr = curr.next;
            size++;
        }

        //if the we have to remove the sizest node from linked list
        if (position == size){
            return head.next;
        }

        int indexToSearch = size-position;
        int i = 0;
        Node prev = head;

        //traversing node till we find indexToSearch
        while (i<indexToSearch){
            prev=prev.next;
            i++;
        }

        prev.next=prev.next.next;
        return head;
    }

    public Node findMiddle(Node head){
        Node hare = head;
        Node turtle = hare;

        while (hare.next != null && hare.next.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
    }

    //linkedList Palindrome
    public boolean isPalindrome(Node head){
        //step 1 : check if there is only single or no node in linked list.
        //if so then linked list is palindrome
        if (head == null || head.next == null){
            return true;
        }

        //step 2 : Find the middle of linked list
        //1st half ka end
        Node middle = findMiddle(head);

        //step 3 : reversing the second half of linked list
        Node secondHalfStart = findMiddle(middle.next);

        //step 4 : comparing linked list
        Node firstHalfStart = head;
        while (secondHalfStart != null){
            if (firstHalfStart.data != secondHalfStart.data){
                return false;
            }
            secondHalfStart=secondHalfStart.next;
            firstHalfStart=firstHalfStart.next;
        }
        return true;
    }

    public boolean detectCycle(Node head){
        if (head == null){
            return false;
        }
        Node turtle = head;
        Node hare = head;

        while (hare.next != null && hare != null){
            hare = hare.next.next;
            turtle = turtle.next;

            if (hare == turtle){
                return true;
            }
        }
        return false;
    }

    public static void main(String [] args){
        ReverseALinkedList list = new ReverseALinkedList();
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

//        list.reverseLinkList();
        list.head = list.reverseLLRecursive(head);
        list.printList();

        list.removeNthFromEnd(list.head, 2);
        list.printList();

        list.addLast("pill");
        list.addLast("mill");

        System.out.println(list.isPalindrome(list.head));

        System.out.println(list.detectCycle(list.head));



    }
}