package queue;

import java.util.Queue;

public class QueueImplementationArray {
    static class Queue{
        static int arr[];
        static int size;
        static int rear=-1;

        public Queue(int size){
            arr=new int[size];
            this.size=size;
        }

        //O(1)
        public static boolean isEmpty(){
            return rear==-1;
        }

        //enqueue O(1)
        public static void add(int data){
            //step 1: check whether the queue is empty or not. if empty then add data into it
            //if not then print "queue is full"
            if (rear == (size-1)){
                System.out.println("Queue is full.");
                return;
            }
            rear++;
            arr[rear]=data;
        }

        //dequeue O(n)
        public static int remove(){
            //step 1: check whether the queue is empty or not. if empty then print the message
            //"Queue is empty". if not then return front
            if (isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }

            //if stack is not empty
            int front = arr[0];
            for (int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
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

            return arr[0];
        }
    }
    public static void main(String[] args){
        Queue q = new Queue(4);

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