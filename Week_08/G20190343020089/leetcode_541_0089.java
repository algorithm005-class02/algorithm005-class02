import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverseStr(arr, i, i + k - 1);
        }
        return new String(arr);
    }

    private void reverseStr(char[] arr, int s, int e) {
        if (e >= arr.length) e = arr.length - 1; 
        for (int i = s; i < (s + e) / 2.0; i++) {
            char temp = arr[i];
            arr[i] = arr[e - i + s];
            arr[e - i + s] = temp;
        }
    }
}
// @lc code=end

