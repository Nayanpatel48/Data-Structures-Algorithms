package binarySearchTree;

public class BinarySearchTree {
    //This class will be useful for creating new node every time.
    static class Node{
        int data;
        Node left;
        Node right;

        //parameterized constructor.-
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    public static Node insert(Node root, int val){
        //if root is null then create a new node and make it root then return it.
        if(root == null){
            root = new Node(val);
            return root;
        }

        //If value to be inserted is smaller than the root value.
        if(root.data > val){
            //left subtree.
            root.left = insert(root.left, val);
        } else {
            //right subtree.
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        //base case : End of the tree
        if(root == null){
            return;
        }

        //traverse left sub tree
        inorder(root.left);

        //print the data
        System.out.print(root.data+" ");

        //traverse right subtree
        inorder(root.right);
    }
    public static void main(String[] args){
        int[] values = {5,1,3,4,2,7};

        //We have initialized the `root` as null inorder to construct the binary tree from
        //empty tree.
        Node root = null;

        for (int value : values) {
            root = insert(root, value);
        }

        //This below function will return the array in sorted form.
        //By this we can conclude that the BINARY SEARCH TREE is constructed successfully.
        inorder(root);
    }
}