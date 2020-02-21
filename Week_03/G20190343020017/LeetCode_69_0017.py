class Solution:
    # 二分查找法
    def mySqrt(self, x: int) -> int:
        # 首先对 sqrt(x) < x // 2 的数进行处理
        if x == 0:
            return 0
        if x < 4:
            return 1
        # left, right 取值缩小进行加速
        left, right = 2, x // 2
        while left < right:
            # 此处取右中位数，左中位数可能等于left然后陷入死循环
            mid = left + (right - left + 1) // 2
            if mid * mid > x:
                right = mid - 1
            # mid * mid <= x 时，可能mid正是目标值，所以左边界不能+1
            else:
                left = mid
        return left