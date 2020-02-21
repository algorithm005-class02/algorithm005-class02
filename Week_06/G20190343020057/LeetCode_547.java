class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UF uf = new UF(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        return uf.countN();
    }
}

//并查集的类
class UF{
    private int count;  //并查集的节点数量
    private int[] parent;//并查集节点的父节点
    private int[] size;//并查集节点的数量

    //初始化
    public UF(int n){
        count = n;
        parent = new int[count];
        size = new int[count];

        for(int i=0; i<count;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    //合并树
    public void union(int tree1, int tree2){
        int rootTree1 = find(tree1);
        int rootTree2 = find(tree2);
        if(rootTree1 == rootTree2) return;
        if(size[rootTree1]>size[rootTree2]){//总是将长度短的树合并到长度长的树上，防止出现不平衡现象
            parent[rootTree2] = rootTree1;
            size[rootTree1] += size[rootTree2];
        }else{
            parent[rootTree1] = rootTree2;
            size[rootTree2] += rootTree1;
        }
        count--;
    }

    //找父节点
    public int find(int node){//在查找父节点的同时缩短长度，将下面点的parent往上跳1级
        while(parent[node] != node){
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

    //返回连通量
    public int countN(){
        return count;
    }

    //返回两点之间是否联通
    public boolean connected(int tree1, int tree2){
        int rootTree1 = find(tree1);
        int rootTree2 = find(tree2);
        return rootTree1 == rootTree2;
    }
}
