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
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null)
            return res.toArray(new int[0][]);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[] { left, right });
            i++;
        }
        return res.toArray(new int[0][]);
        
    }
}
// @lc code=end
/* 
思路1：
    先按首位置进行排序;接下来,如何判断两个区间是否重叠呢?比如 a = [1,4],b = [2,3]
    当 a[1] >= b[0] 说明两个区间有重叠.但是如何把这个区间找出来呢?左边位置一定是确定，
    就是 a[0]，而右边位置是 max(a[1], b[1])所以,我们就能找出整个区间为:[1,4]
代码见上：

思路2：代码如下：
        LinkedList<int[]> res = new LinkedList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            if (res.isEmpty() || res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }

        // 为什么放0，0长度？可以看下源码就知道了
        return res.toArray(new int[0][0]);
*/