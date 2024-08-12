/**Always do investigative study*/
package singleDimensionalArrays;

public class VariableLengthArgumentList
{
    public static void main(String[] args)
    {
        //a variable number of arguments of same type can be passed to the method and can be treated
        //as an array
        System.out.println(calSum(1,2,3,4,5,7,8,9));
        //here as you can see all the elements are of integer type hence they are considered as a array

        //System.out.println(calSum(1,2,3,"flower",4,5,7,8,9));
        // causes error

        System.out.println(calSum(1,2,3,'z',4,5,7,8,9));
        //here 'z' is converted to it's corresponding ASCII value hence it is considered as integer value here

        //System.out.println(calSum(1,2,3,z,4,5,7,8,9));
        // causes error

        //System.out.println(calSum(1,2,3,78.90,4,5,7,8,9));
        //causes error cause all arguments should be of same type
    }
    public static int calSum(int... numbers)
    {
        int sum = 0;
        for (int e : numbers)
            sum+=e;
        return sum;
    }
}