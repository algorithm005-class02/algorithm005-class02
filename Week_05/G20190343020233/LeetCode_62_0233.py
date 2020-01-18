import math
from functools import lru_cache

from utils.timer import timethis


class Solution:
    @timethis
    def uniquePaths_cache_recursive(self, m: int, n: int) -> int:
        """递归，加cache"""
        @lru_cache(None)
        def generate_path(m_steps, n_steps):
            if m_steps == 0 or n_steps == 0:
                return 1
            return generate_path(m_steps - 1, n_steps) + generate_path(m_steps, n_steps - 1)
        return generate_path(m-1, n-1)

    def uniquePaths_forloop(self, m, n):
        """排列组合"""
        # c(N, k) = N!/(k!(N-k)!)
        # c((m+n-2), m) = (m+n-2)!/((n-2)!m!)
        # = ((m+n-2)-1)*((m+n-2)-2))*..*(n-2+1)/m!
        path = 1
        for i in range(1, m):
            path = path * (n - 1 + i) / i
        return int(path)

    @timethis
    def uniquePaths_factorial(self, m, n):
        """排列组合-使用阶乘函数: O(1)"""
        # c(N, k) = N!/(k!(N-k)!)
        # N = m+n-2, k = m-1
        return int(math.factorial(m+n-2)/(math.factorial(m-1)*math.factorial(n-1)))

    @timethis
    def uniquePaths(self, m, n):
        """动态规划O(n^2)"""
        process = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                process[j] += process[j-1]
        return process[-1]

if __name__ == '__main__':
    test = Solution()
    print(test.uniquePaths_stupid_recursive(3, 2)) #3
    print(test.uniquePaths_stupid_recursive(7, 3)) #28
    print(test.uniquePaths_stupid_recursive(99,99)) #5716592448890534538025559599823267555746984381052513943552
