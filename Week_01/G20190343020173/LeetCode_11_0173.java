package org.crayzer.leetcode.editor.en.array;

public class LeetCode_11_ContainerWithMostWater {

    class Solution2 {
        public int maxArea(int[] height) {
            int max = 0;
            for (int i = 0, j = height.length - 1; i < j; ) {
                int minHeight = height[i] < height[j] ? height[i++] : height[j--];
                int area = (j - i + 1) * minHeight;
                max = Math.max(max, area);
            }
            return max;
        }
    }

    class Solution1 {
        public int maxArea(int[] height) {
            int max = 0;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int area = (j - i) * Math.min(height[i], height[j]);
                    max = Math.max(max, area);
                }
            }

            return max;
        }

    }
}
