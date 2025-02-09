/**Always do investigative study*/
package Arrays;

import java.util.*;

public class ArrayClass
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int sizeOfArray = sc.nextInt();

        int[] array1 = new int[sizeOfArray];

        System.out.println("Enter array elements:");
        for (int i=0;i<sizeOfArray;i++)
            array1[i] = sc.nextInt();

        System.out.println("Array1 content:");
        for (int e : array1)
            System.out.print(e+" ");

        //the Array class contains various useful methods and common
        //array operations
        System.out.println();
        java.util.Arrays.sort(array1);
        System.out.println("after performing sorting operation from Array class:");
        for (int e : array1)
            System.out.print(e+" ");

        System.out.println();
        String s = java.util.Arrays.toString(array1);
        System.out.println("After converting array1 into string it is :"+s);
        System.out.println("data type of s variable is :"+((Object)s).getClass().getSimpleName());
        //above is the way by which you can check the data type of any variable

        System.out.println("Enter value to be searched using binary search:");
        int key = sc.nextInt();
        System.out.println(key+" exists at index ->"+Arrays.binarySearch(array1,key));

        int[] array2 = {78,89,89};
        if (Arrays.compare(array1, array2)==-1)
            System.out.println("Both are not equal.");
        else
            System.out.println("Both are equal.");
        //this method returns 0 if both are equal otherwise return value less than 0

        System.out.println(Arrays.equals(array2,array1));
        //returns true if both are equal arrays otherwise return false

        int[] array3 ={0,0,0,0,0,0,0,0,0};
        System.out.println("Before using fill:");
        for (int e : array3)
            System.out.print(e+" ");
        System.out.println();
        java.util.Arrays.fill(array3,2,6,88);
        //filling array elements from index 2 to 6 with same value 88
        System.out.println("Before using fill:");
        for (int e : array3)
            System.out.print(e+" ");
        System.out.println();

        System.out.println("Value of array2 object is: "+Arrays.hashCode(array2));

        System.out.println("The first mismatch is found at index ->"+Arrays.mismatch(array2,array1));
        //return first mismatch element in two arrays returns -1 if not found mismatch
    }
}