class Solution(object):
    def maxSumSubmatrix(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        res = -2147483648
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for i in range(n)] for i in range(m)]
        for c in range(1, m):
            for d in range(1, n):
                dp[c][d] = matrix[c][d] + dp[c-1][d] + dp[c][d-1] - dp[c-1][d-1]
                for a in range(1, c):
                    for b in range(1, d):
                        tmp = dp[c][d] - dp[a-1][d] - dp[c][b-1] + dp[a-1][b-1]
                        if tmp <= k:
                            res = tmp if k - tmp < k - res else res
        return res
