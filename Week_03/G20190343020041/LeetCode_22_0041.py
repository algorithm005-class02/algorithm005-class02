# 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
#
# 例如，给出 n = 3，生成结果为：
#
# [
#  "((()))",
#  "(()())",
#  "(())()",
#  "()(())",
#  "()()()"
# ]
#
# Related Topics 字符串 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def generateParenthesisDfs(self, n: int) -> List[str]:
        res = []

        def dfs(left, right, s):
            if left == n and right == n:
                res.append(s)
                return
            if left < n:
                dfs(left + 1, right, s + "(")
            if right < left:
                dfs(left, right + 1, s + ")")

        dfs(0, 0, "")
        return res

    def generateParenthesisBfs(self, n: int) -> List[str]:
        res = []

        queue = [("", 0, 0)]
        while queue:
            c = queue.pop()
            left = c[1]
            right = c[2]
            v = c[0]
            if left == n and right == n:
                res.append(v)
                continue
            if left < n:
                queue.append((v + "(", left + 1, right))
            if right < left:
                queue.append((v + ")", left, right + 1))
        return res

    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        stack = [("", 0, 0)]
        while stack:
            c = stack.pop()
            left = c[1]
            right = c[2]
            v = c[0]
            if left == n and right == n:
                res.append(v)
                continue
            if right < left:
                stack.append((v + ")", left, right + 1))
            if left < n:
                stack.append((v + "(", left + 1, right))

        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().generateParenthesis(2))
