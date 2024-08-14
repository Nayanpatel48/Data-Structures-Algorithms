/**Always do investigative study because it is the best way to learn*/
package hashing;

import java.util.Map;
import java.util.Set;

public interface MyMap<K, V>
{
    //remove all the entries from the map
    public void clear();

    //return true if the specified key exist in the map
    public boolean containsKey(K key);

    //returns true if this map contains the specified value
    public boolean containsValue(V value);

    //returns the set of entries in the map
    public Set<Map.Entry<K,V>> entrySet();

    //returns the value which matches the specified key
    public V get(K key);

    //return true if this map doesn't contain any entries
    public boolean isEmpty();

    //returns the set of all keys exist in the map
    public Set<K> keySet();

    //add an entry (key, value) in the map
    public V put(K key, V value);

    //remove an entry for the specified key
    public void remove(K key);

    //return the number of mapping in this map
    public int size();

    //return the set of values in the list
    public Set<V> values();

    //define an inner class for Entry
    public static class Entry<K, V>
    {
        K key;
        V value;

        //parameterized constructor
        public Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
        public K getKey()
        {
            return key;
        }
        public V getValue()
        {
            return value;
        }
        @Override
        public String toString()
        {
            return "["+key+" , "+value+"]";
        }
    }
}