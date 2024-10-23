/*Always do investigative study*/
package sorting;
import java.util.Scanner;

public class SelectionSort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int sizeOfArray = sc.nextInt();

        int[] array1 = new int[sizeOfArray];

        System.out.println("Enter array elements:");
        for (int i=0;i<sizeOfArray;i++)
            array1[i] = sc.nextInt();

        selectionSort(array1);
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
        printArray(array);
    }
    public static void printArray(int[] array)
    {
        for (int e : array)
            System.out.print(e+" ");
    }
}