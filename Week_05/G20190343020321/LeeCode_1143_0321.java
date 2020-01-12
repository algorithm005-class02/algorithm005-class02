class LeeCode_1143_0321 {
    /**
     * longestCommonSubsequence
     * 最长公共子序列
     */
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int count = new Solution().longestCommonSubsequence(str1, str2);
        System.out.println(count);

    }

    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] ch1 = text1.toCharArray();
            char[] ch2 = text2.toCharArray();
            int[][] dp = new int[ch1.length + 1][ch2.length + 1];

            for (int i = 1; i < ch1.length + 1; i++) {
                for (int j = 1; j < ch2.length + 1; j++) {
                    //尾部相同
                    if (ch1[i - 1] == ch2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        //尾部不同
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[ch1.length][ch2.length];
        }
    }
}


