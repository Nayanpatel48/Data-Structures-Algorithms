package Queues;
import java.util.*;

public class PriorityQueue
{
    public static void main(String[] args)
    {
        java.util.PriorityQueue<String> priorityQueue = new java.util.PriorityQueue<>();
        priorityQueue.offer("Hema");
        priorityQueue.offer("Sema");
        priorityQueue.offer("khema");
        priorityQueue.offer("Meme");

        //priority queue using comparable
        //elements are removed in increasing order
        System.out.println("Priority queue using comparable:");
        while (!priorityQueue.isEmpty())
            System.out.print(priorityQueue.remove()+"\t");

        java.util.PriorityQueue<String> priorityQueue1 = new java.util.PriorityQueue<>(4,Collections.reverseOrder());
        priorityQueue1.offer("Hema");
        priorityQueue1.offer("Sema");
        priorityQueue1.offer("khema");
        priorityQueue1.offer("Meme");

        //priority queue using comparator
        //elements are removed in decreasing order
        System.out.println();
        System.out.println("Priority queue using comparator:");
        while (!priorityQueue1.isEmpty())
            System.out.print(priorityQueue1.remove()+"\t");
    }
}