class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> value(m);
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                int ways = 0;
                if(i > 0) ways += value[j];
                if(j > 0) ways += value[j-1];
                if(j == 0) ways = 1;
                value[j] = ways;
            }
        }
        return value[m-1];
    }
};