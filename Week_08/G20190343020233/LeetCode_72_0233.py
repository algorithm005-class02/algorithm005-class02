# -*- encoding: utf-8 -*-
# Create on 2020/2/15

class Solution:
    def minDistance(self, word1, word2):
        m = len(word1) + 1
        n = len(word2) + 1
        dp = [[0] * m for _ in range(n)]
        #dp = [[0] * m] * n
        #上面这种初始化方式每一行会使用相同的引用，造成修改的时候会把多行都赋值了
        #初始化第一行第一列 增加0行0列表示其中一个字符为""的情况
        for i in range(n):
            dp[i][0] = i
        for i in range(m):
            dp[0][i] = i
        # 该位相等的话就直接打掉，化为去掉后子串问题
        # 该位不相等的话就在三种操作种选操作数最少的操作
        # 操作1替换该位，替换后就等于去掉该位的子串情况+1
        # 操作2去掉word1的该位，去掉该位后的word1和不操作的word2的子问题+1
        # 操作3去掉word2的该位，去掉该位后的word2和不操作的word1的子问题+1
        for i in range(1, n):
            for j in range(1, m):
                if word1[j-1] == word2[i-1]:
                    dp[i][j] = dp[i-1][j-1]
                elif word1[j-1] != word2[i-1]:
                    dp[i][j] = min(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j-1] + 1)
        return dp[-1][-1]


if __name__ == '__main__':
    test = Solution()
    print(test.minDistance("horse", "ros"))
    print(test.minDistance("intention", "execution"))
