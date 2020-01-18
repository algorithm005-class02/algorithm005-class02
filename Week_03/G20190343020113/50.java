class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastpow(x,n);
    }

    public double fastpow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastpow(x, n/2);
        return n%2 == 0 ? half * half : half * half * x;
    }
}