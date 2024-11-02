package binaryTree;

class BinaryTreePractice{
    //Create a node class
    static class Node1 {
        //stores integer data
        int data;
        Node1 left;
        Node1 right;

        Node1(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
        //this class wll be used to construct a binary tree
        static class BinaryTree1{
            //for keeping track of the current index ib recursion call
            static int idx = -1;

            //default constructor
            BinaryTree1(){}

            //this method will construct the binary tree from given roots and will return
            //root of the binary tree
            public Node1 buildTree(int roots[]){
                //as soon as the `buildTree` method is called it will immediately increase
                //idx by 1
                idx++;

                //check whether the current root element is -1 or not
                if(roots[idx] == -1){
                    return null;
                }
                //if the root element is not -1 then create a new node which will be our
                //root node
                Node1 newNode = new Node1(roots[idx]);

                //now recursively construct left subtree and right subtree
                newNode.left = buildTree(roots);
                newNode.right = buildTree(roots);

                //Now return the root of the binary tree we've just created
                return newNode;
            }
        }
        public static void inOrder(Node1 root){
            if(root == null){
                return;
            }

            //left-root-right

            //recursively print the left subtree of binary tree
            inOrder(root.left);

            //print root data
            System.out.print(root.data+" ");

            //recursively print the right subtree of binary tree
            inOrder(root.right);
        }
    public static void postOrder(Node1 root){
        if(root == null) {
            return;
        }

        //left-right-root

        //recursively print the left subtree of binary tree
        postOrder(root.left);

        //recursively print the right subtree of binary tree
        postOrder(root.right);

        //print root data
        System.out.print(root.data+" ");
    }
    public static void preOrder(Node1 root){
        if(root == null){
            return;
        }

        //root-left-right

        //print root data
        System.out.print(root.data+" ");

        //recursively print the left subtree of binary tree
        preOrder(root.left);

        //recursively print the right subtree of binary tree
        preOrder(root.right);
    }
    public static void main(String[] args){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        //create an instance of BinaryTree
        BinaryTree1 tree = new BinaryTree1();

        //now construct binary tree and get the root element out of it
        Node1 root = tree.buildTree(nodes);

        //printing the root node data
        System.out.println("Root node data is "+root.data);

        //inOrdered call
        System.out.println("The inorder traversal result:");
        inOrder(root);

        //preOrdered call
        System.out.println();
        System.out.println("The preorder traversal result:");
        preOrder(root);

        //inOrdered call
        System.out.println();
        System.out.println("The postorder traversal result:");
        postOrder(root);
    }
}