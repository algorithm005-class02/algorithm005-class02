public class LeetCode_0231_091 {

    public static void main(String[] args) {
        String n ="23156";

        int result = new LeetCode_0231_091.Solution().numDecodings(n);

        System.out.println(result);

    }

    /**
     * 解码方法
     * LeetCode: https://leetcode-cn.com/problems/decode-ways/
     */
    static class Solution {
        /**
         * 动态规划
         * @param s
         * @return
         */
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int len = s.length();

            int help = 1;
            int res = 0;
            if (s.charAt(len - 1) != '0') {
                res = 1;
            }
            for (int i = len - 2; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    help = res;
                    res = 0;
                    continue;
                }
                if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                    res += help;
                    //help用来存储res以前的值
                    help = res-help;
                } else {
                    help = res;
                }

            }
            return res;
        }

    }

}
