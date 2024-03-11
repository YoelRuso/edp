import test.Dict;

public class Main {

    public static void main(String[] args) {
        Dictionary dict = new Dictionary("test0", 0);

        System.out.println(dict.isEmpty());
        dict.insert("test1", "1");
        System.out.println(dict.values());
        dict.insert("test2", 2);
        System.out.println(dict.values());
        dict.insert("test3", 3);
        System.out.println(dict.values());
        dict.insert("test4", 4);
        System.out.println(dict.values());
        dict.insert("test5", 5);
        System.out.println(dict.values());
        dict.insert("test6", 6);
        System.out.println(dict.values());
        dict.insert("test7", 7);
        System.out.println(dict.values());
        dict.insert("test8", 8);
        dict.remove("test3");
        System.out.println(dict.values());
        System.out.println(dict.isEmpty());
        System.out.println(dict.get("test6"));
        dict.update("test1", 3);
        System.out.println(dict.values());
        dict.popItem();
        System.out.println(dict.values());

        System.out.println(dict);

        // TEst
        System.out.println("----------------------");
        Dict<String, Integer> d = new Dict<>();
        d.add("Test", 123);
        d.add("Other", 13);
        d.add("dsf", 324);
        d.add("Test", 321);

        System.out.println(d.get("Test"));
        System.out.println(d.get("sdsd"));
        System.out.println();
        d.debug();
        System.out.println("Keys: " + d.keys());
        System.out.println("Keys: " + d.values());
    }
}
