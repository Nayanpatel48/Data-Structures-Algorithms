/**Always do investigative study*/
package Arrays;

public class FirstSingleDimensionalArray
{
    public static void main(String[] args)
    {
        //in array an array reference variable is used to access the elements of the array
        //once an array is declared it's size is fixed nd can not be changed

        //declaring array variable
        int[] array1;
        //here in int[] we used an integer type here you can use any datatype
        double[] array2;
        //this array can only store the value of type double

        //after declaring an array variable, you can create an array using new operator and assign
        // it is reference to array variable
        array1 = new int[45];
        //here 45 is the size of the array and it is immutable
        System.out.println(array1[0]);//0
        //as we can see initially when an array is created each element contains zero by default

        //we can make above tasks simpler by declaring an array variable, creating an array and assigning it is
        //reference to the array variable in one statement
        int[] array3 = new int[45];
        int array4[]= new int[45];
        //both above declarations are valid
        //here we have created an array of size 45 and assigned it is reference to the array variable array3

        //int[] array4 = new double[56];
        //cause error because we can not assign a double type array reference to the array
        // variable of type integer

        //double[] array4 = new int[23]; not possible in JAVA

        ///////////////////////////////array initializer////////////////////////////////////////////

        double[] array5 = {2.00,23.88,34.999};

        //initializing array with random numbers in between 0 and 100
        int[] array6 = new int[10];

        for (int i=0;i<array6.length;i++)
            array6[i] = (int) (Math.random() * 100);

        //normal for loop
        for (int i=0;i<array6.length;i++)
            System.out.print(array6[i]+" ");
        System.out.println();

        //foreach loop
        for (int e : array6)
            System.out.print(e+" ");
        //this foreach loop allows you to traverse array sequentially without accessing an index variable

        int[] arr1 = {1,2,3};
        System.out.println("Content inside arr1:");
        for (int e : arr1)
            System.out.print(e+" ");
        System.out.println();
        int[] arr2 = arr1;
        //here in above statement arr2 = arr1 we do not copy array ,we copy the reference
        arr2[1] = 3;
        //we have made change in arr2 but this change will also reflect on arr1 since both
        //arrays points to the same array
        System.out.println("After changing arr2 impact on arr1:");
        for (int e : arr1)
            System.out.print(e+" ");
    }
}