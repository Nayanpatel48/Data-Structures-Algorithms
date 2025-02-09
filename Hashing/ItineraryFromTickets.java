package Hashing;

import java.util.*;

public class ItineraryFromTickets {
    public static void path(HashMap<String, String> map){
        HashMap<String, String> revMap = new HashMap<>();
        String start = "";

        //step 1 : reversing the map to revMap
        for (String keys : map.keySet()){
            revMap.put(map.get(keys), keys);
        }

        //step 2 : check for starting point
        for (String keys : map.keySet()){
            if (!revMap.containsKey(keys)){
//                System.out.println("Starting point is "+keys);
                start=keys;
                break;
            }
        }

        //step 3 : print path(itinerary)
        while (map.containsKey(start)){
            System.out.print(start+"->");
            start=map.get(start);
        }
        System.out.print(start);

//        System.out.println(start);
//        System.out.println(revMap);
    }
    public static void main(String[] args){
        HashMap<String, String> map = new HashMap<>();

        map.put("Chennai","Bengaluru");
        map.put("Mumbai","Delhi");
        map.put("Goa","Chennai");
        map.put("Delhi","Goa");

        path(map);
    }
}