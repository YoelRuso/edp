public class MiDiccionario {
    private static final int CAPACIDAD_INICIAL = 16;
    private static final double FACTOR_CARGA_MAXIMO = 0.75;

    private EntradaDiccionario[] tabla;
    private int tamanio;

    public MiDiccionario() {
        this.tabla = new EntradaDiccionario[CAPACIDAD_INICIAL];
        this.tamanio = 0;

    }


    public void put(String clave, Object valor) {
        // Asegurar que no exceda el factor de carga
        if ((double) tamanio / tabla.length > FACTOR_CARGA_MAXIMO) {
            rehash();
        }

        int indice = obtenerIndice(clave);

        // Manejar colisiones mediante encadenamiento
        if (tabla[indice] == null) {
            tabla[indice] = new EntradaDiccionario(clave, valor);
            tamanio++;
        } else {
            EntradaDiccionario entradaActual = tabla[indice];
            while (entradaActual.siguiente != null && !entradaActual.clave.equals(clave)) {
                entradaActual = entradaActual.siguiente;
            }

            if (entradaActual.clave.equals(clave)) {
                // Actualizar valor si la clave ya existe
                entradaActual.valor = valor;
            } else {
                // Agregar nueva entrada al final de la cadena
                entradaActual.siguiente = new EntradaDiccionario(clave, valor);
                tamanio++;
            }
        }
    }

    public Object get(String clave) {
        int indice = obtenerIndice(clave);

        if (tabla[indice] != null) {
            EntradaDiccionario entradaActual = tabla[indice];
            while (entradaActual != null) {
                if (entradaActual.clave.equals(clave)) {
                    return entradaActual.valor;
                }
                entradaActual = entradaActual.siguiente;
            }
        }

        return null;  // Clave no encontrada
    }

    private int obtenerIndice(String clave) {
        // Aplicar función de hash simple
        int hashCode = clave.hashCode();
        return (hashCode & 0x7FFFFFFF) % tabla.length;
    }

    private void rehash() {
        int nuevaCapacidad = tabla.length * 2;
        EntradaDiccionario[] nuevaTabla = new EntradaDiccionario[nuevaCapacidad];

        // Reasignar las entradas existentes a la nueva tabla
        for (EntradaDiccionario entrada : tabla) {
            while (entrada != null) {
                int nuevoIndice = obtenerIndice(entrada.clave);
                EntradaDiccionario temp = entrada.siguiente;
                entrada.siguiente = nuevaTabla[nuevoIndice];
                nuevaTabla[nuevoIndice] = entrada;
                entrada = temp;
            }
        }

        tabla = nuevaTabla;
    }

    private static class EntradaDiccionario {
        String clave;
        Object valor;
        EntradaDiccionario siguiente;

        EntradaDiccionario(String clave, Object valor) {
            this.clave = clave;
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public static void main(String[] args) {
        MiDiccionario miDiccionario = new MiDiccionario();
        miDiccionario.put("clave1", "valor1");
        miDiccionario.put("clave2", 42);

        System.out.println(miDiccionario.get("clave1"));  // Imprime: valor1
        System.out.println(miDiccionario.get("clave2"));  // Imprime: 42
        System.out.println(miDiccionario.get("clave3"));  // Imprime: null (clave no encontrada)
    }
}

