class Solution {
    class UnionFind {
    private int[] parent;
    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        count = n;
    }

    public int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

        public void union(int p, int q) {
        int unionP = find(p);
        int unionQ = find(q);
        if (unionP == unionQ) {
            return;
        }
        parent[unionQ] = unionP;
        count--;
    }

    public int getCount() {
        return count;
    }
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }
}
