package Collections;

import java.util.Vector;

public class VectorProgram
{
    public static void main(String[] args)
    {
        //vector is a subclass of abstractList
        //use it only when the synchronization is essential
        //arrayList is preferred because performance of vector is slower than arrayList
        Vector<Integer> v1 = new Vector<>();//vector with initial capacity 10
        v1.add(89);
        v1.add(90);
        v1.add(56);
        System.out.println("Vector content:"+v1);
    }
}