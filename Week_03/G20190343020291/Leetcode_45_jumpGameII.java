/**
 * 跳跃游戏II
 * https://leetcode.com/problems/jump-game-ii/
 */
public class Leetcode_45_jumpGameII {
    public int jump(int[] nums) {
        int curFarthest = 0;
        int curEnd = 0;
        int steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if (i == curEnd) {
                curEnd = curFarthest;
                steps++;
            }
        }
        return steps;
    }
}
