public class Solution { 
    public int countSubString(String s) {
        int ret = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; ++i) {
            for (int j = i; j > 0; j--) {
                if (s.charAt(j) == s.charAt(i) && ((i-j < 2) || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    ret++;
                }
            }
        } 
        return ret;
    }
}
