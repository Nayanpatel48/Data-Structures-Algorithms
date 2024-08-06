package Collections;

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
        System.out.println("89 is at index: "+Collections.binarySearch(list1,89));
        System.out.println("Red color is at index: "+Collections.binarySearch(colorsList,"Red"));
        System.out.println("Purple color is at index: "+Collections.binarySearch(colorsList, "Purple"));//-1
        //-1 in binarySearch means element doesn't exist in the colorList

        System.out.println("Frequency of 90 in list1 is : "+Collections.frequency(list1, 90));

        //explore more methods using "Collection." class
    }
}