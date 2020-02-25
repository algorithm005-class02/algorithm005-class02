/**
 * 翻转对
 * https://leetcode.com/problems/reverse-pairs/
 */
public class Leetcode_493_reversePairs {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (left + right) >> 1;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        int[] temp = new int[right - left + 1];
        int i = left, s = left, k = 0;
        for (int j = mid + 1; j <= right;) {
            while (i <= mid && nums[i] <= (long)2 * nums[j]) {
                i++;
            }
            count += mid - i + 1;

            while (s <= mid && nums[s] <= nums[j]) {
                temp[k++] = nums[s++];
            }
            temp[k++] = nums[j++];
        }

        while (s <= mid) {
            temp[k++] = nums[s++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);

        return count;
    }

    public static void main(String[] args) {
        Leetcode_493_reversePairs solution = new Leetcode_493_reversePairs();
        int[] nums = {1, 3, 2, 3, 1};
        System.out.println(solution.reversePairs(nums));
    }
}
