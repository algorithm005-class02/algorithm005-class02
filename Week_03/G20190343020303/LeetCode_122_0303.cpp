class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size() == 0)
        {
            return 0;
        }
        int sum = 0;
        for (int i = 1;i < prices.size();++i) {
            if(prices[i-1] < prices[i]){
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }
}; 