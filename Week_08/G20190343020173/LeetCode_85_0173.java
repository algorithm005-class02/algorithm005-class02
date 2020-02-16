package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.Arrays;

public class LeetCode_85_MaximalRectangle {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) return 0;
            int m = matrix.length;
            int n = matrix[0].length;

            int maxArea = 0;
            int[] height = new int[n];
            int[] left = new int[n];
            int[] right = new int[n];

            Arrays.fill(right, n);

            for (int i = 0; i < m; i++) {
                int curLeft = 0, curRight = n;

                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') height[j]++;
                    else height[j] = 0;
                }

                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') left[j] = Math.max(left[j], curLeft);
                    else {
                        left[j] = 0;
                        curLeft = j + 1;
                    }
                }

                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') right[j] = Math.min(right[j], curRight);
                    else {
                        right[j] = n;
                        curRight = j;
                    }
                }

                for (int j = 0; j < n; j++) {
                    maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
                }
            }
            return maxArea;
        }
    }
}
