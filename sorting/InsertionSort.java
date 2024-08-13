package sorting;

import java.util.Scanner;

public class InsertionSort
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

        insertionSort(array1);

        System.out.println();
        System.out.println("After sorting:");
        for (int e : array1)
            System.out.print(e+" ");
    }
    public static void insertionSort(int[] array)
    {
        //The insertion sort algorithm sorts a list by repeatedly inserting an
        //elements into sorted list until whole list is sorted

        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}