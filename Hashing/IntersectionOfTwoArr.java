package Hashing;

import java.util.HashSet;

public class IntersectionOfTwoArr {
    public static HashSet<Integer> intersection(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        for (int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        for (int i=0;i<arr2.length;i++){
            if (set.contains(arr2[i])){
                ans.add(arr2[i]);
            }
        }

        return ans;
    }
    public static void main(String[] args){
        int [] arr1 = {1,3,5,7,4,3,2,3};
        int [] arr2 = {3,5,5,3,2};
        System.out.println(intersection(arr1, arr2));
    }
}