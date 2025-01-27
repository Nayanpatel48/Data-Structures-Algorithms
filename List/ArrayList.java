package List;

public class ArrayList {
    public static void main(String[] args){
        java.util.ArrayList<Integer> list1 = new java.util.ArrayList<>();

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