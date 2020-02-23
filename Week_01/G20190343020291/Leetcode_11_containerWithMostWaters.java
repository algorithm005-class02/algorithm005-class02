/**
 * 盛水最多的容器
 * https://leetcode.com/problems/container-with-most-water/
 */
class Leetcode_11_containerWithMostWaters {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1;  i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max,  (j - i + 1) * minHeight);
        }
        return max;
    }
}