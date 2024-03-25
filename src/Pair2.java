package src;


public class Pair2<K, V> {
    private K key;
    private V value;

    public Pair2(K key, V value) {
        this.key = key;
        this.value = value;
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

    @Override
    public String toString() {
        return getKey() + ":" + getValue();
    }

}
