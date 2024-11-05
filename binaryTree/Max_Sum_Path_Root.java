package binaryTree;

//link of solution:
//https://www.codewars.com/kata/reviews/57e5598282afa89ed4000086/groups/6729dd4884fcd351ea1507d5
public class Max_Sum_Path_Root {
    static class Node1 {

        //attributes or properties of `node`
        int data;
        //This attribute holds a reference to the left child of the current node. If there is no left child, it will be null.
        Node1 left;
        //holdes the reference of the right child if there isn't any then it will be set to null.
        Node1 right;

        //whenever new node is being created initialize it with left and right node as null.
        //The data attribute of the newly created node is set to the value passed to the constructor.
        //parameterized constructor
        Node1(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree1 {
        //keep track of current index in input array.
        //its value is shared across all instances of BinaryTree and persists through the recursive calls.
        static int idx = -1;

        //Default constructor
        BinaryTree1(){
            //empty
        }
        //this is basically a method to construct binary tree.
        //It returns the `root node` of Binary tree which have been constructed.
        public static Node1 buildTree(int nodes[]){
            idx++;

            //-1 indicates end of the sub-tree hence null node is returned.
            if(nodes[idx] == -1){
                return null;
            }

            //Instantly  create a new node when it is confirmed that the element of the array is other than -1.
            //create a `newNode` using `Node` class's constructor consisting the current array element.
            //Basically this `newNode` is our root node of the tree. Which we gonna return after creating binary tree.
            //Basically we have created an `instance/object` of `Node` class.
            Node1 newNode = new Node1(nodes[idx]);

            //function "buildTree" is called recursively in order to add new nodes to existing node at left and right side of it.
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    public static void inorder(Node1 root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static int maxSum(Node1 root) {
        if(root == null){
            return 0;
        }
        int leftsum = maxSum(root.left);
        int rightsum = maxSum(root.right);
        if(root.left != null && root.right == null){
            return leftsum+root.data;
        }
        if(root.left == null && root.right != null){
            return rightsum+root.data;
        }
        int mysum = Math.max(leftsum+root.data, rightsum+root.data);
        return mysum;
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        //This statement creates an `instance/object` of binary tree using default constructor.
        BinaryTree1 tree = new BinaryTree1();
        Node1 root = tree.buildTree(nodes);
        inorder(root);
        System.out.println("Maximum sum is as below:");
        System.out.println(maxSum(root));
    }
}