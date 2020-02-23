import java.util.Map;

/**
 * 72.编辑距离
 */
public class LeetCode_72_0299 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(new LeetCode_72_0299().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int size1 = word1.length();
        int size2 = word2.length();
        // 初始化dp数组
        int[][] dp = new int[size1 + 1][size2 + 1];
        for (int i = 0; i <= size1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= size2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[size1][size2];
    }
}
