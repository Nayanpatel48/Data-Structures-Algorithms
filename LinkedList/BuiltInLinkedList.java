package LinkedList;

import java.util.*;

public class BuiltInLinkedList {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("Nayan");
        list.addFirst("Jay");
        list.addFirst("Bajaj");
        System.out.println(list);

        list.addLast("Him");
        list.addLast("Jim");
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        System.out.println("LinkedList size is :"+list.size());
        list.addLast("Hill");
        System.out.println("LinkedList size is :"+list.size());
    }
}