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
        s1.peek();
        s1.isEmpty();
        s1.search(59);
        s1.contains("");
        s1.addFirst(90);
        s1.addLast(90);
        s1.elementAt(2);
        s1.get(3);;
        s1.getFirst();
        s1.getLast();
        s1.indexOf(9);
        s1.remove(2);//pass index
        s1.lastIndexOf(2);//element pass
        s1.firstElement();
        s1.removeLast();
        s1.removeFirst();
        s1.insertElementAt(8,0);

        System.out.println("Stack content:"+s1);

        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println("After pop operation stack is :"+s1);
    }
}