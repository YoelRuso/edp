public class Main {

    public static void main(String[] args) {
        Dictionary dict = new Dictionary("test0", 0);

        System.out.println(dict.isEmpty());
        dict.insert("test1", 1);
        dict.insert("test2", 2);
        dict.insert("test3", 3);
        dict.insert("test4", 4);
        dict.insert("test5", 5);
        dict.insert("test6", 6);
        System.out.println(dict.isEmpty());
        System.out.println(dict.get("test6"));
        System.out.println(dict.values());
        System.out.println(dict.values());
        dict.popItem();
        System.out.println(dict.values());

        System.out.println(dict.toString());
    }
}
