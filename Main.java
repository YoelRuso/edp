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
    }
}
