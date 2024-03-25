package src;
// dict remake
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class DictRE<K, V> {
    private int size = 8;
    private int[] indices;
    private Pair<K, V>[] entries;
    private int lastPos = 0;
    private double LOAD_FACTOR = 0.75;

    public DictRE() {
        indices = new int[size];
        Arrays.fill(indices, -1);
        entries = (Pair<K, V>[]) new Pair[size];
    }

    public DictRE(int capacity) {
        indices = new int[(size = capacity)];
        Arrays.fill(indices, -1);
        entries = (Pair<K, V>[]) new Pair[size];
    }
    public void add(K key, V value) {
        System.out.println((double) lastPos / size);
        System.out.println(lastPos);
        System.out.println(size);
        if ((double) lastPos / size >= LOAD_FACTOR) {
            System.out.println("Here----------");
            resize();
        }
        int hashcode = key.hashCode();
        int pos = find(Math.abs(hashcode) % size, key);
        if (indices[pos] != -1) {
            Pair<K, V> pair = entries[indices[pos]];
            pair.setValue(value);
        } else {
            entries[lastPos] = new Pair<>(key, value, hashcode);
            indices[pos] = lastPos;
            lastPos++;
        }
    }
    public V get(K key) {
        int hash = Math.abs(hash(key));
        int pos = find(hash, key);
        if (indices[pos] == -1) {
            return null;
        } else if (indices[pos] < 0) {
            // Ajustar el índice si es negativo
            pos = (pos + indices.length) % indices.length;
        }
        return entries[indices[pos]].getValue();
    }
    public void remove(K key) {
        int pos = find(Math.abs(hash(key)), key);
        if (indices[pos] != -1) {
            entries[indices[pos]] = null;
            indices[pos] = -2;
        }
    }
    // Finds the pos of the
    private int find(int start, K key) {
        // TODO: full circle
        while (indices[start] != -1) {
            if (indices[start] != -2 && entries[indices[start]].getKey().equals(key)) {
                break;
            }
            start++;
            if (start >= size) {
                start = 0;  // Volvemos al principio del arreglo circular
            }
        }
        return start;
    }

    public void resize() {
        int newSize = size * 2;
        // TODO
        // fill holes
        // Save hashcode in Pair (avoids having to recalculate)
        Pair<K, V>[] newEntries = new Pair[newSize];
        int[] newIndices = new int[newSize];
        Arrays.fill(newIndices, -1);
        for (int i = 0; i < size; i++) {
            if (entries[i] != null) {
                newEntries[i] = entries[i];
                Pair<K, V> pair = entries[i];
                int pos = pair.getHashcode() & (newSize - 1);
                while (newIndices[pos % newSize] != -1) {
                    pos++;
                    System.out.println("Before: " + pos % newSize);
                }
                System.out.println("After: " + pos % newSize);
                newIndices[pos % newSize] = i;
            }
        }
        entries = newEntries;
        indices = newIndices;
        size = newSize;
    }

    public int hash(K key) {
        return key.hashCode() % size;
    }

    public Pair<K, V> popItem() {
        // check if last is null
        Pair<K, V> pair = entries[lastPos];
        entries[lastPos] = null;
        return pair;
    }

    public Collection<K> keys() {
        return Arrays.stream(entries).filter(Objects::nonNull).map(Pair::getKey).toList();
    }
    public Collection<V> values() {
        return Arrays.stream(entries).filter(Objects::nonNull).map(Pair::getValue).toList();
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
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (entries[i] != null) {
                str.append(entries[i].toString()).append(", ");
            }
        }
        return "[" + str + "]";
    }
}