package collections_using_built_in;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaticMethodsForListsAndCollections
{
    public static void main(String[] args)
    {
        List<String> colorsList = new ArrayList<>();
        colorsList.add("Red");
        colorsList.add("White");
        colorsList.add("Blue");
        System.out.println("Before performing sorting on list content is :"+colorsList);
        Collections.sort(colorsList);
        System.out.println("After performing the sorting on the list using static method content is: "+colorsList);

        //sorting in descending order with the help of comparator
        Collections.sort(colorsList, Collections.reverseOrder());
        System.out.println("After sorting in descending order:"+colorsList);

        List<Integer> list1 = new ArrayList<>();
        list1.add(78);
        list1.add(89);
        list1.add(67);
        list1.add(90);
        list1.add(90);
        list1.add(90);
        list1.set(0,2);
        list1.addFirst(90);
        list1.addLast(90);
//        list1.contains(90);
//        list1.get(0);
//        list1.getFirst();
//        list1.getLast();
//        list1.isEmpty();
//        list1.lastIndexOf(9);
//        list1.remove(90);
//        list1.removeFirst();
//        list1.removeLast();
//        list1.reversed();
//        list1.toArray();
//        list1.toString();

        for (int e : list1){
            System.out.print(e+" ");
        }

        System.out.println("89 is at index: "+Collections.binarySearch(list1,89));
        System.out.println("Red color is at index: "+Collections.binarySearch(colorsList,"Red"));
        System.out.println("Purple color is at index: "+Collections.binarySearch(colorsList, "Purple"));//-1
        //-1 in binarySearch means element doesn't exist in the colorList

        System.out.println("Frequency of 90 in list1 is : "+Collections.frequency(list1, 90));

        //explore more methods using "Collection." class
    }
}