class Solution {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end -start)/2;
            if (nums[mid] == target){
                return mid;
            }
            //后半部分有序
            if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(nums[mid] > target && target >= nums[start]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}