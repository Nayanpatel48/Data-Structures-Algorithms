package collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueProgram
{
    public static void main(String[] args)
    {
        //In priority queue higher priority is given to the least value element in the list
        //Hence the least value element is removed first
        PriorityQueue<String> p1 = new PriorityQueue<>();
        //default priority queue
        p1.offer("Nayan");
        p1.offer("Ronic");
        p1.offer("'Anikesh");
        p1.offer("'Harshil");
        System.out.println("Content of priority queue: "+p1);

        //here elements will be removed in increasing order
        while (!p1.isEmpty())
            System.out.println(p1.remove());

        //WE are using the comparator to specify the order
        PriorityQueue<Integer> p2 = new PriorityQueue<>(10, Collections.reverseOrder());
        //means decreasing ordering here
        p2.offer(89);
        p2.offer(8);
        p2.offer(9);
        p2.offer(809);
        System.out.println("Content of p2: "+p2);

        while (!p2.isEmpty())
            System.out.println(p2.remove());
    }
}