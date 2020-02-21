#
# @lc app=leetcode.cn id=50 lang=python3
#
# [50] Pow(x, n)
#

# @lc code=start

# 解法一，采用迭代法，其中解题思路是：1.设置边界条件，n等于0时返回1，n小于0时返回n平方后的倒数
# 2.当遇到偶次幂时，等效拆解成底数的平方的（n/2)次幂
# 3.当遇到奇次幂时，等于底数乘以底数的n-1次幂，而底数的n-1次幂呢就是底数偶次幂，同理可用第2步
# 的等效拆解法求之。这里会思考一个问题，为什么不用底数的3次方的（n/3）次幂的拆解方式呢？应该是
# 用奇数偶数可以遍历所有整数，而且相邻奇数和偶数永远只相差1，便于设置递归终止条件

class Solution:
    def myPow(self, x: float, n: int) -> float:
        def _innerhelper(x, n):
            if n == 0:
                return 1
            if n % 2 == 0:
                return _innerhelper(x*x, n//2)
            return _innerhelper(x*x, (n - 1)//2) * x  # 如果没有*x,那么只会返回1，因为没有将迭代计算的x*x给乘上
        if n < 0:
            n = -n
            return 1/_innerhelper(x, n)
        return _innerhelper(x, n)
        
# @lc code=end

