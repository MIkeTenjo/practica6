/**
 * Clase estática que hace ordenaciones a un arreglo de algún tipo {@code T}.
 * La clase ordena arreglos en un tiempo O(n^2) cuadratica. 
 */
public class OrdenamientosCuadraticos {

    /**
     * Método que recibe un arreglo y dos enteros {@code i}, {@code j} para hacer
     * un cambio los elementos en la posición i y j en el arreglo respectivamente.
     * @param <T> El tipo de elementos que se manejan en el arreglo.
     * @param arreglo El arreglo al cuál le intercambiaremos dos elementos de dos posiciones.
     * @param i La posición del elemento en el arreglo a cuál intercambiar.
     * @param j La posición del elemento en el arreglo a intercambiar con el otro.
     */
    private static <T> void intercambio(T[] arreglo, int i, int j) {
        T temporal = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temporal;
        return;
    }

    /**
     * Método que recibe un arreglo con elementos de tipo {@code T} comparable y dos enteros: {@code i} (que representa
     * la posición inicial del arreglo donde comenzará el método) y {@code j} (que representa la posición final del arreglo
     * donde terminará la función del método).
     * El método compará sus elementos del arreglo hasta encontrar el elemento minímo de todo el arreglo.
     * Regresa el elemento menor contenido en el arreglo.
     * @param <T> El tipo de los elementos del arreglo (de tipo comparable.)
     * @param arreglo El arreglo en el cuál se encontrará el minímo valor.
     * @param i La posición inicial del arreglo de donde empezar a hacer el método.
     * @param j La posición final del arreglo en donde terminará el método.
     * @return
     */
    private static <T extends Comparable<T>> int encontrarIndiceMenor(T[] arreglo, int i, int j){
        int indMnor = i;
        for (int k = i; k < j; k++) {
            if (arreglo[indMnor].compareTo(arreglo[k]) > 0) {
                indMnor = k;
            }
        }
        return indMnor;
    }  

    /**
     * Ordena un arreglo genérico utilizando el algoritmo Selection Sort.
     * 
     * <p>Selection Sort recorre el arreglo, encuentra el elemento mínimo en la parte
     * no ordenada y lo coloca en la posición correspondiente.</p>
     *
     * @param <T> el tipo de los elementos del arreglo, debe implementar Comparable
     * @param arreglo el arreglo que se ordenará en orden ascendente
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            int min = encontrarIndiceMenor(arreglo, i, arreglo.length);
            intercambio(arreglo, i, min);
        }
        return;
    }

    /**
     * Ordena un arreglo genérico utilizando el algoritmo Bubble Sort.
     * 
     * <p>Bubble Sort compara pares de elementos adyacentes y los intercambia si están
     * en el orden incorrecto, haciendo que los valores más grandes "floten" hacia el final.</p>
     *
     * @param <T> el tipo de los elementos del arreglo, debe implementar Comparable
     * @param arreglo el arreglo que se ordenará en orden ascendente
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j].compareTo(arreglo[j + 1]) > 0) {
                    intercambio(arreglo, j, j + 1);
                }
            }
        }
        return;
    }

    /**
     * Ordena un arreglo genérico utilizando el algoritmo Insertion Sort.
     * 
     * <p>Insertion Sort construye una lista ordenada de izquierda a derecha,
     * insertando cada nuevo elemento en la posición correcta dentro de la parte ya ordenada.</p>
     *
     * @param <T> el tipo de los elementos del arreglo, debe implementar Comparable
     * @param arreglo el arreglo que se ordenará en orden ascendente
     */
    public static <T extends Comparable<T>> void insertionSort(T[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            T aInsertar = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j].compareTo(aInsertar) > 0) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = aInsertar;
        }
        return;
    }


    /**
     * Método que recibe un arreglo de tipo {@code T} y un entero del 1 al 3
     * el cuál representa el tipo de ordenación a realizar a su arreglo.
     * Opción 1: Selection Sort.
     * Opción 2: Bubble Sort.
     * Opción 3: Insertion Sort.
     * El método lanza un error si no se seleccionna una de estas opciones. De otra manera,
     * se hace la función de  ordenamiento al arreglo.
     * @param <T> El tipo de los elementos del arreglo.
     * @param algoritmo  La opción del algoritmo a utilizar para ordenar el arreglo.
     * @param arreglo El arreglo a ordenar.
     */
    public static <T extends Comparable<T>> void ordenar(int algoritmo, T[] arreglo) {
        switch (algoritmo) {
            case 1:
                selectionSort(arreglo);
                break;
            case 2:
                bubbleSort(arreglo);
                break;
            case 3:
                insertionSort(arreglo);
                break;
            default:
                System.out.println("Opción de ordenamiento no válida.");
        }
    }

    /**
     * Método que crea una concatenación en cadena de un arreglo de tipo {@code T}.
     * El método devuelve una concatenación en cadena de los elementos del arreglo.
     * @param <T> El tipo de los elementos del arreglo.
     * @param arreglo El arreglo a obtener sus elementos concatenados en una cadena.
     * @return La cadena de elementos contadenados del arreglo.
     */
    public static <T> String imprimeArreglo(T[] arreglo) {
        String s = "{";
        for (int i = 0; i < arreglo.length; i++) {
            if (i == arreglo.length - 1) {
                s = s + arreglo[i];
            } else {
                s = s + arreglo[i] + ",";
            }
        }
        s = s + "}";
        return s;
    }
}
