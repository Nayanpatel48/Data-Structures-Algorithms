package queue;

import java.util.*;

public class BuiltInQueue {
    public static void main(String[] args){

        //Interfaces does not have classes.
        Queue<Integer> queue = new LinkedList<>();

        queue.add(89);
        queue.add(90);
        queue.add(45);
        queue.add(23);

        while (!queue.isEmpty()){
            System.out.print(queue.peek()+" ");
            queue.remove();
        }
    }
}