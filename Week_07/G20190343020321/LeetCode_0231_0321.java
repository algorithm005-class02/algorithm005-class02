public class LeetCode_0231_0321 {

    public static void main(String[] args) {
        int n = 54;

        boolean result = new LeetCode_0231_0321.Solution().isPowerOfTwo(n);

        System.out.println(result);

    }

    /**
     * 2的幂
     * LeetCode: https://leetcode-cn.com/problems/power-of-two/solution/2de-mi-by-leetcode/
     */
    static class Solution {
        /**
         * 方法一 ：位运算：保留二进制中最右边的 1
         * 通过 x & (-x) 保留最右边的 1，并将其他位设置为 0 若 x 为 2 的幂，则它的二进制表示中只包含一个 1，则有 x & (-x) = x。
         * <p>
         * 若 x 不是 2 的幂，则在二进制表示中存在其他 1，因此 x & (-x) != x。
         * <p>
         * 因此判断是否为 2 的幂的关键是：判断 x & (-x) == x。
         *
         * @param n
         * @return
         */
        public boolean isPowerOfTwo(int n) {
            if (n == 0) {
                return false;
            }
            long x = (long) n;
            return (x & (-x)) == x;
        }

        /**
         * 方法二 ：位运算：去除二进制中最右边的 1
         * 使用x & (x - 1) 去除二进制中最右边的 1，
         * 2的幂二进制表示只含有一个 1。
         * x & (x - 1) 操作会将 2 的幂设置为 0，因此判断是否为 2 的幂是：判断 x & (x - 1) == 0。
         *
         * @param n
         * @return
         */
        public boolean isPowerOfTwo_1(int n) {
            if (n == 0) {
                return false;
            }
            long x = (long) n;
            return (x & (x - 1)) == 0;
        }
    }

}
