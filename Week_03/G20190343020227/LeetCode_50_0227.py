class Solution(object):
    #暴力法，超时了，没有出奇迹
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        res = 1
        if n > 0:
            for i in range(n):
                res = res * x
        elif n < 0:
            n = -n
            for i in range(n):
                res = res * x
            res = float(1)/res
        return float(res)

    #分治法，递归
    def myPow2(self, x, n):
        def helper(x,n):
            if n==0:
                return 1
            if n%2 == 0:
                return helper(x*x,n/2)
            else:
                return helper(x*x,n/2)*x
        if n<0:
            n=-n
            return float(1)/helper(x,n)
        else:
            return helper(x,n)