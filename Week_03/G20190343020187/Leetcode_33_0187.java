package G20190343020187;

public class Leetcode_33_0187 {
    class Solution {
        public int search(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                    lo = mid + 1;
                } else if (target > nums[mid] && target < nums[0]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo == hi && nums[lo] == target ? lo : -1;
        }
    }
}