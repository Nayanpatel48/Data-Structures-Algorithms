package setAndMaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetProgram
{
    public static void main(String[] args)
    {
        //HashSet
        HashSet<String> set1 = new HashSet<>();
        set1.add("NewYork");
        set1.add("Delhi");
        set1.add("Rajkot");
        set1.add("Mumbai");
        set1.add("Surat");
        set1.add("UnitedKingdom");
        set1.add("America");

        //TreeSet
        TreeSet<String> set2 = new TreeSet<>(set1);
        //all set1 elements are now in set2

        System.out.println("set1 (HashSet) content:"+set1);
        //set1 (HashSet) content:[Delhi, Rajkot, UnitedKingdom, America, NewYork, Surat, Mumbai]
        System.out.println("set2 (TreeSet) content:"+set2);
        //set2 (TreeSet) content:[America, Delhi, Mumbai, NewYork, Rajkot, Surat, UnitedKingdom]
        //you will notice that in TreeSet the values are in sorted order this is a property of TreeSet

        //some important methods for TreeSet
        System.out.println(set2.size());//7 (assuming there are 7 elements in the TreeSet)

        System.out.println("By using .descendingIterator() method for set2:");
        Iterator<String> set2Iterator = set2.descendingIterator();
        while (set2Iterator.hasNext())
            System.out.print(set2Iterator.next()+", ");
        //output:
        //By using .descendingIterator() method for set2:
        //UnitedKingdom, Surat, Rajkot, NewYork, Mumbai, Delhi, America, false

        System.out.println(set2.add("Boston"));
        System.out.println(set2);
        //output:
        //[America, Boston, Delhi, Mumbai, NewYork, Rajkot, Surat, UnitedKingdom]
        System.out.println(set2.isEmpty());//false (set 2 is not empty)

        TreeSet<Integer> set3 = new TreeSet<>();
        set3.add(1);
        set3.add(22);
        set3.add(45);
        set3.add(99);
        System.out.println("set3 content:"+set3);
        System.out.println(set3.ceiling(55));//99
        //Finds the least element greater than or equal to a given element in a sorted set

        System.out.println(set3.floor(55));//45
        //Finds the least element smaller than or equal to a given element in a sorted set

        System.out.println(set3.contains(45));//yes ->true, no ->false
        System.out.println(set3.first());//1 (first element in the set)
        System.out.println(set3.last());//99 (last element in the set)
        System.out.println(set3.headSet(44));//[1, 22]
        //from starting all the values which are less then the value passed will be returned in the form of set
        System.out.println(set3.tailSet(2));//[22, 45, 99]
        //from starting all the values which are less then the value passed will be returned in the form of set
        System.out.println(set3.higher(45));//99 (returns value higher than 45)
        System.out.println(set3.lower(45));//22 (returns value lower than 45)
        System.out.println(set3.pollFirst());//1 (retrieves and removes the first element from the set)
        System.out.println(set3.pollLast());//99 (retrieves and removes the last element from the set)
        System.out.println("After performing .pollFirst and .pollLast:"+set3);
        //After performing .pollFirst and .pollLast:[22, 45]
        set3.add(90);
        set3.add(7878);
        set3.add(23);
        set3.add(48);
        System.out.println("Before performing .remove() operation set3 :"+set3);
        //Before performing .remove() operation set3 :[22, 23, 45, 48, 90, 7878]
        System.out.println(set3.remove(23));//true (it says true if the value is deleted successfully otherwise returns false)
        System.out.println("Before performing .remove() operation set3 :"+set3);
        //Before performing .remove() operation set3 :[22, 45, 48, 90, 7878]
        System.out.println(set3.reversed());
        //[7878, 90, 48, 45, 22] (note:there is no change in original set3 , it will show us set in reverse order)
        System.out.println("Original set3:"+set3);
        System.out.println("The subset of set3 containing values in between 0 & 200: "+set3.subSet(0,200));
        //The subset of set3 containing values in between 0 & 200: [22, 45, 48, 90]
        Object[] arr = set3.toArray();
        System.out.println(Arrays.toString(arr));//to String is required to print the arr sing it's type is object type
        //[22, 45, 48, 90, 7878]
    }
}