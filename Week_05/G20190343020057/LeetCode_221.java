class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int m = matrix.length; 
        int n = matrix[0].length; 
        //O(m*n)的空间复杂度
        // int[][] dp = new int[m+1][n+1]; //增加1行1列，不用处理边界条件
        // int maxB = 0;
        // for(int i=0;i<m; i++){
        //     for(int j=0 ; j<n;j++){
        //         if(matrix[i][j] == '1'){
        //             dp[i+1][j+1] = Math.min(Math.min(dp[i][j],dp[i][j+1]),dp[i+1][j])+1; //利用对角线来更新最大正方形，必须左，上，左上同时是一个数，正方形边长才可以加1，不然取三者中的最小值  
        //             maxB = Math.max(maxB,dp[i+1][j+1]);
        //         }
        //     }
        // }
        // return maxB*maxB;


        //优化存储空间
        // 
        int maxB = 0;
        int[] dpw = new int[n+1];  //将存储空间简化到1行
        int pre = 0;

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                int temp = dpw[j+1];  //另行保存左上的元素，对应到循环体的上一次dp[j+1],而不是dp[j],因为操作索引经过来一次右移。
                if(matrix[i][j]=='1'){
                    dpw[j+1] = Math.min(Math.min(dpw[j],dpw[j+1]),pre) + 1;
                    maxB = Math.max(maxB, dpw[j+1]);
                }
                pre = temp;
                
            }
        }
    return maxB * maxB;


    }
}