/**
 * 数组的相对顺序
 * https://leetcode.com/problems/relative-sort-array/
 */
public class Leetcode_1122_relativeSortArray {
    /**
     * 计数排序
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counter = new int[1001];
        for (int a : arr1) {
            counter[a]++;
        }
        int i = 0;
        for (int a : arr2) {
            while (counter[a]-- > 0) {
                arr1[i++] = a;
            }
        }
        for (int j= 0; j < counter.length; j++) {
            while (counter[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }
}
