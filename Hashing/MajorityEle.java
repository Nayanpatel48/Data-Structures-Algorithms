package Hashing;

import java.util.*;

public class MajorityEle {
    public static void majorityEle(int[] nums){
        //create hashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        //step 1: inserting {key, value} in hashmap
        for (int i=0;i<len;i++){
            //if key already exists in the map
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            } else { //false
                map.put(nums[i], 1);
            }
        }

        //step 2: finding majority elements
        for (int key : map.keySet()){
            if (map.get(key) > len/3){
                System.out.print(key+" ");
            }
        }
    }
    public static void main(String[] args){ //O(n)
        int[] nums = {1,3,2,5,1,3,1,5,1};
        majorityEle(nums);
    }
}