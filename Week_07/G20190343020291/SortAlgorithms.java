import java.util.Arrays;

/**
 * 排序算法
 */
public class SortAlgorithms {
    /**
     * 1. 选择排序
     */
    public static void selectionSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }


    /**
     * 2. 插入排序
     */
    public static void insertionSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int preIndex = i - 1;
            int cur = array[i];
            while (preIndex >= 0 && array[preIndex] > cur) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = cur;
        }
    }

    /**
     * 3. 冒泡排序
     */
    public static void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 4. 快速排序
     */
    public static void quickSort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }
    public static int partition(int[] array, int left, int right) {
        int pivot = right, counter = left;
        for (int i = left; i < right; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[i];
                array[i] = array[counter];
                array[counter] = temp;
                counter++;
            }
        }
        int temp = array[counter];
        array[counter] = array[pivot];
        array[pivot] = temp;
        return counter;
    }

    /**
     * 5. 归并排序
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }
    public static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++]  = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }

    /**
     * 6. 堆排序
     */
    public static void heapSort(int[] array) {
        int len = array.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(array, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapify(array, i, 0);
        }
    }
    public static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }


    /**
     * Test
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {2, 5, 1, 3, 7, 9, 10, 6, 8};
        System.out.println("Before:" + Arrays.toString(array));
//        SortAlgorithms.bubbleSort(array);
//        SortAlgorithms.selectionSort(array);
//        SortAlgorithms.insertionSort(array);
//        SortAlgorithms.mergeSort(array, 0, array.length - 1);
//        SortAlgorithms.quickSort(array, 0, array.length - 1);
        SortAlgorithms.heapSort(array);
        System.out.println("After: " + Arrays.toString(array));

    }
}
