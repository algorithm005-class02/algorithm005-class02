class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        UnionFind uf = new UnionFind(m*n+1);
        int dummyNode = m * n;

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        int pos = i * n + j;
                        uf.union(pos, dummyNode);
                        continue;
                    }

                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                            int pos1 = i * n + j;
                            int pos2 = x * n + y;
                            uf.union(pos1, pos2);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int pos = i * n + j;
                if (uf.isConnected(pos, dummyNode)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
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