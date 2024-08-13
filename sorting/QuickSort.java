package sorting;

import java.util.Scanner;

public class QuickSort
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

        quickSort(array1,0,array1.length-1);

        System.out.println();
        System.out.println("After sorting:");
        for (int e : array1)
            System.out.print(e+" ");
    }
    public static int partition(int[] array, int first, int end)
    {
        int pivot = array[end];
        int i= first-1;
        for (int j=first;j<end;j++)
        {
            if (array[j]<=pivot)
            {
                i++;
                int temp = array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        int temp = array[i+1];
        array[i+1]=array[end];
        array[end]=temp;
        return i+1;
    }
    public static void quickSort(int[] array, int left, int right)
    {
        if (right>left)
        {
            int p = partition(array, left, right);
            quickSort(array,left,p-1);
            quickSort(array, p+1, right);
        }
    }
}