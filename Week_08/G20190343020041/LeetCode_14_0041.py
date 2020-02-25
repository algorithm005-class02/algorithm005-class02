# 编写一个函数来查找字符串数组中的最长公共前缀。
#
# 如果不存在公共前缀，返回空字符串 ""。
#
# 示例 1:
#
# 输入: ["flower","flow","flight"]
# 输出: "fl"
#
#
# 示例 2:
#
# 输入: ["dog","racecar","car"]
# 输出: ""
# 解释: 输入不存在公共前缀。
#
#
# 说明:
#
# 所有输入只包含小写字母 a-z 。
# Related Topics 字符串


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        n = len(strs)
        if n == 0: return ""
        s = strs[0]
        for i in range(len(s)):
            for j in range(1, n):
                if i == len(strs[j]) or s[i] != strs[j][i]:
                    return s[:i]
        return s


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().longestCommonPrefix(["a", "b", "c"]))
