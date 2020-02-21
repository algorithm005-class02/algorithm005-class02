# 给出一个区间的集合，请合并所有重叠的区间。
#
# 示例 1:
#
# 输入: [[1,3],[2,6],[8,10],[15,18]]
# 输出: [[1,6],[8,10],[15,18]]
# 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
#
#
# 示例 2:
#
# 输入: [[1,4],[4,5]]
# 输出: [[1,5]]
# 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
# Related Topics 排序 数组


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals: return
        intervals.sort(key=lambda x: x[0])
        res = []
        for i in intervals:
            if res and i[0] <= res[-1][1]:
                res[-1][1] = max(res[-1][1], i[1])
            else:
                res.append(i)
        return res


# leetcode submit region end(Prohibit modification and deletion)
Solution().merge([[1, 3], [2, 6], [8, 10], [15, 18]])
