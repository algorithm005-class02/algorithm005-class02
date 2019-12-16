class Solution {
    public int trap(int[] height) {
        int sum = 0;
        
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0, maxRight = 0, min;
            
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            
            min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }
}