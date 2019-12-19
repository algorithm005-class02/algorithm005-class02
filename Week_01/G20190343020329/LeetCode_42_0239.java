class Solution {
    public int trap(int[] height) {
        int all = 0;
        for (int i = 0; i < height.length; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int left = i - 1; left >= 0; left--) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                }
            }
            for (int right = i + 1; right < height.length; right++) {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                }
            }
            int max = maxLeft >= maxRight ? maxRight : maxLeft;
            if (max > height[i]) {
                all += max - height[i];
            }
        }
        return all;
    }
}