import java.util.LinkedList;

/**
 * 零钱兑换
 * https://leetcode.com/problems/coin-change/
 */
public class Leetcode_322_coinChange {
    /**
     * 方法1：递归 + 记忆化搜索
     */
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount + 1]);
    }

    private int helper(int[] coins, int amount, int[] min) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (min[amount] != 0) {
            return min[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int i : coins) {
            int tmp = helper(coins, amount - i, min);
            if (tmp >= 0 && tmp < res) {
                res = tmp + 1;
            }
        }

        if (res == Integer.MAX_VALUE) {
            return min[amount] = -1;
        } else {
            return min[amount] = res;
        }
    }

    /**
     * 方法2：BFS
     * 相当于找符合条件的状态树的最小深度
     */

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        boolean[] visited = new boolean[amount + 1];
        visited[amount] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curAmount = queue.poll();


                for (int co : coins) {
                    int newAmount = curAmount - co;
                    if (newAmount == 0) {
                        return level + 1;
                    } else if (newAmount > 0 && !visited[newAmount]) {
                        visited[newAmount] = true;
                        queue.offer(newAmount);
                    }
                }
            }
            level++;
        }
        return -1;
    }


    /**
     * 方法3：DP
     */
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE - 1;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    min = Math.min(dp[i - coin] + 1, min);
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        Leetcode_322_coinChange solution = new Leetcode_322_coinChange();
        System.out.println(solution.coinChange(coins, amount));
        System.out.println(solution.coinChange2(coins, amount));
        System.out.println(solution.coinChange3(coins, amount));
    }
}
