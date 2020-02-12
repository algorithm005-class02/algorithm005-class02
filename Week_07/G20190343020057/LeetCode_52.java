class Solution {
    private int count;

    public int totalNQueens(int n) {
        int cols = 0;
        int pie = 0;
        int na = 0;
        DFS(n,0,cols,pie,na);
        return count;
    }

    private void DFS(int n, int row, int cols, int pie, int na){
        if(row >= n) {
            count++;
            return;
        }
        int pos = (~(cols|pie|na)) & ((1<<n)-1);  //当前层可以实现的位置
        while (pos!=0){
            int p = pos & (-pos);  //负数是取反再加1.等于获取最低的1位置
            pos = pos &(pos-1); //更新pos，把最低的1位置置0
            DFS(n, row+1, cols|p, (pie|p)<<1, (na|p)>>1); //更新los,pie,na
        }
    }
}