/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 * 1. dfs，以找到的第一个'1'的格子为root结点，向下（周围（上下左右））找为'1'的格子
 * 2. bfs，
 */

// @lc code=start
class Solution {
    // 1.dfs
    public void DFS(char[] [] grid, int r, int c) {

        // 终止条件，当周围某个方向的格子为0时结束此层递归
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') return;

        grid[r][c] = '0';  // 将访问过的格子标记为0
        // 深度优先搜索周围（上下左右）的格子
        DFS(grid, r - 1, c);
        DFS(grid, r + 1, c);
        DFS(grid, r, c - 1);
        DFS(grid, r, c + 1);
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        // 网格高宽
        int nr = grid.length;
        int nc = grid[0].length;
        int num_isLands = 0; // 岛屿数量

        // 递归入口，遍历网格出现1时，进入递归，将其周围为1的格子标记为0
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_isLands;
                    DFS(grid, r, c);
                }
                
            }
        }
        return num_isLands;
    }

}
// @lc code=end

