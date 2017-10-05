package Hash;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class HashTable {

    class KeyValuePair {

        Object key;

        Object value;

        public KeyValuePair(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private Object[] values;

    private int capacity;

    public HashTable(int capacity) {
        values = new Object[capacity];
        this.capacity = capacity;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void add(Object key, Object value) throws IllegalArgumentException {

        if (key == null || value == null)
            throw new IllegalArgumentException("key or value is null");

        int index = hash(key);

        List<KeyValuePair> list;
        if (values[index] == null) {
            list = new ArrayList<KeyValuePair>();
            values[index] = list;

        } else {
            // collision
            list = (List<KeyValuePair>) values[index];
        }

        list.add(new KeyValuePair(key, value));
    }

    public Object get(Object key) {
        List<KeyValuePair> list = (List<KeyValuePair>) values[hash(key)];
        if (list == null) {
            return null;
        }
        for (KeyValuePair kvp : list) {
            if (kvp.key.equals(key)) {
                return kvp.value;
            }
        }
        return null;
    }

    /**
     * Test
     */
    public static void main(String[] args) {

        HashTable ht = new HashTable(100);

        for (int i = 1; i <= 1000; i++) {
            ht.add("key" + i, "value" + i);
        }

        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            String key = "key" + random.nextInt(1000);
            System.out.println("ht.get(\"" + key + "\") = " + ht.get(key));
        }   
    }
}