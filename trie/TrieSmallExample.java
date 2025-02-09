package trie;

import java.util.*;

public class TrieSmallExample {
    static class Node{
        Node[] children;
        boolean eow; //endOfWord

        public Node(){
            //initialize children array
            children = new Node[26]; //a-z
            Arrays.fill(children, null);

            eow=false;
        }
    }

    //this is a root node
    static Node root = new Node();

    //insert In trie - O(L) L=length of word
    public static void insert(String word){
        for (int i=0;i<word.length();i++){ // O(L) = L is length of word
            int idx = word.charAt(i) - 'a';

            //checking existence of node
            if (root.children[idx] == null){
                //create new node and insert into idx position
                root.children[idx] = new Node();
            }
            //eow = end of word
            if (i == (word.length()-1)){
                root.children[idx].eow=true;
            }

            root=root.children[idx];
        }
    }

    public static void main(String[] args){
        String[] arr  = {"the", "a", "there", "their", "any"};

        //adding each word from arr
        for (int i=0;i<arr.length;i++){
            insert(arr[i]);
        }


    }
}