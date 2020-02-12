
/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */


// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    private int merge(int[] nums, int s, int e) {
        if (s >= e) return 0;
        int[] cache = new int[e - s + 1];
        int mid = (e + s) >> 1; // 左中位数
        int cnt = merge(nums, s, mid) + merge(nums, mid + 1, e);
        int l = s, r = mid + 1, c = 0;
        //统计逆序对
        for (int i = s, j = mid + 1; i <= mid; i++) { 
           while (j <= e && nums[i] / 2.0 > nums[j]) j++;
           cnt += j - (mid + 1);
        }
        //合并两个数组
        while(l <= mid && r <= e) {
            cache[c++] = nums[l] > nums[r] ? nums[r++] : nums[l++]; 
        }
        while (r <= e) cache[c++] = nums[r++];
        while (l <= mid) cache[c++] = nums[l++];
        System.arraycopy(cache, 0, nums, s, e - s + 1);
        return cnt;
    }
}
// @lc code=end

