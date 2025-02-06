package Hashing;
//so this could be asked in interviews that how the hashMap works internally

import java.util.*;

public class HashMapImplementation {
    static class HashMap<K, V>{ //generics
        private class Node{
            K key;
            V value;

            //Node constructor
            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n; //n = no. of nodes
        private int N; //N - no. of buckets
        private LinkedList<Node>[] buckets; // N = hashmap.length

        // HashMap constructor
        @SuppressWarnings("unchecked")
        public HashMap(){
            //initial bucket nodes are 4
            this.N=4;
            this.buckets = new LinkedList[4];

            //initializing each bucket index with an empty linked list
            for (int i=0;i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        //hash function for generating bucket index
        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        //for searching key in our existing bucket of linked list
        private int searchLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];

            for (int i=0;i<ll.size();i++){
                if (ll.get(i).key == key){
                    return i; //di
                }
            }
            return -1; // not found the key
        }

        public void rehash(){
            //storing our existing linked list array into other variable
            LinkedList<Node>[] oldBucket = buckets;

            //increased the bucket size
            buckets = new LinkedList[N*2];

            for (int i=0;i<oldBucket.length;i++){
                LinkedList<Node> ll = oldBucket[i];
                for (int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }

        }

        //insertion operation
        private void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchLL(key, bi); // data index

            if (di == -1){ //if key does not exist
                buckets[bi].add(new Node(key, value));
                n++;
            } else { //if key exist
                Node node = buckets[bi].get(di);
            }

            double lambda = (double)n/N;
            if (lambda>2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            if (di == -1){ //if key does not exist
                return false;
            } else { //if key exist
                return true;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            if (di == -1){ //if key does not exist
                return null;
            } else { //if key exist
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            if (di == -1){ //if key does not exist
                return null;
            } else { //if key exist
                Node node = buckets[bi].get(di);
                n--;
                return node.value;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for (int i=0;i<buckets.length;i++){ // bi
                LinkedList<Node> ll = buckets[i];

                for (int j=0;j<ll.size();j++){ // di
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String[] args){
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("China", 100);
        hashMap.put("Uganda", 1);
        hashMap.put("America", 90);

        ArrayList<String> keys = hashMap.keySet();
        for (int i=0;i<keys.size();i++){
            System.out.print(keys.get(i)+" "+hashMap.get(keys.get(i)));
            System.out.println();
        }

        hashMap.remove("Uganda");
        System.out.println(hashMap.get("Uganda"));

        System.out.println(hashMap.isEmpty());
    }
}