public class Solution {
    public String reverseStringII(String s, int k) {
        String ans = new String("");
        int l = s.length();
        int i, j;
        for (i = 0;i < l;i += 2 * k) {
            for (j = Math.min(l - 1, i + k - 1);j >= i;j--) ans = ans + s.charAt(j);
            for (j = i + k;j < Math.min(i + 2 * k, l);j++) ans = ans + s.charAt(j);
        }
        return ans;
    }
}