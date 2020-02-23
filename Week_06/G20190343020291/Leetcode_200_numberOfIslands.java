import java.util.LinkedList;

/**
 * 岛屿数量
 * https://leetcode.com/problems/number-of-islands/
 */
public class Leetcode_200_numberOfIslands {
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * 方法1：DFS
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        if (null == grid || grid.length == 0) {
            return num;
        }
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    num++;
                }
            }
        }
        return num;
    }


    private void dfs(char[][] grid, int i, int j, int m, int n) {
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newJ >= 0 && newI < m && newJ < n && grid[newI][newJ] == '1') {
                dfs(grid, newI, newJ, m, n);
            }
        }
    }

    /**
     * 方法2：BFS
     */
    public int numIslands2(char[][] grid) {
        int num = 0;
        if (null == grid || grid.length == 0) {
            return num;
        }
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, m, n);
                    num++;
                }
            }
        }
        return num;
    }


    private void bfs(char[][] grid, int i, int j, int m, int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(i * n  + j);
        grid[i][j] = '0'; // 必须add的时候置零，不能出队列的时候置零，会死循环

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int row = index / n;
            int col = index % n;

            for (int[] dir : dirs) {
                int newI = row + dir[0];
                int newJ = col + dir[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == '1') {
                    queue.add(newI * n + newJ);
                    grid[newI][newJ] = '0';
                }
            }
        }
    }

    /**
     * 方法3：并查集
     */
    public int numIslands3(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, uf, i, j, m, n);
                }
            }
        }
        return uf.count;
    }

    private void dfs(char[][] grid, UnionFind uf, int i, int j, int m, int n) {
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newJ >= 0 && newI < m && newJ < n && grid[newI][newJ] == '1') {
                uf.union(i * n + j, newI * n + newJ);
            }
        }
    }

    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length, n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        parent[i * n + j] =  i * n + j;
                    }
                }
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
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Leetcode_200_numberOfIslands solution = new Leetcode_200_numberOfIslands();
        System.out.println(solution.numIslands2(grid));
    }
}
