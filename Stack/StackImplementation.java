package Stack;

public class StackImplementation
{
    public static void main(String[] args)
    {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        //adds elemement at the top of the stack
        stack.push(1);
        stack.push(2);
        stack.push(67);
        stack.push(89);
        stack.push(67);
        System.out.println(stack);
        //checks whether stack is empty or not
        System.out.println("stack is empty? "+stack.isEmpty());
        //Returns top of the stack
        System.out.println("The top of the stack element is "+stack.peek());
        //Delete(pop) the top of the stack
        System.out.println("After pop operation "+stack.pop()+" is removed.");
        //Returns the position of the specified element in this stack.
        System.out.println("The element 67 is at position "+stack.search(67));
    }
}