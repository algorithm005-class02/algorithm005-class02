import math

class Solution:
    def climbStairs(self, n: int) -> int:
        # 方法一：按照超哥斐波拉契数列思路（28ms）
        '''
        if n <= 2: return n
        f1, f2 = 1, 2
        for i in range(3, n + 1):
            f1, f2 = f2, f1 + f2
        return f2
        '''
        # 方法二：按照公式计算斐波拉契数列（28ms）
        '''
        sqrt5 = math.sqrt(5)
        fibn = math.pow((1 + sqrt5) / 2,n + 1) - math.pow((1 - sqrt5) / 2, n + 1)
        return int(fibn / sqrt5)
        '''
        # 方法三：自己最初的思路，组合法（28-36ms）
        result = 1
        for i in range(1, int(n / 2 + 1)):
            result += math.factorial(n - i) / math.factorial(i) / math.factorial(n - i * 2)
        return int(result)