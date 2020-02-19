class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int n = obstacleGrid.size();
        if(n == 0) return 0;
        int m = obstacleGrid[0].size();
        vector<long long> value(m);
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                long long ways = 0;
                if(obstacleGrid[i][j] == 1) ways = 0;
                else{
                    if(j == 0){
                        if(i==0) value[0] = 1;
                        ways = value[0];  
                    } 
                    else{
                        if(i > 0) ways += value[j];
                        ways += value[j-1];
                    }
                }
                value[j] = ways;
            }
        }
        return value[m-1];
    }
};