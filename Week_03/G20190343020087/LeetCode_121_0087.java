import java.time.temporal.Temporal;

/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 * 贪心算法的解法是：有利润就买，没有利润就不买
 * 只要明天的售价大于今天的售价，那么就买今天的明天再售出
 * 得到每次的利润加起来就是最大利润
 * 可以看做是一个折线图，最低点到最高点的距离等同于每一步上升的距离（有利润）
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }
}
// @lc code=end

