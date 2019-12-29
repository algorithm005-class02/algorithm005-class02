class Solution {
    public void rotate(int[] nums, int k) {
        //取余防止超过数组范围
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; start++) {
            int current = i;
            int prev = nums[i];
            do {
                //取余防止超过数组范围
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (i != current);
        }
    }
    
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}