class Solution {
    public int climbStairs(int n) {
        int s = 1,t = 2,res = 0;
        if(n == 1) return s;
        if(n == 2) return t;
        for(int i = 3; i < n + 1; i++){
            res = s + t;
            s = t;
            t = res;
        }
        return res;
    }
}
