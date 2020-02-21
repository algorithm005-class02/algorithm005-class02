import java.util.*;

/**
 * 朋友圈
 */
class LeeCode_0547_0321 {

    public static void main(String[] args) {
        int[][] m = {{1,1,0},
                     {1,1,0},
                     {0,0,1}};
        int result = new Solution().findCircleNum(m);
        System.out.println(result);
    }

    static class Solution {
        /**
         * findCircleNum
         * 朋友圈
         */
        public int findCircleNum(int[][] M) {
            int[] visited = new int[M.length];
            int count = 0;
            Queue< Integer > queue = new LinkedList < > ();
            for (int i = 0; i < M.length; i++) {
                if (visited[i] == 0) {
                    queue.add(i);
                    while (!queue.isEmpty()) {
                        int s = queue.remove();
                        visited[s] = 1;
                        for (int j = 0; j < M.length; j++) {
                            if (M[s][j] == 1 && visited[j] == 0) {
                                queue.add(j);
                            }
                        }
                    }
                    count++;
                }
            }
            return count;
        }
    }

}


