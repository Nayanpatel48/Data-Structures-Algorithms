package List;

public class ArrayList {
    public static void main(String[] args){
        java.util.ArrayList<Integer> list1 = new java.util.ArrayList<Integer>();

        //adding new element to list1
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);

        //accessing each element by its index
        for(int i=0;i<list1.size();i++){
            System.out.print(list1.get(i)+" ");
        }
        list1.remove(0);

        System.out.println();
        //accessing each element by its index
        for(int i=0;i<list1.size();i++) {
            System.out.print(list1.get(i) + " ");
        }
    }
}