import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {

    public int findCircleNum(int[][] M) {

        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) union(parent, i, j);
            }
        }

        int cnt = 0;    
        for (int i = 0; i < M.length; i++) {
            if (parent[i] == -1) cnt++;
        }
        return cnt;
    }

    private void union(int[] parent, int i, int j) {
        int parentI = find(parent, i);   
        int parentJ = find(parent, j);
        if (parentI != parentJ) parent[parentJ] = parentI; 
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) return i;
        return find(parent, parent[i]);
    }
    
}
// @lc code=end

