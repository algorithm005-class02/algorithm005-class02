class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int low = 0;
        int hi = nums.length-1;
        if(nums[low] < nums[hi])
            return nums[low];
        while(low <= hi){
            int mid = (hi-low)/2 + low;
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            if(nums[mid] < nums[mid-1])
                return nums[mid];
             if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}