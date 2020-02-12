import java.util.Arrays;

import javafx.scene.canvas.GraphicsContext;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != '0') {
                    if (i + 1 < grid.length && grid[i + 1][j] != '0') {
                        unionFind.union(i * grid[0].length + j, ((i + 1) * grid[0].length) + j);
                    }
                    if (j + 1 < grid[i].length && grid[i][j + 1] != '0') {
                        unionFind.union(i * grid[0].length + j, i * grid[0].length + j + 1);
                    }    
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < unionFind.parent.length; i++) {
            if (unionFind.parent[i] == -1) cnt++;
        }
        return cnt;
    }

    class UnionFind {

        private int[] parent;

        public UnionFind(char[][] grid) {

            parent = new int[grid.length * grid[0].length];
            Arrays.fill(parent, -2);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != '0') {
                        parent[i * grid[0].length + j] = -1;
                    }
                }
            }
        }

        public int find(int i) {
            if (parent[i] == -1 || parent[i] == -2) return i;
            return find(this.parent[i]);
        }

        public void union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot != jRoot) this.parent[jRoot] = iRoot;
        }

        
        public void print() {
            System.out.println(Arrays.toString(this.parent));
        }
    }
}
// @lc code=end

