# 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
#
# 你可以对一个单词进行如下三种操作：
#
#
# 插入一个字符
# 删除一个字符
# 替换一个字符
#
#
# 示例 1:
#
# 输入: word1 = "horse", word2 = "ros"
# 输出: 3
# 解释:
# horse -> rorse (将 'h' 替换为 'r')
# rorse -> rose (删除 'r')
# rose -> ros (删除 'e')
#
#
# 示例 2:
#
# 输入: word1 = "intention", word2 = "execution"
# 输出: 5
# 解释:
# intention -> inention (删除 't')
# inention -> enention (将 'i' 替换为 'e')
# enention -> exention (将 'n' 替换为 'x')
# exention -> exection (将 'n' 替换为 'c')
# exection -> execution (插入 'u')
#
# Related Topics 字符串 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    """
    word1 = ""
    word2 = "abc"

    word1 = "...a"
    word2 = "....a"

    word1 = "...a"
    word2 = "....b"

    n = len(word1)
    m = len(word2)

    dp[i][j] = word1[0..i] word2[0..j]的最小编辑距离

    dp =  {
     dp(word1[n-1],word2[m-1]), word1[n-1] == word2[m-1]
     dp(min(edit_distance(n-1,m-1),edit_distance(n-1,m),edit_distance(n,m-1)),  word1[n-1] == word2[m - 1]
    }

    base case
      "" a b c
    "" 0 1 2 3
     b 1
     c 2
     d 3




    :param word1:
    :param word2:
    :return:
    """

    def minDistance1(self, word1: str, word2: str) -> int:
        """
        自顶向下
        """
        mem = {}

        def helper(i, j):
            if i == -1: return j + 1
            if j == -1: return i + 1
            if (i, j) in mem:
                return mem[(i, j)]
            if word1[i] == word2[j]:
                mem[(i, j)] = helper(i - 1, j - 1)
            else:
                mem[(i, j)] = min(helper(i - 1, j - 1), helper(i - 1, j), helper(i, j - 1)) + 1
            return mem[(i, j)]

        return helper(len(word1) - 1, len(word2) - 1)

    def minDistance(self, word1: str, word2: str) -> int:
        n1 = len(word1)
        n2 = len(word2)
        dp = [(n2 + 1) * [0] for _ in range(n1 + 1)]

        for i in range(1, n1 + 1):
            dp[i][0] = dp[i - 1][0] + 1
        for j in range(1, n2 + 1):
            dp[0][j] = dp[0][j - 1] + 1

        for i in range(1, n1 + 1):
            for j in range(1, n2 + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(
                        dp[i - 1][j - 1],
                        dp[i][j - 1],
                        dp[i - 1][j]
                    ) + 1
        return dp[-1][-1]


# leetcode submit region end(Prohibit modification and deletion)
Solution().minDistance("horse",
                       "ros")
