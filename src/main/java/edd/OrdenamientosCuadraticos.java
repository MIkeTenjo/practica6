public class OrdenamientosCuadraticos {

    private static <T> void intercambio(T[] arreglo, int i, int j) {
        T temporal = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temporal;
        return;
    }

    private static <T extends Comparable<T>> int encontrarIndiceMenor(T[] arreglo, int i, int j){
        int indMnor = i;
        for (int k = i; k < j; k++) {
            if (arreglo[indMnor].compareTo(arreglo[k]) > 0) {
                indMnor = k;
            }
        }
        return indMnor;
    }  

    public static <T extends Comparable<T>> void selectionSort(T[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            int min = encontrarIndiceMenor(arreglo, i, arreglo.length);
            intercambio(arreglo, i, min);
        }
        return;
    }

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

    public static <T extends Comparable<T>> void insertionSort(T[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            T aInsertar = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j].compareTo(aInsertar) > 0) {
                arreglo[ j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = aInsertar;
        }
        return;
    }

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
