/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int a = 0;
        int b = s.length - 1;
        reverse(s, a, b);
    }

    private void reverse(char[] s, int a, int b) {
        a = 0;
        b = s.length - 1;
        while (a < b) {
            char temp = s[a];
            s[a] = s[b];
            s[b] = temp;
            a++;
            b--;
        }
    }
}
// @lc code=end
