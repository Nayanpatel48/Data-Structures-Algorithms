/**Always do investigative study because it is best*/
package multiDimensionalArrays;

public class TwoDimensionalArray
{
    public static void main(String[] args)
    {
        //Data in matrix or table is represented using multidimensional array
        int[][] array1;
        //two ,dimensional array declared
        //int array2[][];
        //this way is also allowed but not preferred

        array1 = new int[5][5];
        //5*5 matrix created

        //in this case it is okay to use array1.length cause same rows
        //and columns
        for (int i = 0; i < array1.length; i++)//rows
        {
            for (int j = 0; j < array1.length; j++)//columns
            {
                //filling up the array with numbers between 0 and 100
                array1[i][j]= (int) (Math.random()*100);
                System.out.print(array1[i][j]+" ");
            }
            System.out.println();
        }
        //Obtaining the length of two ,dimensional array
        int[][] array3 = {{1,2,3,4,5},
                {1,2,3,4},
                {1,2,3},
                {1,2},
                {1}};
        System.out.println("1st row length:"+array3[0].length);
        System.out.println("2nd row length:"+array3[1].length);
        System.out.println("3rd row length:"+array3[2].length);
        System.out.println("4th row length:"+array3[3].length);
        System.out.println("5th row length:"+array3[4].length);

        //passing two, dimensional array to the methods is same that in single,
        //dimensional array
        //multi, dimensional array
        int[][][] array4 = new int[5][6][7];

    }
}