import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary<K, V> {

    private K key;
    private V value;
    private ArrayList<V> pairArrayList = new ArrayList<>();

    private Pair<K, V>[] listDictionary;

    public Dictionary(K key, V value) {
        this.key = key;
        this.value = value;
        this.listDictionary = new Pair[8];
    }

    //método para calcular index
   private int calculateIndex(K key) {
        // Implementación de la función hash
        return Math.abs(key.hashCode()) % listDictionary.length;
    }

    //método para insertar
    public boolean insert(K key, V value) {
        int index = calculateIndex(key);
        while (listDictionary[index] != null) {
            listDictionary[index] = new Pair<K,V>(key, value);
            index = (index + 1) % listDictionary.length;
        }
        return true;
    }


    // Este metodo simplemente elimina el valor especificado por parametro
    public boolean remove(K key) {
        int index = calculateIndex(key);

        while (listDictionary[index] != null && !listDictionary[index].getKey().equals(key)) {
            listDictionary[index] = null;
            index = (index + 1) % listDictionary.length;


        }
        return true;
    }

    public V get(K key) {
        int index = calculateIndex(key);

        while (listDictionary[index] != null && !listDictionary[index].getKey().equals(key)) {
            if (listDictionary[index] == null) {
                System.out.println("Valor no encontrado");
                break;
            }
            index = (index + 1) % listDictionary.length;

        }
        return listDictionary[index].getValue();
    }

    public boolean isEmpty() {
        return listDictionary == null;
    }

    public ArrayList<V> values() {
        pairArrayList.clear(); // Clear the list to avoid duplicates on subsequent calls.
        for (Pair<K, V> pair : listDictionary) {
            if (pair != null) {
                pairArrayList.add(pair.getValue());
            }
        }
        return pairArrayList;
    }

    public boolean popItem() {
        return true;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "listDictionary=" + Arrays.toString(listDictionary) +
                '}';
    }
}
