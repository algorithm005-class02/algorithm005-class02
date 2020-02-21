package org.crayzer.leetcode.editor.en.disjoin_set;

public class LeetCode_547_FriendCircles {

    class Solution1 {
        public int findCircleNum(int[][] M) {
            int[] visited = new int[M.length];
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                if (visited[i] == 0) {
                    dfs(M, visited, i);
                    count++;
                }
            }
            return count;
        }

        private void dfs(int[][] M, int[] visited, int i) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && visited[j] == 0) {
                    visited[i] = 1;
                    dfs(M, visited, j);
                }
            }
        }

    }

    class Solution {
        public int findCircleNum(int[][] M) {
            int n = M.length;
            DisjoinSet ds = new DisjoinSet(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (M[i][j] == 1) ds.union(i, j);
                }
            }
            return ds.count();
        }
    }

    class DisjoinSet {
        private int count = 0;
        private int[] parent;

        public DisjoinSet(int n) {
            count = n;
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int q, int p) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        public int count() {
            return count;
        }
    }
}
