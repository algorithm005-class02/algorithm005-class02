package com.dp;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int solutionLG(int n, int stepBefore) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            if (stepBefore == 1) {
                return 0;
            } else {
                return 1;
            }
        } else if (n == 2) {
            if (stepBefore == 2) {
                return 0;
            } else {
                return 1;
            }
        } else if (n == 3) {
            if (stepBefore == 3 || stepBefore == 2 || stepBefore == 1) {
                return 2;
            } else {
                return 3;
            }
        }
        int total = 0;
        if (stepBefore == 1) {
            total = solutionLG(n - 2, 2) + solutionLG(n - 3, 3);
        } else if (stepBefore == 2) {
            total = solutionLG(n - 1, 1) + solutionLG(n - 3, 3);
        } else if (stepBefore == 3) {
            total = solutionLG(n - 1, 1) + solutionLG(n - 2, 2);
        } else {
            total = solutionLG(n - 1, 1) + solutionLG(n - 2, 2) + solutionLG(n - 3, 3);
        }
        return total;
    }
}
