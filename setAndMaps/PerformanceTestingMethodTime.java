package setAndMaps;

import java.util.Scanner;

public class PerformanceTestingMethodTime
{
    public static void main(String[] args)
    {
        int[] array1 = new int[99999];

        for (int i=0;i<array1.length;i++)
            array1[i] = (int) (Math.random()*1000);

        System.out.println("Total time taken to sort array is :"+getTestTime(array1)+"ms");
        //Total time taken to sort array is :5692ms
        //this is how you can check efficiency of any data structure or algorithm
        //for your pc
    }
    public static long getTestTime(int[] c)
    {
        //starting time
        long startTime = System.currentTimeMillis();

        selectionSort(c);
        //task execution

        return System.currentTimeMillis()-startTime;
        //return execution time
    }
    public static void selectionSort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            int currentMin = array[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (currentMin > array[j]) {
                    currentMin = array[j];
                    currentMinIndex = j;
                }
            }

            //if necessary then perform swap operation
            if (currentMinIndex != i) {
                int temp = array[currentMinIndex];
                array[currentMinIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}