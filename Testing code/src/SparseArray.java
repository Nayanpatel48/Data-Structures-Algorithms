import java.util.*;

public class SparseArray {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();

        list1.add("abc");
        list1.add("abc");
        list1.add("abc");
        list1.add("bc");

        list2.add("abc");
        list2.add("bc");
        list2.add("cd");

        System.out.println(matchingStrings(list1, list2));
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        ArrayList<Integer> ansList = new ArrayList<Integer>();
        int flag;

        for (int i = 0; i < queries.size(); i++) {
            flag = 0;
            for (int j = 0; j < stringList.size(); j++) {
                if (queries.get(i) == stringList.get(j)) {
                    flag++;
                }
            }
            ansList.add(flag);
        }
        return ansList;
    }
}