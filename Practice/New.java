package Practice;
import java.util.*;

public class New {
    public static void main(String[] args) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        String s1 = "tozo";
        String s2 = "ootz";

        int len = s1.length();
        int noOfDiff = 0;

        //checking for differing characters
        for (int i=0;i<len;i++){
            if (noOfDiff>=2){
                System.out.println("false");
                return;
            }
            if (s1.charAt(i) != s2.charAt(i)){
                noOfDiff++;
            }
            System.out.println(noOfDiff);
        }

        //creating sets
        for (int i = 0; i < len; i++) {
            set1.add(s1.charAt(i));
            set2.add(s2.charAt(i));
        }

        if (set1.size() != set2.size()){
            System.out.println("false");
        }
        //since sets are created checking that both are equal or not

        //Iterator for set
        Iterator<Character> iterator = set1.iterator();
        while (iterator.hasNext()) {
            if (!set2.contains(iterator.next())) {
                System.out.println("false");
            }
        }
        System.out.println("true");
    }
}