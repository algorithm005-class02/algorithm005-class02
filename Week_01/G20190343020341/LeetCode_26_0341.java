public class LeetCode_26_0341 {
    //[], [1], [1,1], [0,1], [1,1,2], [1,2,3],[0,0,1,1,1,2,2,3,3,4]
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        //when len >= 2
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i + 1];
                len -= 1;
                if (i + 2 == nums.length) {
                    return len;
                } else {

                    nums[i + 1] = nums[i + 2];
                    for (int j = i + 2; j < nums.length; j++) {
                        if (j + 1 < nums.length) {
                            nums[j] = nums[j + 1];
                        }
                    }
                }
                i--;
            }
        }
        return len;
    }
}