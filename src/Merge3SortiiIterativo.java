public class Merge3SortiiIterativo {

    public static void merge3Sortii(int[] A) {
        int n = A.length;
        int[] temp = new int[n];

        // Empezamos con el tamaño de los subarreglos en 1 y vamos duplicando en 3
        for (int size = 1; size < n; size *= 3) {
            for (int left = 0; left < n; left += 3 * size) {
                int mid1 = Math.min(left + size, n);
                int mid2 = Math.min(left + 2 * size, n);
                int right = Math.min(left + 3 * size, n);
                // Mezclar tres subarreglos: [left, mid1), [mid1, mid2), [mid2, right)
                merge(A, temp, left, mid1, mid2, right);
            }
        }
    }

    private static void merge(int[] A, int[] temp, int left, int mid1, int mid2, int right) {
        int i = left, j = mid1, k = mid2, m = left;

        // Mezclamos los tres subarreglos comparando los elementos
        while (i < mid1 && j < mid2 && k < right) {
            if (A[i] <= A[j] && A[i] <= A[k]) {
                temp[m++] = A[i++];
            } else if (A[j] <= A[i] && A[j] <= A[k]) {
                temp[m++] = A[j++];
            } else {
                temp[m++] = A[k++];
            }
        }

        // Mezclamos los dos subarreglos restantes
        while (i < mid1 && j < mid2) {
            temp[m++] = (A[i] <= A[j]) ? A[i++] : A[j++];
        }
        while (j < mid2 && k < right) {
            temp[m++] = (A[j] <= A[k]) ? A[j++] : A[k++];
        }
        while (i < mid1 && k < right) {
            temp[m++] = (A[i] <= A[k]) ? A[i++] : A[k++];
        }

        // Copia los elementos restantes de los subarreglos
        while (i < mid1) {
            temp[m++] = A[i++];
        }
        while (j < mid2) {
            temp[m++] = A[j++];
        }
        while (k < right) {
            temp[m++] = A[k++];
        }

        // Copiamos el arreglo temporal de vuelta a A
        System.arraycopy(temp, left, A, left, right - left);
    }

}