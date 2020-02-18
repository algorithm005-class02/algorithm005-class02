# 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
#
# 示例 1:
#
# 输入: coins = [1, 2, 5], amount = 11
# 输出: 3
# 解释: 11 = 5 + 5 + 1
#
# 示例 2:
#
# 输入: coins = [2], amount = 3
# 输出: -1
#
# 说明:
# 你可以认为每种硬币的数量是无限的。
# Related Topics 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


def dfs(coins: List[int], amount: int, mem: List[int]):
    if amount == 0: return 0
    if amount < 0: return -1
    if mem[amount] != 0: return mem[amount]
    m = float("+inf")
    for coin in coins:
        res = dfs(coins, amount - coin, mem)
        if res >= 0:
            m = min(m, res + 1)
    mem[amount] = -1 if m == float("+inf") else m
    return mem[amount]


class Solution:
    def coinChangeDfs(self, coins: List[int], amount: int) -> int:
        return dfs(coins, amount, [0] * (amount + 1))

    def coinChange(self, coins: List[int], amount: int) -> int:
        """
        动态规划:
        f(n) =
        {
            0, n = 0
            1 + min( f(n-k)  | k in coins )
        }
        :param coins:
        :param amount:
        :return:
        """
        MAX = amount + 1
        dp = [MAX] * MAX
        dp[0] = 0
        for i in range(1, MAX):
            for c in coins:
                if c <= i:
                    dp[i] = min(dp[i], dp[i - c] + 1)
        return -1 if dp[amount] > amount else dp[amount]


# leetcode submit region end(Prohibit modification and deletion)
Solution().coinChange([1, 2, 5], 11)
