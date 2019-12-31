#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#

# @lc code=start

# 回溯解法，设定终止条件、单层处理逻辑、下一层调用方法，不断进行递归组合
# 回溯的思想在于，递归到最底层之后，反弹回上一层是最初始的状态，一起从新开始
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        phone = {'2': ['a', 'b', 'c'],
                '3': ['d', 'e', 'f'],
                '4': ['g', 'h', 'i'],
                '5': ['j', 'k', 'l'],
                '6': ['m', 'n', 'o'],
                '7': ['p', 'q', 'r', 's'],
                '8': ['t', 'u', 'v'],
                '9': ['w', 'x', 'y', 'z']}
        def backtrack(conbi, digit):
            # 终止条件
            if len(digit) == 0:
                output.append(conbi)
                return
            # 当层处理逻辑 和 drill down
            for i in phone[digit[0]]:
                backtrack(conbi + i, digit[1:])
        output = []
        if digits:
            backtrack("", digits)
        return output

# @lc code=end

