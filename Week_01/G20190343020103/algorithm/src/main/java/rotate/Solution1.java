package rotate;

/**
 * @author scott 2019/12/15
 */
public class Solution1 {
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 1 || nums.length == 0) {
            return;
        }
        //要移动的位置为 k%nums.length  结束条件为：所有位置都挪动了一次位置
        int startNum = 0;
        int count = 0;
        move(nums, nums[startNum], (startNum + k) % nums.length, startNum, k, count);
    }

    public void move(int[] nums, int moveValue, int targetIndex, int startNum, int step, int count) {
        int tmp = nums[targetIndex];
        nums[targetIndex] = moveValue;
        count++;
        if (count != nums.length) {
        int offset = (targetIndex + step) % nums.length;
            if (startNum != offset) {
                move(nums, tmp, offset, startNum, step, count);
            } else { //TODO   递归结束条件不正确
                nums[offset] = tmp;
            }
        }

    }

}
