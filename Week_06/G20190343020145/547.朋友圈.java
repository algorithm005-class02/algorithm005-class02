class Solution {
    public int findCircleNum(int[][] M){
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0;i < n - 1; ++ i){
            for(int j = 1;j < n; ++ j){
                if(M[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        return uf.getCount();
    }

}

class UnionFind{
    private int count;
    private  int[] parent;
    public UnionFind(int n){
        count = n;
        parent = new int[n];
        for(int i = 0;i < n; ++i){
            parent[i] = i;
        }
    }
    public int find(int p){
        while (parent[p] != p){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public  void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        parent[rootP] = rootQ;
        count --;
    }

    public  int getCount(){
        return count;
    }
}