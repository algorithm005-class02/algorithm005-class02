package week01.work;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 */
public class LeeCode189_Rotate {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;

        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % nums.length;

                int temp = nums[next];
                nums[next] = prev;
                prev = temp;

                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        LeeCode189_Rotate lc = new LeeCode189_Rotate();

        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        lc.rotate(nums,18);

        for(int n:nums){
            System.out.print(n+",");
        }
    }
}
