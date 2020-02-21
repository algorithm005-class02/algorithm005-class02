import java.util.Arrays;

/**
 * 分发饼干
 * https://leetcode.com/problems/assign-cookies/
 */
public class Leetcode_455_assignCookies {

    /**
     * 贪心法
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length;) {
            if (g[i] <= s[j]) {
                i++;
                res++;
            }
            j++;
        }

        return res;
    }

    /**
     * 贪心法，更加简洁的版本
     */
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }



}
