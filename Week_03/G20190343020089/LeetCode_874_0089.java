import java.util.HashSet;
import java.util.Set;


/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int di = 0, x = 0, y = 0, ans = 0;
        Set<String> obSet = new HashSet<String>();
        for (int[] obstacle : obstacles) {
            obSet.add(obstacle[0] + ", " + obstacle[1]);
        }
        for (int command : commands) {
            // 向右转
            if (command == -1) {
                di = (di + 1) % 4;
                continue;
            }
            // 向左转
            if (command == -2) {
                di = (di + 3) % 4;
                continue;
            }
            // 齐步走
            for (int i = 0; i < command; i++) {
                int nx = x + dx[di];
                int ny = y + dy[di];
                if (!obSet.contains(nx + ", "+ ny)) {
                    x = nx;
                    y = ny;
                    ans = Math.max(ans, (x * x) + (y * y));
                } 
            }
        }
        return ans;
    }
}
// @lc code=end


