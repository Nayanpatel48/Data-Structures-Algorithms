package collections_using_built_in;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestListArrayListAndLinkedList
{
    public static void main(String[] args)
    {
        //to create list there are two concrete classes: ArrayList and LinkedList
        //duplicates allowed
        //traversal possible in unidirectional as well as bidirectional
        //list created using arrayList
        // is a dynamic array it's size increases automatically
        //if insertion & deletion is not required then arrayList is most efficient otherwise linked list
        List<Integer> list1 = new ArrayList<>();
        list1.add(90);
        list1.add(89);
        list1.add(78);
        list1.add(67);
        System.out.println("After simple insertion operation:"+list1);

        //inserting element at specific index
        list1.add(2, 99);
        System.out.println("After specific index insertion:"+list1);

        list1.remove(1);//1 index element removed
        System.out.println(list1);

        //set method -> similar to add
        list1.set(0,899);
        System.out.println("After set operation:"+list1);

        System.out.println("Index of 899 is :"+list1.indexOf(899));
        list1.add(89);
        list1.add(89);
        System.out.println(list1);
        System.out.println("Last index of 89 is: "+list1.lastIndexOf(89));

        //subList
        System.out.println("Sub list from index 1 to 4 is :"+list1.subList(1,4));

        //linked list can be created using it's no argument constructor as well as parameterized constructor
        //no arg constructor
        List<Integer> list2 = new LinkedList<>();
        list2.add(90);
        System.out.println("Content in list2:"+list2);

        //parameterized constructor
        List<Integer> list3 = new LinkedList<>(list1);
        System.out.println("Before insertion:"+list3);
        list3.add(2,0);
        System.out.println("After insertion:"+list3);

        //list iterator for list3
        ListIterator<Integer> listIterator = list3.listIterator();
        //listIterator will traverse the list elements one by one
        System.out.println("Displaying linked list forward:");
        while (listIterator.hasNext())//checking that list has a next element
            System.out.print(listIterator.next()+" ,");
        System.out.println();

        System.out.println("Displaying linked list backward:");
        listIterator = list3.listIterator(list3.size());
        while (listIterator.hasPrevious())//checking that list has a previous element in backward direction
            System.out.print(listIterator.previous()+", ");
    }
}