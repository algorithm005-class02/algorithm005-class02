class Solution {
    public boolean isPerfectSquare(int x) {
        // 其实就是69题最后输出判断是否相等
        long res = x;
        while (res * res > x) {
            res = (res + x / res) >>> 1;
        }
        return res * res == x;
    }
}