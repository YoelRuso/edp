public class Main {

    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<String, Integer>("test1", 1);
        Dictionary dict = new Dictionary("test2", 1);
        dict.insert("test2", 2);
        dict.insert("test3", 3);
        dict.insert("test4", 4);
        dict.insert("test4", 5);
        dict.insert("test4", 4);
        dict.insert("test4", 4);
        System.out.println(dict.values());

        System.out.println(dict.toString());
    }
}
