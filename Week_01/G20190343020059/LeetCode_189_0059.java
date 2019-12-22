/**
 *旋转数组
 *
 */
class Solution {

    /**
    *暴力拆除：旋转K次，每次旋转一个元素
    */
    public void rotatedArray (int[] nums, int k) {
        int temp,previous;
        int length = (null == nums || nums.length == 0) : 0 ?nums.length;
        for (int i = 0; i < k; i++) {
           //最后一个元素
            previous = nums[length -1];
            for (int j = 0; j < length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }

    }

    /**
    *环状替换
    */
    public void rotate(int[] nums, int k) {
             //数组长度
             int length = (null == nums || nums.length ==0) ? 0 : nums.length;
             if (length == 0) {
                return ;
             }
             k = k % length;
            int count = 0;
            for (int start = 0; count < length; start++) {
                int current = start;
                int prev = nums[start];
                do {
                    int next = (current + k) % length ;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                    count++;
                } while (start != current);
            }
        }
}