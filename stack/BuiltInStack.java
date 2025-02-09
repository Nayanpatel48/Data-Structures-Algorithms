package stack;

import java.util.*;

public class BuiltInStack {
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(89);
        s.push(69);
        s.push(39);
        s.push(49);

        while (!s.isEmpty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
    }
}