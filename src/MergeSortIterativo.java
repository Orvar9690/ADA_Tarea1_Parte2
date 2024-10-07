public class MergeSortIterativo {

    public static void mergeSort(int[] array) {
        int n = array.length;
        int[] temp = new int[n];
        for (int size = 1; size < n; size = 2 * size) {
            for (int leftStart = 0; leftStart < n; leftStart += 2 * size) {
                int mid = Math.min(leftStart + size, n);
                int rightEnd = Math.min(leftStart + 2 * size, n);
                merge(array, temp, leftStart, mid, rightEnd);
            }
        }
    }

    private static void merge(int[] array, int[] temp, int leftStart, int mid, int rightEnd) {
        int i = leftStart, j = mid, k = leftStart;

        while (i < mid && j < rightEnd) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i < mid) {
            temp[k++] = array[i++];
        }

        while (j < rightEnd) {
            temp[k++] = array[j++];
        }

        for (i = leftStart; i < rightEnd; i++) {
            array[i] = temp[i];
        }
    }

}