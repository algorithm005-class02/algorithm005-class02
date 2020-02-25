/**
 * 最长公共子序列
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class Leetcode_143_longestCommonSubsequence {

    /**
     * 方法1: "傻"递归
     * (会超时)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();

        return helper(text1Arr, text2Arr, text1Arr.length - 1, text2Arr.length - 1);
    }

    private int helper(char[] arr1, char[] arr2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (arr1[i] == arr2[j]) {
            return helper(arr1, arr2, i - 1, j - 1) + 1;
        } else {
            return Math.max(helper(arr1, arr2, i - 1, j), helper(arr1, arr2, i, j-1));
        }
    }
    /**
     * 方法2： 记忆化搜索
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();
        int m = text1Arr.length;
        int n = text2Arr.length;

        return helper(text1Arr, text2Arr, m - 1, n - 1, new int[m][n]);
    }

    private int helper(char[] arr1, char[] arr2, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        if (arr1[i] == arr2[j]) {
            return helper(arr1, arr2, i - 1, j - 1, memo) + 1;
        } else {
            return memo[i][j] = Math.max(helper(arr1, arr2, i - 1, j, memo), helper(arr1, arr2, i, j-1, memo));
        }
    }

    /**
     * 方法3：Bottom Up
     */
    public int longestCommonSubsequence3(String text1, String text2) {
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();
        int m = text1Arr.length;
        int n = text2Arr.length;

        int[][] dp = new int[m][n];
        dp[0][0] = text1Arr[0] == text2Arr[0] ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = text1Arr[i] == text2Arr[0] ?  1 : Math.max(dp[i - 1][0], 0);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = text1Arr[0] == text2Arr[i] ? 1 : Math.max(dp[0][i - 1], 0);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1Arr[i] == text2Arr[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 方法3：Bottom Up
     * 二维数组优化版，不初始化第一行和第一行，多存储一行一列
     */
    public int longestCommonSubsequence4(String text1, String text2) {
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();
        int m = text1Arr.length;
        int n = text2Arr.length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1Arr[i - 1] == text2Arr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "mhunuzqrkzsnidwbun";
        String s2 = "szulspmhwpazoxijwbq";
        long timeBegin = System.currentTimeMillis();
        Leetcode_143_longestCommonSubsequence solution = new Leetcode_143_longestCommonSubsequence();
        System.out.println(solution.longestCommonSubsequence(s1, s2));
        System.out.println(System.currentTimeMillis() - timeBegin);
    }
}
