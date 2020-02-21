class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for(int i=1;i<=num;i++){
            dp[i] = dp[i&(i-1)]+1;//最后有效位+1
        }
        return dp;
    }
}