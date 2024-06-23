package List;
import java.util.*;
public class Arraylist
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
    }
}