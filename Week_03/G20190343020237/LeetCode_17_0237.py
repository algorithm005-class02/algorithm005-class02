#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#
# https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
#
# algorithms
# Medium (51.62%)
# Likes:    522
# Dislikes: 0
# Total Accepted:    65K
# Total Submissions: 125.5K
# Testcase Example:  '"23"'
#
# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
#
# 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
#
#
#
# 示例:
#
# 输入："23"
# 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
#
#
# 说明:
# 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
#
#

# @lc code=start
from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:

        # 2019-12-26 22:13:35
        # 25/25 cases passed (36 ms)
        # Your runtime beats 80.49 % of python3 submissions
        # Your memory usage beats 99.57 % of python3 submissions (12.8 MB)
        ans = []
        d2c = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        def helper(path: str, digits: str):
            """
            path: 已经走过的路径
            digits: 待走的路径
            """
            if not digits:
                if path: ans.append(path)
                return

            for c in d2c[digits[0]]:
                helper(path + c, digits[1:])

        helper('', digits)
        return ans


# @lc code=end
