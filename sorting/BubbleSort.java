package sorting;

import java.util.Scanner;

public class BubbleSort
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
        boolean nextPassNeeded = true;

        for (int i = 1; i < array.length && nextPassNeeded; i++) {
            nextPassNeeded=false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j]>array[j+1]) {
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    nextPassNeeded=true;
                }
            }
        }
    }
}