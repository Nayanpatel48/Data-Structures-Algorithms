/*Always do investigative study*/
package Arrays;

import java.util.Scanner;

public class BinarySearchArray
{
    public static void main(String[] args)
    {
        //pre-requisite:array should be sored in ascending order
        Scanner sc = new Scanner(System.in);
        int sizeOfArray = sc.nextInt();

        int[] array1 = new int[sizeOfArray];

        System.out.println("Enter array elements:");
        for (int i=0;i<sizeOfArray;i++)
            array1[i] = sc.nextInt();

        System.out.println("Enter value to be searched:");
        int keyValue = sc.nextInt();

        if (binarySearch(keyValue, array1))
            System.out.println("Value exists.");
        else
            System.out.println("Value does not exists.");
    }
    public static void selectionSort(int[] array)
    {
        for (int i=0;i<array.length-1;i++)
        {
            int currentMin = array[i];
            int currentMinIndex = i;

            for (int j=i+1;j<array.length;j++)
            {
                if (currentMin>array[j])
                {
                    currentMin=array[j];
                    currentMinIndex=j;
                }
            }

            //if necessary then perform swap operation
            if (currentMinIndex != i)
            {
                int temp = array[currentMinIndex];
                array[currentMinIndex] = array[i];
                array[i]=temp;
            }
        }
        //there is no need to return anything in case of array cause changes
        //are directly made into array
    }
    public static boolean binarySearch(int key, int[] array)
    {
        //first we will sort array
        selectionSort(array);

        int low=0;
        int high=array.length-1;

        while (high>=low)
        {
            int mid = (high+low)/2;
            if (array[mid] == key)
                return true;
            else if (key>array[mid])//value is in upper bound
                high = mid;
            else
                low=mid+1;
        }
        //if value does not exist in an array
        return false;
    }
}