package algorithm.leetcode.动态规划;

public class L62_unique_path {




    public int uniquePaths(int m, int n) {

        return _uniquePathBP(m,n);
        //return _uniquePaths(1,1,m,n);
    }

    /**
     * DP回溯算法
     * @param m
     * @param n
     * @return
     */
    private int _uniquePathBP(int m,int n){
        int[][] opt = null;
        opt = new int[m][n];
        for(int i=0;i<n;i++){
            opt[m-1][i]=1;
        }
        for(int i=0;i<m;i++)
        {
            opt[i][n-1]=1;
        }


        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){

                int left=0;
                int down=0;
                left=opt[i+1][j];
                down = opt[i][j+1];
                opt[i][j]=left+down;


            }
        }
        return opt[0][0];

    }

    /**
     * 方法1  dummy recursive 提交会超出时间限制，加上缓存能好很多
     * @param startx
     * @param starty
     * @param m
     * @param n
     * @return
     */

    private int _uniquePaths(int startx,int starty, int m,int n){
        if(startx==m&&starty==n){
            return 1;
        }
        int p1=0,p2=0;
        if(startx+1<=m){
            p1=_uniquePaths(startx+1,starty,m,n);
        }
        if(starty+1<=n){
            p2=_uniquePaths(startx,starty+1,m,n);
        }
        return p1+p2;
    }



    public static void main(String args[]){
        L62_unique_path up = new L62_unique_path();
        System.out.println(up.uniquePaths(19,13));
    }
}
