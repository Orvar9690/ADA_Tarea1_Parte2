public class Merge3SortiIterativo {
    public static void merge3Sorti(int[] array) {
        int n = array.length;
        int[] temp = new int[n];

        for (int size = 1; size < n; size = 3 * size) {
            for (int leftStart = 0; leftStart < n; leftStart += 3 * size) {
                int mid1 = Math.min(leftStart + size, n);
                int mid2 = Math.min(leftStart + 2 * size, n);
                int rightEnd = Math.min(leftStart + 3 * size, n);
                merge(array, temp, leftStart, mid1, mid2, rightEnd);
            }
        }
    }

    // Mezclar tres subarreglos
    private static void merge(int[] array, int[] temp, int leftStart, int mid1, int mid2, int rightEnd) {
        int i = leftStart, j = mid1, k = mid2, m = leftStart;

        while (i < mid1 && j < mid2 && k < rightEnd) {
            if (array[i] <= array[j] && array[i] <= array[k]) {
                temp[m++] = array[i++];
            } else if (array[j] <= array[i] && array[j] <= array[k]) {
                temp[m++] = array[j++];
            } else {
                temp[m++] = array[k++];
            }
        }

        // Mezcla los elementos restantes entre los tres subarreglos
        while (i < mid1 && j < mid2) {
            temp[m++] = (array[i] <= array[j]) ? array[i++] : array[j++];
        }
        while (j < mid2 && k < rightEnd) {
            temp[m++] = (array[j] <= array[k]) ? array[j++] : array[k++];
        }
        while (i < mid1 && k < rightEnd) {
            temp[m++] = (array[i] <= array[k]) ? array[i++] : array[k++];
        }

        while (i < mid1) {
            temp[m++] = array[i++];
        }
        while (j < mid2) {
            temp[m++] = array[j++];
        }
        while (k < rightEnd) {
            temp[m++] = array[k++];
        }

        // Copiar de vuelta el arreglo mezclado
        System.arraycopy(temp, leftStart, array, leftStart, rightEnd - leftStart);
    }

}