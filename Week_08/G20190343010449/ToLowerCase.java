class Solution {
    public String toLowerCase(String str) {
        char[] ans = str.toCharArray();
        for (int i = 0; i < ans.length; i++) {
            if ('A' <= ans[i] && ans[i] <= 'Z') {
                ans[i] = (char) (ans[i] - 'A' + 'a');
            }
        }
        return new String(ans);
    }
}