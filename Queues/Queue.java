package Queues;

public class Queue
{
    public static void main(String[] args)
    {
        // Using LinkedList you can also use arraylist to initialize queue
        java.util.Queue<Integer> myQueue = new java.util.LinkedList<>();
        //insert element
        myQueue.offer(1);
        myQueue.offer(3);
        myQueue.offer(6);
        myQueue.offer(29);
        myQueue.offer(23);
        System.out.println(myQueue);
        //Retrieves and removes the head of this queue, or null
        //if this queue is empty.
        System.out.println(myQueue.poll());
        //Retrieves and removes the head of this queue and
        //throws an exception if this queue is empty.
        System.out.println(myQueue.remove());
        //Retrieves, but does not remove, the head of this queue,
        //returning null if this queue is empty.
        System.out.println(myQueue.peek());
        //Retrieves, but does not remove, the head of this queue,
        //throws an exception if this queue is empty.
        System.out.println(myQueue.element());
    }
}