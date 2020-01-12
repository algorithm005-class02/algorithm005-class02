class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = (hi - lo)/2 + lo;
            // if(nums[mid] == target)
            //     return mid;
            //区间在左边的情况，看下左边好不好写
            //1.左边单调递增，且targe取值范围落在左边区间。
            //2.右边单调递增，target小于右边区间最小且大于右边区间最大
            //有序,target在有序数组间
            if(nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])){
                lo = mid + 1;
            }else if(target < nums[0] && target > nums[mid]){//非递增，但不符合左边条件
                lo = mid + 1;
            }else{//左边区间
                hi = mid;
            }
        }
        return lo==hi && nums[lo] == target ? lo : -1; 
    }
}