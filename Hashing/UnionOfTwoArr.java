package Hashing;

import java.util.HashSet;

public class UnionOfTwoArr {
    public static int union(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();

        for (int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        for (int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }

        return set.size();
    }
    public static void main(String[] args){
        int [] arr1 = {1,3,5,7,4,3,2,3};
        int [] arr2 = {3,5,5,3,2};
        System.out.println(union(arr1, arr2));
    }
}