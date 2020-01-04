# 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
#
# 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
#
# 注意：给定 n 是一个正整数。
#
# 示例 1：
#
# 输入： 2
# 输出： 2
# 解释： 有两种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶
# 2.  2 阶
#
# 示例 2：
#
# 输入： 3
# 输出： 3
# 解释： 有三种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶 + 1 阶
# 2.  1 阶 + 2 阶
# 3.  2 阶 + 1 阶
#
# Related Topics 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def __init__(self):
        self.cache = {}

    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 2:
            return n
        a, b = 1, 2
        for _ in range(2, n + 1):
            a, b = b, a + b
        return a

    def climbStairsCache(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 3:
            return n
        return self.climbStep(n, 1) + self.climbStep(n, 2)

    def climbStep(self, n, step):
        if n - step in self.cache:
            two = self.cache[n - step]
        else:
            two = self.climbStairs(n - step)
            self.cache[n - step] = two
        return two


# leetcode submit region end(Prohibit modification and deletion)

print(Solution().climbStairs(100))
