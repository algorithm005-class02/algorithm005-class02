## 快排
```
    public static void quickSort(int[] arrays, int start, int end) {
        if (start >= end) return;
        int pivot = partition(arrays, start, end);
        quickSort(arrays, start, pivot-1);
        quickSort(arrays, pivot+1, end);
    }

    public static int partition(int[] arrays, int start, int end) {
        int counter = start;
        int pivot = end;
        for (int i=start; i<pivot; i++) {
            if (arrays[i] <= arrays[pivot]) {
                int temp=arrays[i]; arrays[i]=arrays[counter]; arrays[counter]=temp;
                counter++;
            }
        }
        int temp=arrays[counter]; arrays[counter]=arrays[pivot]; arrays[pivot]=temp;
        return counter;
    }
```
## 归并
```
    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k=0;
        while (i<=mid && j<=right) {
            tmp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }

        while (i<=mid) tmp[k++] = array[i++];
        while (j<=right) tmp[k++] = array[j++];

        for (int index=0; index<tmp.length; index++) {
            array[left+index] = tmp[index];
        }
    }
```