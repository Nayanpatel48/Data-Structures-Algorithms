//always do investigative study
//link of solution:
//https://www.codewars.com/kata/reviews/57e5598282afa89ed4000086/groups/6729dd4884fcd351ea1507d5
package binaryTree;// 1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1
import java.util.*;
class BinaryTreeCode {

    //our `Node` class will become the fundamental building block of the binary tree.
    //where each `Node` can have atmost 2 childrens `left` & `right`.
    //this inner class represents a single node in binary tree.
    static class Node {
        
        //attributes or properties of `node`
        int data;
        //This attribute holds a reference to the left child of the current node. If there is no left child, it will be null.
        Node left;
        //holdes the reference of the right child if there isn't any then it will be set to null.
        Node right;
        
        //whenever new node is being created initialize it with left and right node as null.
        //The data attribute of the newly created node is set to the value passed to the constructor.
        //parameterized constructor
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree {
        //keep track of current index in input array.
        //its value is shared across all instances of BinaryTree and persists through the recursive calls.
        static int idx = -1;
        
        //Default constructor
        BinaryTree(){
            //empty
        }

        //this is basically a method to construct binary tree.
        //It returns the `root node` of Binary tree which have been constructed.
        public static Node buildTree(int nodes[]){
            idx++;
            
            //-1 indicates end of the sub-tree hence null node is returned.
            if(nodes[idx] == -1){
                return null;
            }
            
            //Instantly  create a new node when it is confirmed that the element of the array is other than -1.
            //create a `newNode` using `Node` class's constructor consisting the current array element.
            //Basically this `newNode` is our root node of the tree. Which we gonna return after creating binary tree.
            //Basically we have created an `instance/object` of `Node` class.
            Node newNode = new Node(nodes[idx]);
            
            //function "buildTree" is called recursively in order to add new nodes to existing node at left and right side of it.
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    
    //pre-order traversal function
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    
    public static void levelorder(Node root){
        if(root == null){
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }
    
    public static int countOfNodes(Node root){
        //base case
        if (root == null) {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }
    public static int sumOfNodes(Node root){
        //base case
        if (root == null) {
            return 0;
        }
        int sumLeft = sumOfNodes(root.left);
        int sumRight = sumOfNodes(root.right);

        return sumLeft + sumRight + root.data;
    }
    public static int height(Node root){

        //base case
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;

        return myHeight;
    }
    //class to store tree information 
    static class TreeInfo{
        //stores the height of sub tree. 
        int ht;

        //stores the diameter of sub tree.
        int diam;

        TreeInfo(int ht, int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }
    public static TreeInfo diameter2(Node root){
        if (root == null) {
            //height and diameter of an empty tree both are -> 0.
            return new TreeInfo(0,0);
        }

        //diameter2 function returns the object consisting of 2 properties which are `height` and 'diameter'.
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myInfo = new TreeInfo(myHeight, myDiam);

        return myInfo;
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        //This statement creates an `instance/object` of binary tree using default constructor.
        BinaryTree tree = new BinaryTree();
        
        //The buildTree method processes the `nodes` array recursively and constructs the binary tree by creating `Node` objects for each value.
        //It then returns the `root node` of the entire tree that has been constructed.
        //The returned root node represents the `topmost node` of the binary tree (the starting point of the tree).
        Node root = tree.buildTree(nodes);
        
        //we have printed the data of root node
        //System.out.println("Root node data is: "+root.data);

        //System.out.println(root.left.data);
        //System.out.println(root.right.data);
        //now entire binary tree is created successfully
        
        //calling preorder traversal by passing root node of tree
        //preorder(root);
        
        //calling inorder traversal by passing root node of tree
        //inorder(root);
        
        //calling postorder traversal by passing root node of tree
        //postorder(root);
        
        //calling levelorder traversal by passing root node of tree
        //levelorder(root);

        //calling countOfNodes
        //System.out.println("Total number of nodes: "+countOfNodes(root));

        //calling sumOfNodes
        //System.out.println("Total sum of nodes: "+sumOfNodes(root));
        
        //calling height() function
        //System.out.println("Height of the tree is: "+height(root));

        //calling diameter function
        System.out.println("Diameter is : "+diameter2(root).diam);
    }
}