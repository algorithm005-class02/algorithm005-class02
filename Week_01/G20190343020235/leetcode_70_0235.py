"""
思路 1
暴力
在暴力法中，我们将会把所有可能爬的阶数进行组合，也就是 1 和 2 。而在每一步中我们都会继续调用 climbStairs 这个函数模拟爬 1 阶和 2 阶的情形，并返回两个函数的返回值之和。
时间 O(2^n) 空间 O(n)
思路 2
记忆化递归
在上一种方法中，我们计算每一步的结果时出现了冗余。另一种思路是，我们可以把每一步的结果存储在 memo 数组之中，每当函数再次被调用，我们就直接从 memo 数组返回结果。

在 memo 数组的帮助下，我们得到了一个修复的递归树，其大小减少到 n。
时间 O(n) 空间 O(n)
思路 3
动态规划
如何到达第i阶呢？可以在 i-1阶爬一层 i-2阶爬两层
dp[i] = dp[i-1] + dp[i-2]
时间: O(n) 空间 O(n)
思路 4
斐波那契数列
根据思路 3 的递推公式，可以发现这就是斐波那契数列的定义
找出以 1 和 2 为第一第二项的斐波那契数列的第 n 个数
时间 O(n) 空间 O(1)
思路 5
Binets方法
利用矩阵乘法得到第n 个斐波那契数
时间 O(logn) 空间 O(1）
思路 6
斐波那契数列公式https://en.wikipedia.org/wiki/Fibonacci_number
时间 O(logn) 空间 O(1)
"""

# 思路 1 超时
class Solution1:
    def climbStairs(self, n: int) -> int:
        return self.climb_stairs(n, n)
    def climb_stairs(self, i: int, n: int) -> int:
        if i <= 0:
            return 0
        if i == 1:
            return 1
        if i == 2:
            return 2
        return self.climb_stairs(i-1, n) + self.climb_stairs(i-2, n)

# 思路 2 36ms 12.8mb
class Solution2:
    def climbStairs(self, n: int) -> int:
        def climb_stairs(i: int, n: int) -> int:
            if i <= 0:
                return 0
            if i == 1:
                return 1
            if i == 2:
                return 2
            if memo[i] > 0:
                return memo[i]
            memo[i] =  climb_stairs(i-1, n) + climb_stairs(i-2, n)
            return memo[i]
        
        memo = [0 for i in range(n+1)]
        return climb_stairs(n, n)
    
        
# 思路 3 20ms 12.6mb
class Solution3:
    def climbStairs(self, n: int) -> int:
        dp = [0 for _ in range(n+2)]
        if n == 0:
            return 0
        dp[1] = 1
        dp[2] = 2
        for i in range(3, n+1):
            dp[i] = dp[i-1]+dp[i-2]
        return dp[n]

# 思路 4 28ms 12.6mb
class Solution4:
    def climbStairs(self, n: int) -> int:
        if n == 0:
            return 0
        f = [1, 2, 3]
        if n <= 3:
            return f[n-1]
        for i in range(4, n+1):
            f[1], f[0] = f[2], f[1]
            f[2] = f[0] + f[1]
        return f[2]
# 思路 5

# 思路 6 24ms 12.8mb
class Solution6:
    def climbStairs(self, n: int) -> int:
        import math
        root_5 = math.sqrt(5)
        fi = (1+root_5) / 2
        phi = 1 - fi
        return int((math.pow(fi, n+1) - math.pow(phi, n+1)) / root_5)