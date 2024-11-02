package collections_using_built_in;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dequeue
{
    public static void main(String[] args)
    {
        //Dequeue allows the elements to be inserted from both ends of the queue
        Deque<Integer> d1 = new ArrayDeque<>();

        d1.offer(67);
        d1.offer(89);
        d1.offerFirst(90);
        d1.offerLast(45);
        System.out.println("Deque content:"+d1);

        Deque<String> strDeque = new ArrayDeque<>();
        strDeque.offer("Nayan");
        strDeque.offer("Mayank");
        //investigation study
        //why Object type data type? => here s array can hold any type of object
        Object[] s = new Object[strDeque.size()];
        s=strDeque.toArray();
        System.out.println(s[0]);

        //given element is added at last
        strDeque.offerLast("GECR");
        System.out.println(strDeque);


    }
}
