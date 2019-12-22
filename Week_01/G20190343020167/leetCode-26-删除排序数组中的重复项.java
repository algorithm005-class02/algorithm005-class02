class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
      for (int i = 1; i < nums.length; i ++) {
           if (nums[count] == nums[nums.length - 1]) {
              return count + 1;
           }
           while (nums[count] == nums[i]) {
               for (int j = i; j < nums.length - 1; j ++) {
                    nums[j] = nums[j + 1];
              }
            }
           count ++;
        }
        return count + 1;
    }
}