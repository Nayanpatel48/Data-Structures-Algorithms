/**Always do investigative study because it is the best*/
package hashing;

public class MyMapNotes
{
    public static void main(String[] args)
    {
        //Hashing can be used to implement the map.
        //This map will takes O(1) time to delete, insert ,
        // search element
        //a map is also called as dictionary.

        //collision= It is the event which occurs when two or more keys refers
        // to the same value

        ////////////////////////Hash functions & Hash codes////////////////////////

        //Hash function & Hash code = A typical hash function first converts the
        //search key value into an integer called hash code , then compresses the
        //hashcode into an index to hash table.

        /////////////////////Compressing hash codes////////////////////////////////

        //sometimes hash codes which are integer values, they become so large.
        //they need to be compressed in order to fit into 0 to n-1 index range.
        //so common way to compress them so that they can fit somewhere in between
        //0 to n-1 is -> "h(hashcode) = hashcode % n"
        //ideally you should choose prime number for n greater than 2
        //it is good decision to take value n = power of 2

        //The complete hash function is defined as:
        //h(hashCode) = supplementalHash(hashCode) % N

        ///////////////////Handling collisions using open addressing//////////////////

        //open addressing = It is a process of finding the open location in the hash
        //table in the event of collision.

        //open hashing has several variations: linear probing, quadratic probing and
        //double hashing

        //Linear probing= In linear probing during insertion when collision occurs
        //the linear probing finds the open location sequentially.
        //if a collision occurs at hashTable[k %
        //N], check whether hashTable[(k+1) % N] is available. If not, check
        // hashTable[(k+2)% N] and so on, until an available cell is found,

        //When probing reaches the end of the table, it goes back to the beginning
        // of the table. Thus, the hash table is treated as if it were circular.

        //Each cell in the hash table has three possible states: occupied, marked,
        // or empty. Note that a marked cell is also available for insertion.

        //cluster = Linear probing tends to cause groups of consecutive cells in the hash table
        //to be occupied. Each group is called a cluster.

        //disadvantage = Each cluster is actually a probe sequence that you must search
        //when retrieving, adding, or removing an entry. As clusters grow in size, they
        // may merge into even larger clusters, further slowing down the search time.
        // This is a big disadvantage of linear probing.

        //Quadratic probing = this works same as linear probing accept it has
        // its own way of searching. It will solve the linear probing clustering.
        //but it has its own disadvantage called secondary clustering.
        //secondary clustering = the entries that collide with an
        //occupied entry use the same probe sequence.

        //double hashing Suppose the elements with the keys 45, 58, 4, 28, and
        // 21 are already placed in the hash table. We now insert the element with
        // key 12. The probe sequence for key 12 starts at index 1. Since
        //the cell at index 1 is already occupied, search the next cell at
        // index 3 (1 + 1 * 2). Since the cell at index 3 is already occupied,
        // search the next cell at index 5 (1 + 2 * 2). Since the
        //cell at index 5 is empty, the element for key 12 is now inserted at this cell.

        ///////////////////Handling collisions using separate chaining//////////////////

        //The separate chaining scheme places all entries with the same hash index in
        // the same location, rather than finding new locations. Each location in the
        // separate chaining scheme uses a bucket to hold multiple entries.

        //You can implement a bucket using an array, ArrayList, or LinkedList.

        //Load factor and rehashing = The load factor measures how full the hashtable
        //is. If load factor is exceed its limit then size of hashtable will be
        //increased and all the entries from previous table will be loaded into
        //new large table is called rehashing.

        //If you use an ArrayList and store a new entry at
        //the end of the list, the search time will be O(n). If you implement MyHashMap
        // using a binary tree, the search time will be O(log n) if the tree is
        // well-balanced. Nevertheless, you can implement MyHashMap using hashing
        // to obtain an O(1) time search algorithm.
    }
}