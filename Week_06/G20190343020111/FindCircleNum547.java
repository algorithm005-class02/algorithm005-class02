package com.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*547. 朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 */
public class FindCircleNum547 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindCircleNum547 fcn = new FindCircleNum547();
		// int[][] M= {{1,1,0},{1,1,0},{0,0,1}};
		int[][] M = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		// int[][] M = { { 1, 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 0
		// }, { 0, 0, 1, 1, 0, 0 },
		// { 0, 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1 } };
		System.out.println(fcn.findCircleNum2(M));

	}

	public void dfs(int[][] M, int[] visited, int i) {
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				dfs(M, visited, j);
			}
		}
	}

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

	public int findCircleNum1(int[][] M) {
		int[] visited = new int[M.length];
		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < M.length; i++) {
			if (visited[i] == 0) {
				queue.add(i);
				while (!queue.isEmpty()) {
					int s = queue.remove();
					visited[s] = 1;
					for (int j = 0; j < M.length; j++) {
						if (M[s][j] == 1 && visited[j] == 0)
							queue.add(j);
					}
				}
				count++;
			}
		}
		return count;
	}

//------实现方式二-----------
	int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	void union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		if (xset != yset)
			parent[xset] = yset;
	}

	public int findCircleNum2(int[][] M) {
		int[] parent = new int[M.length];
		Arrays.fill(parent, -1);
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				if (M[i][j] == 1 && i != j) {
					union(parent, i, j);
				}
			}
		}
		int count = 0;
		for (int i = 0; i < parent.length; i++) {
			if (parent[i] == -1)
				count++;
		}
		return count;
	}

}
