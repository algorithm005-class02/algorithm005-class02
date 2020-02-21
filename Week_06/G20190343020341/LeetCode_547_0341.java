import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

public class LeetCode_547_0341 {
}

class Solution547_1 {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
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

class Solution547_2 {
    int find(int parent[], int i) {
        if(parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if(xset != yset) {
            parent[xset] = yset;
        }
    }
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M.length; j++) {
                if(M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < parent.length; i++) {
            if(parent[i] == -1) {
                count++;
            }
        }
        return count;
    }
}