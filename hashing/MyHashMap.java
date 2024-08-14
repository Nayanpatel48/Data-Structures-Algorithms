/*Always do investigative study because it is the best way to learn*/

/*Here we are implementing hashmap**/
package hashing;

import java.util.*;

public class MyHashMap<K, V> implements MyMap<K,V>
{
    //define the hash-table size must be power of 2
    private static int DEFAULT_INITIAL_CAPACITY=4;

    //define the maximum hashtable size 1<<30 is same as 2^30
    private static int MAXIMUM_CAPACITY=1<<30;

    //current hashtable capacity .capacity is of power of 2
    private int capacity;

    //define default load factor
    private static float DEFAULT_LOADFACTOR= 0.75f;

    //specify a load factor used in the hashtable
    private float loadFactorThreshold;

    //the number of entries in the map
    private int size =0;

    //hash table is an array with each cell being a linked list
    //array variable table is declared
    LinkedList<MyMap.Entry<K,V>>[] table;

    //construct a map with a default capacity and load factor
    //no arg constructor
    public MyHashMap()
    {
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_LOADFACTOR);
    }

    //construct a map with specified initial capacity and default load factor
    //constructor
    public MyHashMap(int initialCapacity)
    {
        this(initialCapacity, DEFAULT_LOADFACTOR);
    }

    //define a map with specified initial capacity and load factor
    //constructor
    public MyHashMap(int initialCapacity, float loadFactorThreshold)
    {
        if (initialCapacity>MAXIMUM_CAPACITY)
            this.capacity=MAXIMUM_CAPACITY;
        else
            this.capacity = trimToPowerOf2(initialCapacity);

        this.loadFactorThreshold=loadFactorThreshold;
        table = new LinkedList[capacity];
    }

    //remove all the entries from the map
    @Override
    public void clear()
    {
        size=0;
        removeEntries();
    }

    //remove true if specified key is in the map
    @Override
    public boolean containsKey(K key)
    {
        return get(key) != null;
    }

    //return true if this map contains value
    @Override
    public boolean containsValue(V value)
    {
        for (int i=0;i<capacity;i++)
        {
            if (table[i] != null)
            {
                LinkedList<Entry<K,V>> bucket = table[i];

                //for each loop
                for (Entry<K,V> entry : bucket)
                {
                    if (entry.getValue().equals(value))
                        return true;
                }
            }
        }
        //if value not found
        return false;
    }

    //returns the set of entries in the map
    @Override
    public Set<Map.Entry<K, V>> entrySet()
    {
        //creating empty hashset containing entries
        Set<Map.Entry<K, V>> set = new HashSet<>();

        for (int i=0;i<capacity;i++)
        {
            if (table[i] != null)
            {
                //here if ith table is not empty then we will assign it to
                //newly created linked list called bucket
                LinkedList<Entry<K, V>> bucket = table[i];

                //we will add all the entries from ith table into our empty set
                //created earlier
                set.addAll((Collection<? extends Map.Entry<K, V>>) bucket);
            }
        }
        return set;
    }

    //return the value that matches the specified key
    @Override
    public V get(K key)
    {

    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public Set<K> keySet()
    {
        return Set.of();
    }

    @Override
    public V put(K key, V value)
    {
        return null;
    }

    @Override
    public void remove(K key)
    {

    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public Set<V> values()
    {
        return Set.of();
    }

    //Return power of two for initial capacity
    private int trimToPowerOf2(int initialCapacity)
    {
        int capacity=1;
        while (capacity<initialCapacity)
        {
            capacity <<=1;
            //same as capacity *=2 .<= is more efficient
        }
        return capacity;
    }

    //remove all entries from the bucket
    public void removeEntries()
    {
        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                table[i].clear();
            }
        }
    }
}