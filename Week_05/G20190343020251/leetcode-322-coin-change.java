class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] pros = new int[amount+1];
        for (int i=1; i<=amount; i++) {
            int ans = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin) {
                    if (pros[i-coin] == -1) continue;
                    ans = Math.min(ans, pros[i-coin] + 1);
                }
            }
            pros[i] = ans==Integer.MAX_VALUE ? -1 : ans;
        }
        return pros[amount];
    }
}
