public class Dictionary<K, V> {

    private K key;
    private V value;

    private Pair<K,V> pair;
    private Pair<K, V>[] listDictionary;

    public Dictionary(K key, V value, Pair[] listDictionary) {
        this.key = key;
        this.value = value;
        this.listDictionary = listDictionary;
    }

    //método para calcular index
    private int calculateIndex(K key) {
        // Función de hash mediante multiplicación
        double A = 0.6180339887; // Constante áurea
        double temp = key.hashCode() * A;
        return (int) Math.floor(listDictionary.length * (temp - Math.floor(temp)));
    }

    //método para insertar
    public boolean insert(Object obj) {
        int index = calculateIndex(key);
        listDictionary[index] = new Pair<K,V>(key, value);
    }


    // Este metodo simplemente elimina el valor especificado por parametro
    public boolean remove(K key) {
        int index = calculateIndex(key);

        while (listDictionary[index] != null && !listDictionary[index].getKey().equals(key)) {
            listDictionary[index] = null;
            index = (index + 1) % listDictionary.length;

        }

    }

    public Object get(Object obj) {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public Object[] values() {
        return null;
    }

    public boolean popItem() {
        return true;
    }



}
