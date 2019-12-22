/**
 解题思路：
 1.loop count zeros
 2.一维数组的坐标变换 i,j
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution283 {

    //新增插入偏移量0,把所有非0的数字从偏移量开始位移，插入偏移量原数组长度，剩余用0补齐
    //时间复杂度：O(n)
    public void moveZeroes(int[] nums) {
        //判断空数组
        if (nums == null || nums.length == 0) {
            return;
        }
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    //一维数组的坐标变换,新增插入偏移量0,不为0的时且偏移量不等于索引，将当前索引数组和偏移量数组进行位置互换
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    //统计0的个数，当前索引减去0的统计的偏移量
    public void moveZeroes1(int[] nums) {
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                insertPos++;
            } else if (insertPos > 0) {
                nums[i - insertPos] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
