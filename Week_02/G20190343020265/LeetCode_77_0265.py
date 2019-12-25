#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if n <= 0 or k <= 0 or k > n:
            return []
        res = []
        self.__dfs(1, k, n, [], res)
        return res
    def __dfs(self, start, k, n, pre, res):
            # 终结条件
        if len(pre) == k:
            res.append(pre[:])
            return
            # 处理逻辑和下一层
        for i in range(start, n + 1):
            pre.append(i)
            self.__dfs(i + 1, k, n, pre, res)
            pre.pop()

   
# @lc code=end

