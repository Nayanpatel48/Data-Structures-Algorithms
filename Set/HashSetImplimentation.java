package Set;
import java.util.*;

public class HashSetImplimentation
{
    public static void main(String[] args)
    {
        //created HashSet
        Set<String> set = new HashSet<>();

        //Add strings to the hashset
        set.add("Nayan");
        set.add("Riya");
        set.add("Kevin");
        set.add("Hiren");
        set.add("Hiren");//duplicates will be not allowed

        System.out.println(set);

        //Display the set elements
        for (String s : set)
            System.out.print(s.toLowerCase()+" ");
    }
}