public class Dictionary<K, V> {

    private inputDictionary[] table;

    public Dictionary() {
    }

    //clase inputDictionary
    private static class inputDictionary {
        String key;
        Object value;
        inputDictionary next;

        inputDictionary(String key, Object value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public boolean insert(Object obj) {
        return true;
    }

    public boolean remove(Object obj) {
        return true;
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
