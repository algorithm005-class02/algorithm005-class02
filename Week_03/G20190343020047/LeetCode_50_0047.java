class Solution {
    public double myPow(double x, int n) {
        //1.暴力求解 库函数
        //return Math.pow(x, n);
        //2.分治
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        //n为0的幂次为1.0
        double result = 1.0;
        for (int i = n;i != 0;i /= 2) {
            if (i % 2 != 0) {
                result *= x;
            }
            x *= x;
        }
        return n < 0 ? 1.0 / result : result;
    }
}