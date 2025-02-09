package List;

import java.util.*;

public class ArrayList1 {
    public static void main(String[] args){
        ArrayList<Integer> list1 = new ArrayList<>();

        //adding new element to list1
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
        list1.removeFirst();

        System.out.println();
        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
    }
}