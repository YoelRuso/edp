import src.DictOA;
import src.DictRE;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // TEst
        System.out.println("----------------------");
        DictRE<String, Integer> d = new DictRE<>();
        d.add("Test", 123);
        d.add("Other", 13);
        d.add("dsf", 324);
        d.add("Test", 321);
        d.remove("dsf");
        System.out.println(d.get("Test"));
        System.out.println(d.get("sdsd"));
        System.out.println();
        d.debug();
        System.out.println("Keys: " + d.keys());
        System.out.println("Keys: " + d.values());
        int lastPos = 7;
        int size = 8;
        System.out.println((double) lastPos / size );
        System.out.println("----------------------");
        DictRE<String, Integer> sd = new DictRE<>();
        sd.add("Test", 123);
        sd.add("Other", 13);
        sd.add("dsf", 324);
        sd.add("Test", 321);
        sd.add("asdas", 321);
        sd.add("Teasd", 321);
        sd.add("Testddaddsas", 321);
        sd.add("Testddadd", 321);
        sd.add("Testddaddsasd", 321);
        System.out.println(sd.get("Test"));
        System.out.println(sd.get("sdsd"));
        System.out.println();
        sd.debug();
        System.out.println("Keys: " + sd.keys());
        System.out.println("Keys: " + sd.values());

        int[] a = {1, 4, 1};
        System.out.println(Arrays.toString(a));
        System.out.println(sd);
    }
}
