/**
 *
 *删除数组重复元素：双指针算法，时间复杂度为O(n),空间复杂度为O(1)
 **/
class Solution{
    public int removeDuplicates (int nums[]) {
        if (null == nums || nums.length == 0 ) {
            return 0 ;
        }
        int i = 0 ;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i] ) {
                i++;
                nums[i] = nums[j] ;
            }
        }
        return i + 1;
    }
}