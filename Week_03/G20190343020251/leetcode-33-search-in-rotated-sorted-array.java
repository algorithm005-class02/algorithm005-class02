class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left=0, right=nums.length-1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        int lt, rt;
        if (target>=nums[0] && target<=nums[left]) {
            lt = 0; rt = left;
        } else {
            lt = left+1; rt=nums.length - 1;
        }

        while (lt<=rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return -1;
    }
}
