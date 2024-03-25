import java.util.Objects;

public class Pair<K, V> {
    private K key;
    private V value;
    private int hash;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = hash;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return this.value;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
}
