/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
public class Solution {
    public int findCircleNum(int[][] M) {
        int count = M.length;
        int[] root = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            root[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    int rooti = findRoot(root, i);
                    int rootj = findRoot(root, j);
                    if (rooti != rootj) {
                        root[rooti] = rootj;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    public int findRoot(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
// @lc code=end
