/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (46.10%)
 * Likes:    316
 * Dislikes: 0
 * Total Accepted:    46K
 * Total Submissions: 99.1K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start

class Solution {
    int dx[] = new int[]{-1,1,0,0};
    int dy[] = new int[]{0,0,-1,+1};
    char[][] g;
    public int numIslands(char[][] grid) {
        int islands = 0;
        g = grid;
        for(int i = 0;i < grid.length; ++ i)
            for(int j =0;j < grid[i].length; ++ j){
                if(grid[i][j] == '0') continue;
                islands += sink(i,j);
            }       
        return islands;

    }

    int sink(int i, int j) {
        //teminator,如果当前值为0，那么返回递归上一层
        if(g[i][j] == '0') return 0;
        //下层陆地
        g[i][j] = '0';
        //遍历陆地周围所有陆地
        for(int k = 0; k < 4; ++ k){
            int x = i + dx[k], y = j + dy[k];
            if(x >= 0 && x < g.length && y >= 0 && y < g[i].length){
                if(g[x][y] == '0') continue;
                sink(x,y);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        char chars[][] = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(sl.numIslands(chars));
    }
}

// @lc code=end

