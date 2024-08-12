package setAndMaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps
{
    public static void main(String[] args)
    {
        //Map can be created using HashMap, LinkedHashmap, TreeMap
        //Map is a container object which stores the key/value pairs
        //enables fast retrieval
        //A map cannot contain duplicate key
        Map<String, Integer> map1 = new HashMap<>();
        //HasMap created

        //putting value inside map
        map1.put("Andrew",45);
        map1.put("John",35);
        map1.put("Tom",78);
        map1.put("Johny",99);

        //Display HashMap
        System.out.println("Displaying HashMap:"+map1);
        //Displaying HashMap:{Tony=99, Tom=78, Andrew=45, John=35}

        //created a TreeMap from preceding HashMap
        TreeMap<String, Integer> treeMap1 = new TreeMap<>(map1);
        System.out.println("Displaying entries in the ascending order of the keys:");
        System.out.println(treeMap1);
        //Displaying entries in the ascending order of the keys:
        //{Andrew=45, John=35, Johny=99, Tom=78}

        //created LinkedHashMap using preceding TreeMap
        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap<>(treeMap1);
        System.out.println(linkedHashMap1.get("Johny"));//99

        System.out.println("Content inside linkedHashMap:");
        System.out.println(linkedHashMap1);
        //Content inside linkedHashMap:
        //{Andrew=45, John=35, Johny=99, Tom=78}
    }
}