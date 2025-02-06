package Hashing;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.HashSet;

public class HashSet1
{
    public static void main(String[] args)
    {
        //note: there is no duplicates allowed.

        //in linkedHashSet we can retrieve elements in the order of their insertion means elements are
        //ordered in linkedHashSet where in HashSet they are not ordered so this is an advantage of it.

        //HashSet creation
        HashSet<String> set1 = new HashSet<>();

        //insertion operation
        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("D");
        set1.add("E");
        set1.add("E");

        //size of hash set
        System.out.println(set1.size());

        //searching operation
        if (set1.contains("A")){
            System.out.println("Set1 contains A.");
        }
        if (!set1.contains("F")){
            System.out.println("Set1 does not contains F.");
        }

        //deletion operation
        set1.remove("A");
        if (!set1.contains("A")){
            System.out.println("The A is deleted successfully.");
        }

        //printing all elements
        System.out.println(set1);

        //traversing hash set using Iterator
        // by default 'hashSetIterator' points to the null value like : (null)->(1)->(2)->(3)
        System.out.println("Elements inside HashSet:");
        Iterator<String> it = set1.iterator();
        //it.hasNext() will return `false` if it is at last element in hashset
        while (it.hasNext())
            System.out.print(it.next()+" ");

        //LinkedHashSet is slightly slower than HashSet because it maintains the insertion order
        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        set2.add("A");
        set2.add("B");
        set2.add("C");
        set2.add("D");
        set2.add("E");

        System.out.println();
        System.out.println("Elements inside LinkedHashSet:");
        Iterator<String> itL = set2.iterator();
        while (itL.hasNext())
            System.out.print(itL.next()+" ");
    }
}