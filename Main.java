public class Main {

    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<String, Integer>("test", 3);
        Dictionary dict = new Dictionary("test1", 1);
        dict.insert("test2", 2);
        dict.remove("test1");
        dict.get("test1");
        System.out.println(dict.get("test2"));
    }
}
