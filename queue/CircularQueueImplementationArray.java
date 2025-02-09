package queue;

public class CircularQueueImplementationArray {
    static class Queue{
        static int arr[];
        static int size;
        static int rear=-1;
        static int front=-1;

        public Queue(int size){
            arr=new int[size];
            this.size=size;
        }

        //O(1)
        public static boolean isEmpty(){
            return rear==-1 && front==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size == front;
        }
        //enqueue O(1)
        public static void add(int data){
            //step 1: check whether the queue is empty or not. if empty then add data into it
            //if not then print "queue is full"
            if (isFull()){
                System.out.println("Queue is full.");
                return;
            }

            //step 2:if we are adding the first element in 'empty' queue then we increment the
            //front by 1
            if (front == -1){
                front=0;
            }

            rear=(rear+1)%size;
            arr[rear]=data;
        }

        //dequeue O(1)
        public static int remove(){
            //step 1: check whether the queue is empty or not. if empty then print the message
            //"Queue is empty". if not then return front
            if (isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }

            //if stack is not empty
            int frontEle = arr[front];

            //step 2 : if there is single element in the queue
            if (front == rear){
                rear=front=-1;
            } else {
                front = (front+1)%size;
            }
            return frontEle ;
        }

        //peek O(n)
        public static int peek(){
            //step 1: check whether the queue is empty or not. if true then print message
            //'queue is empty'. if not then return the first element from queue.
            if (isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }

            return arr[front];
        }
    }
    public static void main(String[] args){
        Queue q = new Queue(4);

        Queue.add(9);
        Queue.add(3);
        Queue.add(6);
        Queue.add(0);
        System.out.println(Queue.remove());
        Queue.add(90);
        System.out.println(Queue.remove());
        Queue.add(95);


        while (!Queue.isEmpty()){
            System.out.print(Queue.peek() +" ");
            Queue.remove();
        }
    }
}