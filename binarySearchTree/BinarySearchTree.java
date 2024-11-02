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
        System.out.print(root.data+", ");

        //traverse right subtree
        inorder(root.right);
    }
    public static boolean searchNode(Node root,int key){
        //base case : If root node becomes null then return false
        if(root == null){
            return false;
        }

        //if `key value` is less than root data then search key value in left subtree
        if(root.data > key){
            return searchNode(root.left, key);
        } else if(root.data == key){
            //if key value is found then return true
            return true;
        } else {
            //if `key value` is greater than root data then search key value in right subtree
            return searchNode(root.right, key);
        }
    }
    public static Node deleteNode(Node root, int value){
        //if the value to be deleted is smaller than the root data then value will
        //be deleted  from left subtree
        //we will attach the node that we will get from the left subtree
        if(root.data > value){
            root.left = deleteNode(root.left, value);
        } else if(root.data < value){
            root.right = deleteNode(root.right, value);
        } else { // root.data == value
            //case 1 leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            //case 3 most important case
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }
    public static Node inOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args){
        int[] values = {8,5,3,1,4,6,10,11,14};

        //We have initialized the `root` as null inorder to construct the binary tree from
        //empty tree.
        Node root = null;

        for (int value : values) {
            root = insert(root, value);
        }

        //This below function will return the array in sorted form.
        //By this we can conclude that the BINARY SEARCH TREE is constructed successfully.
        inorder(root);

        System.out.println();

        if(searchNode(root, 3)){
            System.out.println("3 exists.");
        } else {
            System.out.println("3 does not exist.");
        }
        if(searchNode(root, 9)){
            System.out.println("9 exists.");
        } else {
            System.out.println("9 does not exist.");
        }
        //delete 4
        deleteNode(root, 5);
        inorder(root);

    }
}