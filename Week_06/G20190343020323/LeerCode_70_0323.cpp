class Solution {
public:
    int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        // return climbStairs(n-1) + climbStairs(n-2);
        // int *value = new int[n+1];
        int a = 1,b = 2;
        for(int i = 3;i<=n;++i){
            a = a + b;
            swap(a,b);
        }
        return b;
    }
};