package G20190343020097;

/**
 *  * @author jiangli
 *  * @date 2019/12/29 22:53
 *  * @description
 *  
 */
public class LeetCode_33_0097 {

    public static void main(String[] args) {
        LeetCode_33_0097 l = new LeetCode_33_0097();
        int search = l.search(new int[]{3,1}, 3);
        System.out.println(search);
    }

    /**
     * 先找旋转点
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int min_index = this.findMinIndex(nums);
        return search(nums, target, min_index);
    }

    /**
     * @param nums
     * @return
     */
    public int findMinIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        if (nums[0] < nums[nums.length - 1]) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) return mid + 1;
            if (nums[mid - 1] > nums[mid]) return mid;
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target, int min_index) {
        if (nums[min_index] == target) return min_index;
        if (min_index == 0) {
            return halfSearch(nums, target, 0, nums.length - 1);
        }
        if (target >= nums[0]) {
            return halfSearch(nums, target, 0, min_index - 1);
        } else {
            return halfSearch(nums, target, min_index + 1, nums.length - 1);
        }
    }

    public int halfSearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
