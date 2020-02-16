class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null) return false;
        int s_len = s.length();
        int p_len = p.length();
        boolean[][] dp = new boolean[s_len+1][p_len+1];
        dp[0][0] = true;//推导dp[1][1]使用

        //初始条件
        for(int i = 0; i<p_len;i++){
            if(p.charAt(i)=='*'){
                dp[0][i+1] = dp[0][i];   //模式串只有*打头才能传递
            }else{
                break;
            }
        }

        for(int i=0; i<s_len;i++){
            for(int j=0;j<p_len;j++){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
                    dp[i+1][j+1] = dp[i][j]; //字符相等或者是？匹配，则等于两个同时减1
                }
                else if(p.charAt(j)=='*'){
                    dp[i+1][j+1] = dp[i][j+1]||dp[i+1][j]; //可以是空匹配，也可以是任意字符
                }
            }
        }
        return dp[s_len][p_len];
    }
}