class Solution {
    public int majorityElement(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }
    
    private int process(int[] nums, int start, int tail) {
        if (start == tail) {
            return nums[start];
        }
        
        int mid = (start + tail) / 2;
        int left = process(nums, start, mid);
        int right = process(nums, mid + 1, tail);
        
        if (left == right) {
            return left;
        }
        
        int leftNum = countMax(nums, start, mid, left);
        int rightNum = countMax(nums, mid + 1, tail, right);
        
        return leftNum > rightNum ? left : right;
    }
    
    private int countMax(int[] nums, int start, int tail, int num) {
        int count = 0;
        for (int i = start; i <= tail; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}