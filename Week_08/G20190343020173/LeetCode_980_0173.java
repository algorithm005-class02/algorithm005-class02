package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_980_UniquePaths3 {

    class Solution {
        public int uniquePathsIII(int[][] g) {
            int x = 0, y = 0, empty = 0;
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[0].length; j++) {
                    if (g[i][j] == 0) empty++;
                    else if (g[i][j] == 1) {
                        x = i;
                        y = j;
                    }
                }
            }
            return dfs(g, x, y, -1, empty);
        }

        private int dfs(int[][] g, int x, int y, int count, int need) {
            if (x < 0 || x == g.length || y < 0 || y == g[0].length || g[x][y] == -1) return 0;
            if (g[x][y] == 2) {
                if (count == need) return 1;
                else return 0;
            }
            g[x][y] = -1;
            int tatal = dfs(g, x - 1, y, count + 1, need);
            tatal += dfs(g, x + 1, y, count + 1, need);
            tatal += dfs(g, x, y - 1, count + 1, need);
            tatal += dfs(g, x, y + 1, count + 1, need);
            g[x][y] = 0;

            return tatal;
        }
    }
}
