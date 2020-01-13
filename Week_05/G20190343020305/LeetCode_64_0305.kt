//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划




//leetcode submit region begin(Prohibit modification and deletion)
import kotlin.math.min

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val dp = IntArray(m) { grid[0][0] }
        for (i in 1 until m)
            dp[i] = dp[i - 1] + grid[i][0]
        for (j in 1 until grid[0].size) {
            dp[0] += grid[0][j]
            for (i in 1 until m)
                dp[i] = min(dp[i - 1], dp[i]) + grid[i][j]
        }
        return dp[m - 1]
    }
}
//leetcode submit region end(Prohibit modification and deletion)
