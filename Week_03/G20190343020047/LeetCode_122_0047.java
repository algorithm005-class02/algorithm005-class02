class Solution {
    public int maxProfit(int[] prices) {
        int currentPrices = 0;

        for (int i = 1;i<prices.length;++i) {
            //当天价格大于前天价格，则有赚
            if (prices[i] > prices[i-1]) {
                currentPrices += prices[i]-prices[i - 1]; 
            }
        }
        return currentPrices;
    }
}