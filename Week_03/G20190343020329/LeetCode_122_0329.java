class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int in = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            if (prices[i + 1] > prices[i]) {
                in += (prices[i + 1] - prices[i]);
            }
        }
        return in;
    }
}