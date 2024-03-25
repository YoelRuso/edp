import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Dictionary<K, V> {
    private int size = 8;
    private int[] indices;
    private Object[] entries;
    private int lastPos = 0;

    public Dictionary() {
        indices = new int[size];
        Arrays.fill(indices, -1);
        entries = new Object[size];
    }

    public Dictionary(K key, V value) {
        this(); // Llama al constructor sin argumentos para inicializar el diccionario
        add(key, value);
    }


    public void add(K key, V value) {
        // TODO: resize
        int pos = hash(key);
        while (indices[pos] != -1) {
            // Check if repeated
            if (indices[pos] != -2) {
                Pair<K, V> pair = (Pair<K, V>) entries[indices[pos]];
                if (pair.getKey() == key) {
                    pair.setValue(value);
                    return;
                }
            }
            pos++;
        }
        // TODO: CHeck if repeated
        entries[lastPos] = new Pair<>(key, value);

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

    public void remove(K key) {
        int pos = hash(key);
        while (indices[pos] != -1 && pos < size) {
            if (indices[pos] != -2) {
                Pair<K, V> pair = (Pair<K, V>) entries[indices[pos]];
                if (pair.getKey() == key) {
                    entries[indices[pos]] = null;
                    indices[pos] = -2;
                    return;

                }
            }
            pos++;
        }
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (int i = 0; i < size; i++) {
            if (entries[i] != null) {
                Pair<K, V> pair = (Pair<K, V>) entries[i];
                if (!first) {
                    sb.append(", ");
                }
                sb.append(pair.getKey()).append(": ").append(pair.getValue());
                first = false;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (indices[i] != -1 && indices[i] != -2) {
                return false;
            }
        }
        return true;
    }

    public boolean popItem() {
        for (int i = size - 1; i >= 0; i--) {
            if (indices[i] != -1 && indices[i] != -2) {
                entries[indices[i]] = null;
                indices[i] = -2;
                return true;
            }
        }
        return false; // No hay elementos para sacar
    }

}
