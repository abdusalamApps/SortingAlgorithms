import java.util.Random;

public class Sorting {
    public static void main(String[] args) {

        int[] array = {3, 8, 5, 9, 2, 4};

        System.out.println();

        quicksort(array, 0, array.length - 1);

        for (int number : array)
            System.out.print(number + " ");


    }

    public static void selectionSort(int[] array) {
        int minIndex;

        for (int i = 0; i < array.length; i++) {
            minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }

            }

            int first = array[i];
            array[i] = array[minIndex];
            array[minIndex] = first;
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            // Recursively divide the arrays - s -> mid and mid + 1 -> end
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);

            int[] tArray = new int[array.length];
            // Merge the two parts
            merge(array, tArray, start, mid + 1, end);

        }

    }

    public static void merge(int[] array, int[] tArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tPos = leftPos;
        int leftStart = leftPos;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos] <= array[rightPos]) {
                tArray[tPos] = array[leftPos];
                leftPos++;
            } else {
                tArray[tPos] = array[rightPos];
                rightPos++;
            }
            tPos++;
        }

        while (leftPos <= leftEnd) {
            tArray[tPos] = array[leftPos];
            leftPos++;
            tPos++;
        }

        while (rightPos <= rightEnd) {
            tArray[tPos] = array[rightEnd];
            rightPos++;
            tPos++;
        }

        for (int i = leftStart; i <= rightEnd; i++) {
            array[i] = tArray[i];
        }
    }

    public static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            quicksort(array, low, pi - 1);
            quicksort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;

                // swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
