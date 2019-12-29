//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法
public class LeetCode_169_众数_0011 {

    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        //terminator
        if (left == right) return nums[left];

        //prepare
        int mid = (left + right) / 2;

        //drill down
        int leftNum = helper(nums, left, mid);
        int rightNum = helper(nums, mid + 1, right);

        //process
        if (leftNum == rightNum) return leftNum;
        int leftCount = getCount(nums, leftNum, left, mid);
        int rightCount = getCount(nums, rightNum, mid + 1, right);
        return leftCount > rightCount ? leftNum : rightNum;
    }

    private int getCount(int[] nums, int num, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }

}
