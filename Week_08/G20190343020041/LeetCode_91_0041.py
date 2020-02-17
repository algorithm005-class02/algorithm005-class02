# 一条包含字母 A-Z 的消息通过以下方式进行了编码：
#
# 'A' -> 1
# 'B' -> 2
# ...
# 'Z' -> 26
#
#
# 给定一个只包含数字的非空字符串，请计算解码方法的总数。
#
# 示例 1:
#
# 输入: "12"
# 输出: 2
# 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
#
#
# 示例 2:
#
# 输入: "226"
# 输出: 3
# 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
#
# Related Topics 字符串 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numDecodings(self, s: str) -> int:
        """
        dp[i] = dp[i] 包含dp[i]的总步数
        dp[i] = {
            dp[i] += dp[i-1], 0 < s[i-1:i] < 10
            dp[i] += dp[i-2], 9 < s[i-2:i] <= 26
        }

        base case
        dp[0] = 1
        dp[1] =  s[0] > 0
        :param s:
        :return:
        """
        n = len(s)
        dp = [0] * (n + 1)
        dp[0] = 1
        dp[1] = 0 if s[0] == '0' else 1
        for i in range(2, n + 1):
            if int(s[i - 1:i]) > 0:
                dp[i] += dp[i - 1]
            if 10 <= int(s[i - 2:i]) <= 26:
                dp[i] += dp[i - 2]
        return dp[-1]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().numDecodings("226"))
