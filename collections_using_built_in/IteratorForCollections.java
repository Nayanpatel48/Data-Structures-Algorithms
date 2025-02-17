package collections_using_built_in;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class IteratorForCollections
{
    public static void main(String[] args)
    {
        //each collection is iterable
        //you can obtain it's Iterator object to traverse all the elements in the collection
        //Here Collection<String> is a declaration where it can hold any type of collection for
        //example linked list, array list etc it is more flexible than explicit declaration
        Collection<String> collection = new ArrayList<>();
        //I have created object of type Collection which can contain objects of String type
        //and assigned newly created arrayList object to collection object

        collection.add("Atlanta");
        collection.add("Georgia");
        collection.add("Delhi");
        collection.add("Gujarat");
        collection.isEmpty();
        collection.contains("bayab");
        collection.remove(4);
        collection.size();
        collection.toArray();
        collection.toString();


        //The Collection interface extends the Iterable interface
        //the Iterable interface defines the iterator() method

        //.hasNext() is used to check whether there are more elements in the iterator
        for (String s : collection) System.out.print(s + " ,");
    }
}