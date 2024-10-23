package collections;

import java.util.ArrayList;
import java.util.Collection;
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

        //The Collection interface extends the Iterable interface
        //the Iterable interface defines the iterator() method
        Iterator<String> iterator = collection.iterator();

        //.hasNext() is used to check whether there are more elements in the iterator
        while (iterator.hasNext())
            System.out.print(iterator.next()+" ,");
    }
}