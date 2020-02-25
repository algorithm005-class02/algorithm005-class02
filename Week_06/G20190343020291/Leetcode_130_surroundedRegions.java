/**
 * 被围绕的区域
 * https://leetcode.com/problems/surrounded-regions/
 */
public class Leetcode_130_surroundedRegions {
    /**
     * 方法1：DFS
     */
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void  solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, m, n);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1, m, n);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, m, n);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i, m, n);
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1], m, n);
        }
    }

    /**
     * 方法2：并查集
     */
    public void solve2(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length, n = board[0].length;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = i * n + j;
                if (board[i][j] == 'X') {
                    continue;
                } else if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    uf.union(0, cur);
                } else {
                    for (int[] dir : dirs) {
                        int newI = i + dir[0];
                        int newJ = j + dir[1];
                        if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && board[newI][newJ] == 'O') {
                            uf.union(cur, newI * n + newJ);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && uf.find(i * n + j) != uf.find(0)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }
    }

    public static void main(String[] args) {
        Leetcode_130_surroundedRegions solution = new Leetcode_130_surroundedRegions();
        char[][] board = {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        solution.solve2(board);
    }

}
