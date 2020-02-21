package leetcode

/*
 * @lc app=leetcode.cn id=221 lang=golang
 *
 * [221] 最大正方形
 *
 * https://leetcode-cn.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (38.66%)
 * Likes:    203
 * Dislikes: 0
 * Total Accepted:    18.7K
 * Total Submissions: 48K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 */

// @lc code=start
func maximalSquare(matrix [][]byte) int {
	if len(matrix) == 0 {
		return 0
	}
	row, col := len(matrix), len(matrix[0])
	dp, ret, prev := make([]int, col), 0, 0

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			tmp := dp[j]
			if i == 0 || j == 0 || matrix[i][j] == '0' {
				dp[j] = int(matrix[i][j] - '0')
			} else {
				dp[j] = min(prev, min(dp[j], dp[j-1])) + 1
			}
			if ret < dp[j] {
				ret = dp[j]
			}
			prev = tmp
		}
	}

	return ret * ret
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

// @lc code=end
