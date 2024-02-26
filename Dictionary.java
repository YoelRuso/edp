import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary<K, V> {

    private ArrayList<V> pairArrayList = new ArrayList<>();

    private Pair<K, V>[] listDictionary;

    private int empty_index = 0;

    public Dictionary(K key, V value) {
        this.listDictionary = new Pair[10];
        insert(key, value);
    }

    public Dictionary() {
        this.listDictionary = new Pair[8];
    }

    // Calcula el índice para una key que será añadida
    /*
    private int calculateIndex(K key) {
        // Implementación de la función hash
        // int hash = Math.abs(key.hashCode());
        int index = 0;
        while (listDictionary[index] != null) {
            if(listDictionary[index].getKey() == key){
                break;
            }
            index += 1;
        }
        return index;
    }
    */


    // Encuentra el índice de una key que ya existe
    private int findIndex(K key){
        boolean found = false;
        int index = -1;
        for(int i = 0; i < listDictionary.length && !found; i++){
            if(listDictionary[i].getKey() == key){
                found = true;
                index = i;
            }
        }
        return index;
    }

    //método para insertar
    public boolean insert(K key, V value) {
        listDictionary[empty_index] = new Pair<K,V>(key, value);
        empty_index++;
        return true;
    }


    // Este metodo simplemente elimina el valor especificado por parametro
    public boolean remove(K key) {
        int index = findIndex(key);
        System.out.println(index);
        listDictionary[index] = null;
        if(index < listDictionary.length-1){
            for (int i = index; i < listDictionary.length-1; i++){
                listDictionary[i] = listDictionary[i+1];
            }
            listDictionary[listDictionary.length-1] = null;
        }
        empty_index--;
        return true;
    }

    public V get(K key) {
        int index = findIndex(key);
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

    // ¿Se podía usar el arrayList o no?
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
        listDictionary[empty_index-1] = null;
        empty_index--;
        return listDictionary[empty_index-1];
    }

    public void update(K key, V value){
        int index = findIndex(key);

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
