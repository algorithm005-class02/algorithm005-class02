class Solution {
    public int longestValidParentheses(String s) {
        int[] cnt = new int[s.length() + 101];
        char[] ca = s.toCharArray();
        int len = ca.length;
        for (int i = 0;i < len;i++) {
            if (ca[i] == ')') {
                if (i > 0 && ca[i - 1] == '(') {
                    cnt[i] = (i > 1 ? cnt[i - 2] : 0) + 2;
                } else if (i > 0 && ca[i - 1] == ')') {
                    if ((i - cnt[i - 1]) > 0 ? (ca[i - cnt[i -1] - 1] == '(') : false) {
                        cnt[i] = cnt[i - 1] + ((i - cnt[i - 1]) > 1 ? (cnt[i - cnt[i - 1] - 2]) : 0) + 2;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0;i < len;i++) {
            max = max > cnt[i] ? max : cnt[i];
        }
        return max;
    }
}