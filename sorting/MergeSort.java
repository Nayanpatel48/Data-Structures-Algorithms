/**Always do investigative study because it is best and read documentation*/
package sorting;

import java.util.Scanner;

public class MergeSort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int arraySize = sc.nextInt();

        int[] array1 = new int[arraySize];
        System.out.println("Enter array elements:");
        for (int i=0;i<arraySize;i++)
            array1[i] = sc.nextInt();

        System.out.println("Before sorting:");
        for (int e : array1)
            System.out.print(e+" ");

        mergeSort(array1);

        System.out.println();
        System.out.println("After sorting:");
        for (int e : array1)
            System.out.print(e+" ");
    }
    public static void mergeSort(int[] array)
    {

    }
}