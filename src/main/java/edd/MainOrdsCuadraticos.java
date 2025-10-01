import java.util.Scanner;

public class MainOrdsCuadraticos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[][] arreglos = {
            {12, 7, 28, 3, 19},
            {9, 35, 22, 4, 16, 38, 45, 10, 28, 3},
            {27, 14, 8, 35, 17, 41, 24, 6, 11, 33, 48, 22, 39, 13, 31},
            {1, 19, 41, 6, 33, 14, 27, 43, 20, 8, 47, 24, 11, 36, 3, 46, 10, 28, 50, 17},
            {32, 5, 22, 47, 16, 39, 11, 26, 43, 18, 34, 7, 30, 48, 13, 28, 45, 3, 36, 21, 50, 9, 24, 41},
            {37, 5, 22, 47, 16, 39, 11, 26, 43, 18, 34, 7, 30, 48, 13, 28, 45, 3, 36, 21, 50, 9, 24, 41, 2, 15, 38, 12, 27, 44},
            {42, 5, 22, 47, 16, 39, 11, 26, 43, 18, 34, 7, 30, 48, 13, 28, 45, 3, 36, 21, 50, 9, 24, 41, 2, 15, 38, 12, 27, 44, 1, 14, 37, 10, 23},
            {8, 5, 22, 47, 16, 39, 11, 26, 43, 18, 34, 7, 30, 48, 13, 28, 45, 3, 36, 21, 50, 9, 24, 41, 2, 15, 38, 12, 27, 44, 1, 14, 37, 10, 23, 40, 17, 32, 6, 29},
            {8, 5, 22, 47, 16, 39, 11, 26, 43, 18, 34, 7, 30, 48, 13, 28, 45, 3, 36, 21, 50, 9, 24, 41, 2, 15, 38, 12, 27, 44, 1, 14, 37, 10, 23, 40, 17, 32, 6, 29, 46, 19, 33, 4, 31},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        int algoritmo = 0;

        while (algoritmo < 1 || algoritmo > 3) {
            System.out.println("Elige el algoritmo que quieres probar: ");
            System.out.println("1: selectionSort");
            System.out.println("2: bubbleSort");
            System.out.println("3: insertionSort");
            algoritmo = scanner.nextInt();
            if (algoritmo < 1 || algoritmo > 3) {
                System.out.println("Entrada inválida");
            }
        }

        for (int i = 0; i < arreglos.length; i++) {
            System.out.println("\nArreglo A" + (i + 1) + " original: " + OrdenamientosCuadraticos.imprimeArreglo(arreglos[i]));
            OrdenamientosCuadraticos.ordenar(algoritmo, arreglos[i]);
            System.out.println("Arreglo A" + (i + 1) + " ordenado: " + OrdenamientosCuadraticos.imprimeArreglo(arreglos[i]));
            System.out.println("\n");
        }
    }
}
