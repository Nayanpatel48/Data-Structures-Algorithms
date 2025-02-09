package stack;

public class StackImplementation {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            next=null;
        }
    }

    //class for creating stack
    static class Stack{
        public static Node head;

        //for checking whether stack is empty or not
        public boolean isEmpty(){
            return head == null;
        }

        //push operation
        public void push(int val){
            //crate new node
            Node newNode = new Node(val);

            //step 1 : check if stack is empty, if true then make this new node our head
            //if false then add it into top of the stack
            if (isEmpty()){
                head=newNode;
            } else {
                newNode.next=head;
                head=newNode;
            }
        }

        //pop operation
        public Node pop(){
            //step 1 : check whether the stack is empty or not. if true then return null
            //else remove & return the top Node
            if (!isEmpty()){
                Node topNode = head;
                head= head.next;
                return topNode;
            }
            return null;
        }

        //peek operation
        public int peek(){
            //step 1 : check whether the stack is empty or not. if true then return -1
            //else return the top Node value
            if (!isEmpty()){
                return head.data;
            }
            return -1;
        }
    }
    public static void main(String[] args){
        Stack s = new Stack();

        s.push(2);
        s.push(4);
        s.push(6);
        s.push(7);

        while (!s.isEmpty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
    }
}