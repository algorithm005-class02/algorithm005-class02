import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (null == g || null == s || g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int fix = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                fix ++;
                j ++;
                i ++;
            } else {
                j ++;
            }
        }
        return fix;
    }
}