package collections_using_built_in;

import java.util.Stack;

public class StackProgram
{
    public static void main(String[] args)
    {
        //Stack is a subclass of vector class
        Stack<Integer> s1 = new Stack<>();
        s1.push(90);
        s1.push(89);
        s1.push(67);
        s1.push(56);
        System.out.println("Stack content:"+s1);

        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println("After pop operation stack is :"+s1);
    }
}