import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
            if (intervals[i][1] > right) right = intervals[i][1];
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[0][]);
    }
}
// @lc code=end

