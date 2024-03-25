import src.DictOA;
import src.DictRE;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Crear una instancia de DictRE


        DictRE<String, Integer> dict = new DictRE<>();

        // Añadir elementos
        dict.add("one", 1);
        dict.add("two", 2);
        dict.add("three", 3);
        dict.add("four", 4);
        dict.add("five", 5);

        dict.remove("five");
        dict.popItem();
        // Mostrar el contenido del diccionario
        System.out.println("Contenido del diccionario:");
        System.out.println(dict);

        // Obtener un valor
        System.out.println("Valor asociado a 'three': " + dict.get("three"));

        // Eliminar un elemento
        dict.remove("four");
        System.out.println("Contenido del diccionario después de eliminar 'four':");
        System.out.println(dict);

        // Obtener todas las claves
        System.out.println("Claves del diccionario:");
        System.out.println(dict.keys());

        // Obtener todos los valores
        System.out.println("Valores del diccionario:");
        System.out.println(dict.values());

        // Mostrar información de depuración
        System.out.println("Información de depuración:");
        dict.debug();
        // Crear una instancia de DictRE
        DictRE<String, String> dictionary = new DictRE<>();

        // Agregar elementos al diccionario
        dictionary.add("apple", "red");
        dictionary.add("banana", "yellow");
        dictionary.add("grape", "purple");
        dictionary.add("orange", "orange");
        dictionary.add("strawberry", "red");

        // Mostrar los valores para algunas claves
        System.out.println("Value for apple: " + dictionary.get("apple"));  // Debería imprimir "red"
        System.out.println("Value for banana: " + dictionary.get("banana"));  // Debería imprimir "yellow"
        System.out.println("Value for grape: " + dictionary.get("grape"));  // Debería imprimir "purple"

        // Eliminar un elemento del diccionario
        dictionary.remove("banana");

        // Obtener elementos después de la eliminación
        System.out.println("Value for banana after removal: " + dictionary.get("banana"));  // Debería imprimir "null"

        // Mostrar todas las claves
        System.out.println("Keys: " + dictionary.keys());  // Debería imprimir "[apple, grape, orange, strawberry]"

        // Mostrar todos los valores
        System.out.println("Values: " + dictionary.values());  // Debería imprimir "[red, purple, orange, red]"

        // Agregar un elemento con una clave que tiene el mismo hashcode que una clave existente
        dictionary.add("pear", "green");
        dictionary.add("reap", "yellow");

        // Mostrar los valores para algunas claves
        System.out.println("Value for pear: " + dictionary.get("pear"));  // Debería imprimir "green"
        System.out.println("Value for reap: " + dictionary.get("reap"));  // Debería imprimir "yellow"

        // Mostrar todas las claves
        System.out.println("Keys: " + dictionary.keys());  // Debería imprimir "[apple, grape, orange, strawberry, pear, reap]"
    }
}
