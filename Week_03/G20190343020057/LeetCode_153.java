class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(nums[left]<=nums[right]) return nums[0];//加快未旋转情况的操作
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]){//看题解才正确的，最巧妙的地方是和右元素比较，这样即使是正序数组也可以正确求解。
                left = mid+1; 
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}