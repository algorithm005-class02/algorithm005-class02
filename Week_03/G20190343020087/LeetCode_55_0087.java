/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 * 贪心算法思路，逆推，从末位元素开始遍历数组
 * 判断当前位置（下标）+当前步数是否能 >= 终点位置
 * 满足条件说明能到达终点，那就将当前位置设为终点，如果到下标为0的时候也能到达终点
 * 3 + 1 = 4 能到终点，将下标3设为终点
 * 2 + 1 = 3 能到终点，将下标2设为终点 
 * 直到遍历完数组，下标0将设为终点，说明此数组满足条件
 * 
 * 3 + 0 < 4 不能到终点
 * 2 + 1 < 4
 * 1 + 2 < 4
 * 0 + 3 < 4始终到不了终点，所以此时终点值不为0，不满足条件
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1; // 终点位置下标
        for (int i = nums.length - 1; i >= 0 ; i--) {
            // 
            if (i + nums[i] >= lastPos) lastPos = i; // 如果当前位置能到终点，就把当前位置设为终点
        }
        return lastPos == 0;
    }
}
// @lc code=end

