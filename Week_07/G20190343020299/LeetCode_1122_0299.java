import java.util.Arrays;

public class LeetCode_1122_0299 {

    public static void main(String[] args) {

        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        // 把arr1放入桶中
        for (int num : arr1) {
            bucket[num]++;
        }
        // 根据arr2的顺序取出桶中的数据
        int index = 0;
        for (int num : arr2) {
            while (bucket[num]-- > 0) {
                arr1[index++] = num;
            }
        }
        // 取出不在arr2桶中的数据
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- >0)
                arr1[index++] = i;
        }
        return arr1;
    }
}
