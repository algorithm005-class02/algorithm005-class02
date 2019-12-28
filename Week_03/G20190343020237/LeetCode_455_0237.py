#
# @lc app=leetcode.cn id=455 lang=python3
#
# [455] 分发饼干
#
# https://leetcode-cn.com/problems/assign-cookies/description/
#
# algorithms
# Easy (52.48%)
# Likes:    122
# Dislikes: 0
# Total Accepted:    21.3K
# Total Submissions: 40.6K
# Testcase Example:  '[1,2,3]\n[1,1]'
#
# 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi
# ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i
# ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
#
# 注意：
#
# 你可以假设胃口值为正。
# 一个小朋友最多只能拥有一块饼干。
#
# 示例 1:
#
#
# 输入: [1,2,3], [1,1]
#
# 输出: 1
#
# 解释:
# 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
# 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
# 所以你应该输出1。
#
#
# 示例 2:
#
#
# 输入: [1,2], [1,2,3]
#
# 输出: 2
#
# 解释:
# 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
# 你拥有的饼干数量和尺寸都足以让所有孩子满足。
# 所以你应该输出2.
#
#
#

# @lc code=start


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:

        # # 2019-12-28 18:05:43
        # # 最大的饼干给最大的胃口, 贪心
        # g_sorted, s_sorted = sorted(g, key=lambda x: -x), sorted(s, key=lambda x: -x)
        # ans, i = 0, 0
        # for s in s_sorted:
        #     while i < len(g_sorted):
        #         if s >= g_sorted[i]:
        #             ans += 1
        #             i += 1
        #             break

        #         i += 1
        # return ans

        # 2019-12-28 18:06:15
        # 21/21 cases passed (196 ms)
        # Your runtime beats 91.73 % of python3 submissions
        # Your memory usage beats 83.74 % of python3 submissions (14.4 MB)
        g.sort()
        s.sort()

        i, j, ans = 0, 0, 0
        while i < len(s) and j < len(g):
            if s[i] >= g[j]:
                i, j, ans = i + 1, j + 1, ans + 1
            else:
                i += 1          # 更大的饼干

        return ans

# @lc code=end
