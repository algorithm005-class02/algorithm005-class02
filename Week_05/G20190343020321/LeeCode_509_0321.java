class LeeCode_509_0321 {
    /**
     * fib
     * 斐波那契数
     */
    public static void main(String[] args) {
        int n = 16;
        int fib = new Solution().fib(n);
        System.out.printf("fib %d:%d%n", n, fib);

    }

    static class Solution {

        /**
         * 存储中间值，自底向上
         *
         * @param N
         * @return
         */
        public int fib(int N) {
            if (N <= 1) {
                return N;
            }
            int last = 0, midle = 1, result = 0;
            for (int i = 2; i <= N; i++) {
                result = last + midle;
                last = midle;
                midle = result;
            }
            return result;
        }

        /**
         * 纯递归
         *
         * @param N
         * @return
         */
        public int fib_1(int N) {
            if (N <= 1) {
                return N;
            }
            return fib(N - 2) + fib(N - 1);
        }
    }
}


