
//91. 解码方法
/*
此题和爬楼梯是同一个类型的问题，难点在于其添加了许多限制条件，只要避开限制条件就可以完美解题了

每次递进，可以选取一个数也可以选取两个数：

s[i] != '0'
如果 s[i-1]s[i] <= 26, 则 dp[i] = dp[i-1] + dp[i-2]
如果 s[i-1]s[i] > 26, 则 dp[i] = dp[i-1], 这是因为 s[i-1]s[i] 组成的两位数无法翻译
s[i] == '0'
如果 s[i-1]s[i] <= 26, 则 dp[i] = dp[i-2], 这是因为 s[i] 无法翻译
还有一些情景直接使得整个序列无法被翻译：
相邻的两个 ‘0’
以 ‘0’ 结尾的大于 26 的数字
去除这些限制条件，此题就是爬楼梯的问题了，一次可以爬一步，也可以爬两步，问有多少中方式到达终点。

*/
class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or s[0] == '0': # 基本情况，直接返回 0
            return 0
        dp = [None] * len(s) # 构建 dp 数组
        dp[0] = 1 # 只有一个数时肯定为 1
        if len(s) > 1: # 为 dp[1] 填充值
            if s[1] == '0': # s[i] 为 ‘0’ 时
                if int(s[0:2]) <= 26: # 截取前两数，判断是否小于或等于 26
                    dp[1] = 1 # 因为 s[i] 为 ‘0’ 所以 dp[1] 只有 1 种可能
                else:
                    return 0 # 比如 60 , 此时该序列无法翻译
            else: # s[i] 不为 ‘0’ 时
                if int(s[0:2]) <= 26:
                    dp[1] = 2 # 比如 16，有两种翻译结果
                else:
                    dp[1] = 1 # 比如 27，只有一种结果
        else: # 只有一个数
            return 1

        for i in range(2, len(s)): # 从 2 开始
            if s[i] == '0': # s[i] 为 ‘0’ 时
                if s[i-1] == '0': # 前一个为 ‘0’
                    return 0 # 无解
                else: # 前一个不为 ‘0’
                    if int(s[i-1:i+1]) <= 26: # s[i-1] 和 s[i] 组成的数 <= 26
                        dp[i] = dp[i-2]
                    else:
                        return 0
            else: # s[i] 不为 ‘0’
                if s[i-1] == '0': # 前一个为 ‘0’
                    dp[i] = dp[i-1]
                else: # 前一个不为 ‘0’
                    if int(s[i-1:i+1]) <= 26: # s[i-1] 和 s[i] 组成的数 <= 26
                        dp[i] = dp[i-1] + dp[i-2]
                    else: # s[i-1] 和 s[i] 组成的数 > 26
                        dp[i] = dp[i-1]

        return dp[len(s) - 1]
