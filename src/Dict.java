package src;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class Dict<K, V> {
    private int size = 8;
    private int[] indices;
    private Pair<K, V>[] entries;
    private int lastPos = 0;
    private double loadFactor = 0.75;

    // TODO: validate
    public Dict() {
        indices = new int[size];
        Arrays.fill(indices, -1);
        entries = (Pair<K, V>[]) new Pair[size];
    }

    public Dict(int capacity) {
        size = closestPowerOfTwo(capacity);
        indices = new int[size];

        Arrays.fill(indices, -1);
        entries = (Pair<K, V>[]) new Pair[size];
    }

    public Dict(int capacity, double loadFactor) {
        size = closestPowerOfTwo(capacity);
        indices = new int[size];

        Arrays.fill(indices, -1);
        entries = (Pair<K, V>[]) new Pair[size];
        this.loadFactor = loadFactor;
    }

    public void add(K key, V value) {
        if ((double) lastPos / size >= loadFactor) {
            resize();
        }

        int hashcode = key.hashCode();
        int pos = findKeyOrEmpty(adjustSize(hashcode), key);

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
        int pos = findKeyOrEmpty(adjustSize(key.hashCode()), key);

        // maybe raise exception like python
        if (indices[pos] == -1) {
            return null;
        }
        return entries[indices[pos]].getValue();
    }
    public void pop(K key) {
        int pos = findKeyOrEmpty(adjustSize(key.hashCode()), key);


        if (indices[pos] != -1) {
            entries[indices[pos]] = null;
            indices[pos] = -2;
        }
    }

    // TODO: check performance over if statement
    private int adjustSize(int value) {
        return value & (size - 1);
    }

    // TODO: check performance
    private int findKeyOrEmpty(int start, K key) {
        while (indices[start] != -1) {
            if (indices[start] != -2  && entries[indices[start]].getKey() == key) {
                break;
            }
            start = adjustSize(++start);
        }
        return start;
    }

    public void resize() {
        int newSize = size << 1;

        Pair<K, V>[] newEntries = new Pair[newSize];
        int[] newIndices = new int[newSize];
        Arrays.fill(newIndices, -1);

        int last = 0;
        for (int i = 0; i < size; i++) {
            if (entries[i] != null) {
                newEntries[last] = entries[i];
                last++;

                Pair<K, V> pair = entries[i];
                int pos = adjustSize(pair.getHashcode());

                while (newIndices[pos] != -1) {
                    pos = adjustSize(++pos);
                }
                newIndices[pos] = i;
            }
        }
        entries = newEntries;
        indices = newIndices;
        size = newSize;
    }

    private int closestPowerOfTwo(int n) {
        int highestBit = Integer.highestOneBit(n);
        return (n == highestBit) ? n : highestBit << 1;
    }

    // TODO: improve popItem
    public Pair<K, V> popitem() {
        // check if last is null
        while (lastPos >= 0 && entries[lastPos] == null) {
            lastPos--;
        }
        if (lastPos < 0) {
            return null;
        }
        Pair<K, V> pair = entries[lastPos];
        int pos = findKeyOrEmpty(adjustSize(pair.getHashcode()), pair.getKey());
        indices[pos] = -2;
        entries[lastPos] = null;
        lastPos++;
        return pair;
    }

    public Collection<K> keys() {
        return Arrays.stream(entries)
                .filter(Objects::nonNull)
                .map(Pair::getKey)
                .collect(Collectors.toList());
    }
    public Collection<V> values() {
        return Arrays
                .stream(entries)
                .filter(Objects::nonNull)
                .map(Pair::getValue)
                .collect(Collectors.toList());
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
        String str = Arrays
                .stream(entries)
                .filter(Objects::nonNull)
                .map(Pair::toString)
                .collect(Collectors.joining(", "));
        return "{" + str + "}";
    }
}