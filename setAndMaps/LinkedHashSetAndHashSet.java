package setAndMaps;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetAndHashSet
{
    public static void main(String[] args)
    {
        //in linkedHashSet we can retrieve elements in the order of their insertion means elements are
        //ordered in linkedHashSet where in HashSet they are not ordered so this is an advantage of it.

        //HashSet
        HashSet<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("D");
        set1.add("E");

        //LinkedHashSet is slightly slower than HashSet because it maintains the insertion order
        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        set2.add("A");
        set2.add("B");
        set2.add("C");
        set2.add("D");
        set2.add("E");

        System.out.println("Elements inside HashSet:");
        Iterator<String> hashSetIterator = set1.iterator();
        while (hashSetIterator.hasNext())
            System.out.print(hashSetIterator.next()+" ");

        System.out.println();
        System.out.println("Elements inside LinkedHashSet:");
        Iterator<String> linkedHashSetIterator = set2.iterator();
        while (linkedHashSetIterator.hasNext())
            System.out.print(linkedHashSetIterator.next()+" ");
    }
}