class Solution {
    public int findCircleNum(int[][] m) {
        if (m == null || m.length < 1) {
            return 0;
        }

        UnionFind uf = new UnionFind(m.length);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 1) {
                    uf.union(i, j);
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