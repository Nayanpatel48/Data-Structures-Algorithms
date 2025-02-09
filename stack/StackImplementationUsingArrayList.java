package stack;

import java.util.*;

public class StackImplementationUsingArrayList {
    static class Stack{
        //we are using it to create stack
        public static ArrayList<Integer> list = new ArrayList<>();

        public Stack(){}

        public static boolean isEmpty(){
            return list.isEmpty();
        }

        //push operation
        public static void push(int data){
            list.add(data);
        }

        //pop operation
        public static int pop(){
            return list.removeLast();
        }

        //peek operation
        public static int peek(){
            return list.getLast();
        }
    }
    public static void main(String[] args){
        Stack s = new Stack();

        s.push(2);
        s.push(0);
        s.push(6);
        s.push(7);

        while (!s.isEmpty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
    }
}