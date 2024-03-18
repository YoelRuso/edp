import test.Dict;
import test.Pair;

import java.util.Arrays;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        // TEst
        System.out.println("----------------------");
        Dict<String, Integer> d = new Dict<>();
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

        Pair<String, Integer>[] pair = new Pair[8];
        pair[3] = new Pair<>("pair3", 1323);
        pair[6] = new Pair<>("pair6", 2323);
        Pair<String, Integer> p = pair[3];
        p = null;

        Pair<String, Integer> o = pair[6];
        o.setValue(0123333);

        // Crear un diccionario
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        // Agregar elementos
        dictionary.add("uno", 1);
        dictionary.add("dos", 2);
        dictionary.add("tres", 3);
        dictionary.add("cuatro", 4);

        // Prueba de get
        System.out.println(dictionary.get("dos")); // Debería imprimir 2
        System.out.println(dictionary.get("cinco")); // Debería imprimir null

        // Prueba de remove
        dictionary.remove("dos");
        System.out.println(dictionary.get("dos")); // Debería imprimir null

        // Prueba de keys
        System.out.println(dictionary.keys()); // Debería imprimir [uno, tres, cuatro]

        // Prueba de values
        System.out.println(dictionary.values()); // Debería imprimir [1, 3, 4]

        // Prueba de isEmpty
        System.out.println(dictionary.isEmpty()); // Debería imprimir false

        // Prueba de popItem
        System.out.println(dictionary.popItem()); // Debería imprimir true
        System.out.println(dictionary.popItem()); // Debería imprimir true
        System.out.println(dictionary.popItem()); // Debería imprimir true
        System.out.println(dictionary.popItem()); // Debería imprimir true
        System.out.println(dictionary.popItem()); // Debería imprimir false

        // Prueba de isEmpty después de popItem
        System.out.println(dictionary.isEmpty()); // Debería imprimir true


        System.out.println(Arrays.toString(pair));
    }
}
