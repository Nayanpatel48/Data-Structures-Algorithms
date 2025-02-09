package queue;

public class QueueUsingLinkedList {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Queue{
        static Node head = null;
        static Node tail = null;

        //O(1)
        public static boolean isEmpty(){
            return head==null && tail==null;
        }

        //enqueue O(1)
        public static void add(int data){
           Node newNode = new Node(data);

           //if queue is empty
           if (isEmpty()){
               tail=head=newNode;
               return;
           }
           tail.next=newNode;
           tail=newNode;
        }

        //dequeue O(1)
        public static int remove(){
            //step 1: check whether the queue is empty or not. if empty then print the message
            //"Queue is empty". if not then return front
            if (isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }

            int front = head.data;
            head = head.next;

            //if there is only one element
            if (head==tail){
                tail=null;
            } else {
                head=head.next;
            }

            return front;
        }

        //peek O(n)
        public static int peek(){
            //step 1: check whether the queue is empty or not. if true then print message
            //'queue is empty'. if not then return the first element from queue.
            if (isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }

            return head.data;
        }
    }
    public static void main(String[] args){

        Queue.add(9);
        Queue.add(3);
        Queue.add(6);
        Queue.add(0);

        while (!Queue.isEmpty()){
            System.out.print(Queue.peek() +" ");
            Queue.remove();
        }
    }
}
