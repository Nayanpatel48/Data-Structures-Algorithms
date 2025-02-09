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
        Node curr = root;

        for (int i=0;i<word.length();i++){ // O(L) = L is length of word
            int idx = word.charAt(i) - 'a';

            //checking existence of node
            if (curr.children[idx] == null){
                //create new node and insert into idx position
                curr.children[idx] = new Node();
            }
            //eow = end of word
            if (i == (word.length()-1)){
                curr.children[idx].eow=true;
            }

            curr=curr.children[idx];
        }
    }

    //search word in trie - O(L) L = word length
    public static boolean searchWord(String word){
        Node curr = root;
        for (int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            Node node = curr.children[idx];

            if (node == null){ // character does not exist
                return false;
            }

            if (!node.eow && i == (word.length()-1)){ // if the last character is not end of word
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }
    public static void main(String[] args){
        String[] arr  = {"the", "a", "there", "their", "any"};

        //adding each word from arr
        for (String s : arr) {
            insert(s);
        }

        System.out.println((searchWord("the")) ? "Word exists" : "Word not exists");
        System.out.println((searchWord("thee")) ? "Word exists" : "Word not exists");


    }
}