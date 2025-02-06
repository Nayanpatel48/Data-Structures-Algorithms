package Hashing;
import java.util.*;

public class HashMap1 {
    public static void main(String[] args){
        //in HashMap the keys are always unique.
        //values can be same or different for multiple keys.
        //hashMap is unOrdered

        //real-world example:
        //let's take an example of fuel type as a key and price as a value
        //so there will be all fuel types will be unique since it is hashmap
        //(diesel)->89, (petrol)->89, (cng)->59.

        //country, population
        HashMap<String, Integer> hashMap = new HashMap<>();

        //Insertion operation

        hashMap.put("India", 120);
        hashMap.put("US", 30);
        hashMap.put("Chine", 150);

        //un order
        System.out.println(hashMap);

        //if key already exits then value corresponding to key is updated.
        hashMap.put("Chine", 180);

        System.out.println(hashMap);

        //Search operation

        if (hashMap.containsKey("Chine")){
            System.out.println("key exists.");
        } else {
            System.out.println("key not exists.");
        }

        //case 1: key exists -> gives value
        //case 2: key not exists -> null
        System.out.println(hashMap.get("Indonesia"));
        System.out.println(hashMap.get("Chine"));

        //returns true of false based on presence of key.
        System.out.println(hashMap.containsKey("Chine"));
        System.out.println(hashMap.containsKey("Pakistan"));

        //iteration in hashMap

        int arr[] = {12, 15, 18};

        //two ways of traversing collections
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        for (int val : arr){
            System.out.print(val+" ");
        }
        System.out.println();

        for (Map.Entry<String, Integer> e: hashMap.entrySet()){
            //e structure here is (key, value)
            System.out.print(e.getKey()+" "+e.getValue());
            System.out.println();
        }
    }
}