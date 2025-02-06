package Hashing;

import java.util.*;

public class Set1
{
    public static void main(String[] args)
    {
        //You can create set using one of it's concrete methods => Hashset, LinkedHashSet, TreeSet
        //set interface extends the Collection interface
        //set does not contain any duplicate values
        //HashSet is a concrete class that implements the Set
        //we can create an empty HashSet using no rag constructor , we can create SEt from the existing collection also
        //initial capacity = 16 , load factor = 0.75
        //if size of set becomes size =>16*0.75 = 12 the size doubles
        Set<String> s1 = new HashSet<>();
        s1.add("Rajkot");
        s1.add("Ahemadabad");
        s1.add("Surat");

        s1.add("Vapi");
        s1.add("Vapi");
        System.out.println("Duplicates are not here anymore: "+s1);


        //display elements in the hashset
        for (String s : s1)
            System.out.println(s);
        System.out.println();

        //Iterator for set
        Iterator<String> iterator = s1.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        //creating an empty set
        //adding all elements of set1 into set 2
        Set<String> s2 = new HashSet<>(s1);
        s1.add("America");
        s1.add("Luciana");
        s1.add("Canada");
        s2.add("Ludiyana");
        s2.add("Panjab");
        s2.add("Canada");
        System.out.println("Set2: "+s2);
        System.out.println("Set1: "+s1);

        // common elements in set 2 from set 1
        //s1.retainAll(s2);
        //System.out.println("After removing all different elements in set 2 from set 1 , set 1 is : "+s1);

        s2.retainAll(s1);
        System.out.println("After removing all different elements in set 1 from set 2 , set 2 is : "+s2);
        //[Canada, Rajkot, Ahmadabad, Surat, Vapi]
    }
}