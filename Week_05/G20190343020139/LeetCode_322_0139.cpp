/*
 * @lc app=leetcode.cn id=322 lang=cpp
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (37.07%)
 * Likes:    346
 * Dislikes: 0
 * Total Accepted:    38.4K
 * Total Submissions: 103.1K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3 
 * 解释: 11 = 5 + 5 + 1
 * 
 * 示例 2:
 * 
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * 
 */

// @lc code=start
class Solution {
public:
int coinChange(vector<int>& coins, int amount) {
    vector<int> dp(amount + 1, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
        for (int coin : coins)
            if (coin <= i)
                dp[i] = min(dp[i], dp[i - coin] + 1);
    }
    return dp[amount] > amount ? -1 : dp[amount];
}

/**
int coinChange(vector<int>& coins, int amount) {
    if (amount == 0) return 0;
    int ans = INT_MAX;
    for (int coin : coins) {
        // 金额不可达
        if (amount - coin < 0) continue;
        int subProb = coinChange(coins, amount - coin);
        // 子问题无解
        if (subProb == -1) continue;
        ans = min(ans, subProb + 1);
    }
    return ans == INT_MAX ? -1 : ans;
}
*/
/**
    int coinChange(vector<int>& coins, int amount) {
        int dp[amount+1];
        for(int i = 0; i <= amount; i++) dp[i] = -1;
        if(amount == 0) return 0;
        return helper(coins,amount,dp);
    }
private:
    int helper(vector<int>& coins, int amount, int *dp){
        if(dp[amount] >= 0) return dp[amount];
        int min = INT_MAX;
        int result = 0;
        vector<int> unavail(coins.size(),0);
        for(int i = 0; i < coins.size(); i++){
            if(amount == coins[i]){
                return 1;
            } else if(amount > coins[i]){
                int temp = helper(coins, amount-coins[i], dp);
                if(temp < 0) unavail[i] = 1;
                else {
                    min = (temp + 1) < min ? (temp + 1) : min;
                    //cout << "min:"<<min<<endl;
                }

            } else {
                unavail[i] = 1;
            }
        }
        for(int i = 0; i < coins.size(); i++){
            if(unavail[i] == 0){
                result = 1;
                break;
            }
                
        }
        
        if(result == 1) {
            dp[amount] = min;
            return dp[amount];
        }
        else return -1;

    }
    */
};
// @lc code=end

