import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Arreglos de diferentes tamaños en millones
        int[] tamanos = {1000000, 2000000, 3000000, 4000000, 5000000};

        for (int tamano : tamanos) {
            System.out.println("Ejecutando para arreglo de tamaño: " + tamano);

            // Generar un arreglo con números aleatorios
            int[] arreglo = new int[tamano];
            Random aleatorio = new Random();
            for (int i = 0; i < tamano; i++) {
                arreglo[i] = aleatorio.nextInt(5000000);  // Genera números aleatorios entre 0 y 5,000,000
            }

            // Crear copias del arreglo para cada algoritmo
            int[] copia1 = arreglo.clone();
            int[] copia2 = arreglo.clone();
            int[] copia3 = arreglo.clone();

            // Medir tiempo de MergeSortIterativo
            long inicio = System.nanoTime();
            MergeSortIterativo.mergeSort(copia1);  // Llamada a MergeSortIterativo
            long fin = System.nanoTime();
            System.out.println("Tiempo MergeSortIterativo para " + tamano / 1000 + " mil: " + (fin - inicio) / 1000000 + " ms");

            // Medir tiempo de Merge3SortiIterativo
            inicio = System.nanoTime();
            Merge3SortiIterativo.merge3Sorti(copia2);  // Llamada a Merge3SortiIterativo
            fin = System.nanoTime();
            System.out.println("Tiempo Merge3SortiIterativo para " + tamano / 1000 + " mil: " + (fin - inicio) / 1000000 + " ms");

            // Medir tiempo de Merge3SortiiIterativo
            inicio = System.nanoTime();
            Merge3SortiiIterativo.merge3Sortii(copia3);  // Llamada a Merge3SortiiIterativo
            fin = System.nanoTime();
            System.out.println("Tiempo Merge3SortiiIterativo para " + tamano / 1000 + " mil: " + (fin - inicio) / 1000000 + " ms");

            System.out.println();  // Línea en blanco entre tamaños de arreglo
        }
    }

}