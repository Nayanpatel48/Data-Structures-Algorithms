package Collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueProgram
{
    public static void main(String[] args)
    {
        Queue<Integer> queue1 = new LinkedList<>();
        //insert element into queue
        queue1.offer(1);
        queue1.offer(5);
        queue1.offer(9);
        queue1.offer(89);
        System.out.println("Content inside queue: "+queue1);

        //below:retrieving and removing element from the head of queue
        //in poll method queue empty => null
        System.out.println(queue1.poll()+" is removed from queue head.");
        //below:removes head element from queue if it is empty then it throws the exception
        queue1.remove();

        System.out.println("Head of queue "+queue1.peek());

        //retrieves the element from queue head but not remove it
        //if queue is empty throws exception
        System.out.println(queue1.element());
    }
}