import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary<K, V> {

    private ArrayList<V> pairArrayList = new ArrayList<>();

    private Pair<K, V>[] listDictionary;

    public Dictionary(K key, V value) {
        this.listDictionary = new Pair[8];
        insert(key, value);
    }

    public Dictionary() {
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
        System.out.println(index);
        while (listDictionary[index] != null) {
            index = (index + 1) % listDictionary.length;
        }
        listDictionary[index] = new Pair<K,V>(key, value);

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
        for (int i = 0; listDictionary.length > i; i++) {
            if (listDictionary[i] != null) {
                return false;
            }
        }
        return true;
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

    public Pair<K, V> popItem() {
        int last = listDictionary.length;
        listDictionary[last - 1] = null;
        return listDictionary[last - 1];
    }

    public void update(K key, V value){
        int index = calculateIndex(key);

        while (listDictionary[index] != null && !listDictionary[index].getKey().equals(key)) {
            index = (index + 1) % listDictionary.length;
        }

        // Comprobamos si el elemento se encuentra dentro del diccionario
        if (listDictionary[index].getKey().equals(key)) {
            // Si está dentro, solo se actualiza el value
            listDictionary[index] = new Pair<>(key, value);
        } else {
            // Si la clave no se encuentra, se añadirá al final del diccionario
            insert(key, value);
        }
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "listDictionary=" + Arrays.toString(listDictionary) +
                '}';
    }
}
