/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } 
            if (bill == 10) {
                ten++;
                five--;
            } 
            if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0) return false;
            if (ten < 0) return false; 
        }
        return true;
    }
}
// @lc code=end

