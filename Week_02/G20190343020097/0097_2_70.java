//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        int[] stairs = new int[n + 1];
        for (int i = 0; i < n; i++) {
            stairs[i] = getStairs(i, stairs);
        }
        return stairs[n - 1];
    }

    public int getStairs(int n, int[] stairs) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else if (n > 1) {
            return stairs[n - 1] + stairs[n - 2];
        } else {
            return 0;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
