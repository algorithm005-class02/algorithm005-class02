#
# @lc app=leetcode.cn id=387 lang=python3
#
# [387] 字符串中的第一个唯一字符
#
# https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
#
# algorithms
# Easy (42.29%)
# Likes:    177
# Dislikes: 0
# Total Accepted:    59.9K
# Total Submissions: 138.7K
# Testcase Example:  '"leetcode"'
#
# 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
#
# 案例:
#
#
# s = "leetcode"
# 返回 0.
#
# s = "loveleetcode",
# 返回 2.
#
#
#
#
# 注意事项：您可以假定该字符串只包含小写字母。
#
#

# @lc code=start


class Solution:
    def firstUniqChar(self, s: str) -> int:

        # # 暴力O(n^2)
        # n = len(s)
        # bad = set()
        # for i in range(n):
        #     if s[i] in bad: continue
        #     for j in range(i + 1, n):
        #         if s[i] == s[j]:
        #             bad.add(s[i])
        #             break
        #     else:
        #         return i
        # return -1

        # 搞复杂了，首个字符可通过遍历s获取，不需要用OrderedDict
        # from collections import OrderedDict
        # c2n = OrderedDict()
        # for i, c in enumerate(s):
        #     if c in c2n:
        #         c2n[c][0] += 1
        #     else:
        #         c2n[c] = [1, i]

        # for _, (cnt, i) in c2n.items():
        #     if cnt == 1: return i

        # return -1

        # hashmap: 存储字符出现个数; 遍历s, 找到首个字符
        # --------------------------------------------
        # Accepted
        # 104/104 cases passed (116 ms)
        # Your runtime beats 64.32 % of python3 submissions
        # Your memory usage beats 47.3 % of python3 submissions (13 MB)

        from collections import defaultdict
        c2n = defaultdict(int)
        for c in s: c2n[c] += 1
        for i, c in enumerate(s):
            if c2n[c] == 1: return i
        return -1
# @lc code=end
