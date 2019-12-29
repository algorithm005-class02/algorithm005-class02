class Solution {
    public int mySqrt(int x) {
        return sqrttt(0,x,x);
    }

    public int sqrttt(double s, double t, int x){
        if((int)s == (int)t) return (int)s;
        if(s*s == x) return (int)s;
        if(t*t == x) return (int)t;
        int res = 0;
        double tmp = (t+s)/2;
        if(tmp*tmp > x) res = sqrttt(s,tmp,x);
        else res = sqrttt(tmp,t,x);
        return res;
    }
}
