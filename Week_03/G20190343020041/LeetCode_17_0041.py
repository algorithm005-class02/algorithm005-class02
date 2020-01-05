#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#
from typing import List
# @lc code=start


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        phone = {'2': ['a', 'b', 'c'],
                 '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'],
                 '5': ['j', 'k', 'l'],
                 '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'],
                 '8': ['t', 'u', 'v'],
                 '9': ['w', 'x', 'y', 'z']}

        def backtrack(s, i):
            # terminator
            if i == len(digits):
                res.append(s)
                return
            # press
            d = digits[i]
            # drill down
            for c in phone[d]:
                backtrack(s + c, i+1)
        backtrack("", 0)
        return res


# @lc code=end
print(Solution().letterCombinations("23"))
