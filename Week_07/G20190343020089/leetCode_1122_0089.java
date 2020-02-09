/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int pos = 0;
        for (int ele : arr2) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] == ele) {
                    int temp = arr1[i];
                    arr1[i] = arr1[pos];
                    arr1[pos] = temp;
                    pos++;
                }       
            }
        }
        for (; pos < arr1.length; pos++) {
            for (int j = pos + 1; j < arr1.length; j++) {
                if (arr1[pos] > arr1[j]) {
                int temp = arr1[j];
                arr1[j] = arr1[pos];
                arr1[pos] = temp;
                }
            }
        }
        return arr1;
    }
}
// @lc code=end

