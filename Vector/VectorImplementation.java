package Vector;
import java.util.ArrayList;
//for more checkout reference book danial liyang
public class VectorImplementation
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
        //Creates a default empty vector with initial capacity 10.
        java.util.Vector<Integer> DefaultVector = new java.util.Vector<>();

        //creates a vector from an existing collection
        java.util.Vector<Integer> vector = new java.util.Vector<>(arrayList);
        //Appends the element to the end of this vector.
        vector.add(69);
        //returns the current capacity of the vector
        System.out.println("The current capacity of the vector is "+vector.capacity());
        //Returns the object at the specified index.
        System.out.println("The element at 3 index is "+vector.elementAt(3));
        //Increases the capacity of this vector.
        vector.ensureCapacity(1000);
        //Returns the first element in this vector.
        System.out.println("The first elemet is "+vector.getFirst());
        //Returns the last element in this vector.
        System.out.println("The last element is "+vector.getLast());
        //Removes the first matching element in this vector.
        System.out.println(vector);
        //Removes the first matching element in this vector.
        vector.removeElement(2);
        //remove element at specified index
        vector.removeElementAt(2);
        //Sets a new element at the specified index.
        vector.setElementAt(1,2);
        System.out.println(vector);
        //Sets a new size in this vector.
        vector.setSize(10000);
        System.out.println(vector.size());
    }
}