class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int[] parent = new int[m*n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int pos = i * n + j;
                    parent[pos] = pos;
                    count++;
                }
            }
        }

        UnionFind uf = new UnionFind(parent, count);

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                            int pos1 = i * n + j;
                            int pos2 = x * n + y;
                            uf.union(pos1, pos2);
                        }
                    }
                }
            }
        }

        return uf.count();
    }

}

public class UnionFind {
    private int count = 0;
    private int[] parents;

    public UnionFind(int n) {
        this.count = n;
        this.parents = new int[n];
        for (int i = 0; i < n; i++) {
            this.parents[i] = i;
        }
    }

    public UnionFind(int[] parents, int count) {
        this.count = count;
        this.parents = parents;
    }

    public int find(int x) {
        while (x != this.parents[x]) {
            this.parents[x] = this.parents[this.parents[x]];
            x = this.parents[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootP = this.find(p);
        int rootQ = this.find(q);
        if (rootP == rootQ) {
            return;
        }
        this.parents[rootP] = rootQ;
        count--;
    }

    public boolean isConnected(int x, int y) {
        return this.find(x) == this.find(y);
    }

    public int count() {
        return this.count;
    }

}