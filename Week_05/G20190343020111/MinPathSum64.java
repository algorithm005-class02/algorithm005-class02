package com.solution;

/*
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum64 {

	public static void main(String[] args) {

		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int x = new MinPathSum64().minPathSum3(grid);
		System.out.println(x);
	}

	// DP方程：dp[i][j]= min(dp[i-1][j],dp[i][j-1])+grid[i][j]
	public int minPathSum(int[][] grid) {
		int x = grid[0].length;
		int y = grid.length;
		int[][] dp = new int[x][y];

		for (int j = y - 1; j >= 0; j--) {
			for (int i = x - 1; i >= 0; i--) {
				if (i == x - 1 && j == y - 1) {
					dp[i][j] = grid[i][j];
				} else if (i == x - 1 && j != y - 1) {
					dp[i][j] = dp[i][j + 1] + grid[i][j];
				} else if (j == y - 1 && i != x - 1) {
					dp[i][j] = dp[i + 1][j] + grid[i][j];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
				}
			}
		}
		return dp[0][0];
	}

	// 一维数组存储中间状态
	public int minPathSum2(int[][] grid) {
		int x = grid[0].length;
		int y = grid.length;
		int[] dp = new int[x];

		for (int j = y - 1; j >= 0; j--) {
			for (int i = x - 1; i >= 0; i--) {
				if (i == x - 1 && j == y - 1) {
					dp[j] = grid[i][j];
				} else if (i == x - 1 && j != y - 1) {
					dp[j] = dp[j + 1] + grid[i][j];
				} else if (j == y - 1 && i != x - 1) {
					dp[j] = dp[j] + grid[i][j];
				} else {
					dp[j] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
				}
			}
		}
		return dp[0];
	}

	// 输入数组存储中间状态
	public int minPathSum3(int[][] grid) {
		int x = grid[0].length;
		int y = grid.length;

		for (int j = y - 1; j >= 0; j--) {
			for (int i = x - 1; i >= 0; i--) {
				if (i == x - 1 && j == y - 1) {
					grid[i][j] = grid[i][j];
				} else if (i == x - 1 && j != y - 1) {
					grid[i][j] = grid[i][j + 1] + grid[i][j];
				} else if (j == y - 1 && i != x - 1) {
					grid[i][j] = grid[i + 1][j] + grid[i][j];
				} else {
					grid[i][j] = Math.min(grid[i + 1][j], grid[i][j + 1]) + grid[i][j];
				}
			}
		}
		return grid[0][0];
	}

}
