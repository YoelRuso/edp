package src;


public class Pair<K, V> {
    private K key;
    private V value;
    private int hashcode;

    public Pair(K key, V value, int hashcode) {
        this.key = key;
        this.value = value;
        this.hashcode = hashcode;
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

    public int getHashcode() {
        return hashcode;
    }

    public void setHashcode(int hashcode) {
        this.hashcode = hashcode;
    }

    @Override
    public String toString() {
        return getKey() + ":" + getValue();
    }

}
