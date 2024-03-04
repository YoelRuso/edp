package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Dict<K, V> {
    private int size = 8;
    private int[] indices;
    private Object[] entries;
    private int lastPos = 0;

    public Dict() {
        indices = new int[size];
        Arrays.fill(indices, -1);
        entries = new Object[size];
    }

    public void add(K key, V value) {
        // TODO: resize
        int pos = hash(key);
        while (indices[pos] != -1) {
            pos++;
        }
        // TODO: CHeck if repeated
        entries[lastPos] = new Pair<K, V>(key, value);

        indices[pos] = lastPos;
        lastPos++;
    }

    public V get(K key) {
        int pos = hash(key);
        if (pos == -1) {
            return null;
        }
        int i = indices[pos];
        Pair<K, V> pair = (Pair<K, V>) entries[i];
        if (pair.getKey() != key) {
            return null;
        }
        return pair.getValue();
    }
    public Collection<K> keys() {
        ArrayList<K> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (entries[i] != null) {
                Pair<K, V> pair = (Pair<K, V>) entries[i];
                list.add(pair.getKey());
            }
        }
        return list;
    }

    public Collection<V> values() {
        ArrayList<V> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (entries[i] != null) {
                Pair<K, V> pair = (Pair<K, V>) entries[i];
                list.add(pair.getValue());
            }
        }
        return list;
    }
    public int hash(K key) {
        return key.hashCode() % size;
    }

    public void debug() {
        System.out.println(Arrays.toString(indices));
        System.out.println("[");
        for (int i = 0; i < size; i++) {
            if (entries[i] == null) {
                System.out.println(i + ": ---");
            } else {
                System.out.println(i + ": " + entries[i].toString()+ ", ");
            }
        }
        System.out.println("]");
    }
}
