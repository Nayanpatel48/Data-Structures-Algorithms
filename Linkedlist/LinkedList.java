package Linkedlist;
import java.util.ArrayList;
import java.util.ListIterator;

public class LinkedList
{
    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(0,6);
        arrayList.add(2,9);
        System.out.println("A list of integers in the arrayList:");
        System.out.println(arrayList);

        //linked list
        java.util.LinkedList<Object> linkedList = new java.util.LinkedList<>(arrayList);
        linkedList.add(1,"red");
        linkedList.removeLast();
        linkedList.addFirst("Blue");

        System.out.println("Display the linked list forward:");
        ListIterator<Object> listIterator = linkedList.listIterator();
        //traversing linkedlist
        while (listIterator.hasNext())
            System.out.print(listIterator.next()+"\t");

        System.out.println();

        System.out.println("Display the linked list backward:");
        listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious())
            System.out.print(listIterator.previous()+"\t");
    }
}