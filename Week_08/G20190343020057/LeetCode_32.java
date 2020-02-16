class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()<=1) return 0;
        int[] dp = new int[s.length()];
        int maxL = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==')' && i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='('){
                //没有分开dp[i-1]是否为‘(’，因为在‘(’的时候dp[i-1]=0
                //下面的公式会变成dp[i] = dp[i-1] + 2 + dp[i-2] = dp[i-2] + 2;
                dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2>=0 ? dp[i-dp[i-1]-2] : 0);
                maxL = Math.max(maxL,dp[i]);
            }
        }
        return maxL;
    }
}
