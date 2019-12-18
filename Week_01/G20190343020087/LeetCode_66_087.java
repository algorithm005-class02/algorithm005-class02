import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 * 
 * 需要考虑两种情况：
 * 1.末位为9
 * 2.末位为非9
 * 末位为非9数字很简单，+1即可
 * 末位为9，需要考虑进位 以及 之前元素是否为9
个人的实现方法：递归（空间换时间）
 */

// @lc code=start
class Solution {
    int count = 0;
    public int[] plusOne(int[] digits) {
        int len = digits.length - count++; // 当前列表长度
        if (digits[len-1] != 9) digits[len-1] += 1;
        else {
            while (len-1 > 0) {
                digits[len-1] = 0;
                return plusOne(digits);
            }
            // 如果递归到数组中第一个元素仍为9，那么就只有一种情况，需要开辟新的数组例如[1,0,0]
            digits = new int[digits.length + 1]; 
            digits[0] = 1;
            return digits;
        }
        return digits;
    }
}
// @lc code=end

