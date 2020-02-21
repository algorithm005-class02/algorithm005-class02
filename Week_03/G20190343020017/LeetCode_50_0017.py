# 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
class Solution:
    # 二分递归，对应官方解法2
    def myPow(self, x: float, n: int) -> float:
        # terminator
        if n == 0:
            return 1
        elif n == 1:
            return x
        # process & drill down
        elif n > 0:
            n2 = self.myPow(x, n // 2)
            return n2 * n2 * self.myPow(x, n % 2)
        else:
            return 1 / self.myPow(x, -n)

    # 暴力法直接连乘，这里略去

    # 官方方法3：快速幂算法，循环
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x, n = 1/x, -n
        result, current = 1, x
        while n:
            if n % 2:
                result = result * current
            current *= current
            n //= 2
        return result