class Solution {
    public int majorityElement(int[] nums) {
        //1. 哈希
        // Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // int n = nums.length;
        // for (int i = 0;i<nums.length;++i) {
        //     int compare = map.getOrDefault(nums[i], 0);
        //     if (compare == n / 2) {
        //         return nums[i];
        //     }
        //     map.put(nums[i], compare + 1);
        // }
        // return 0;
        //2.投票 相比哈希少了初始化Map，时间复杂度都是O(n)
        int a = nums[0];
        int count = 1;
        for (int i : nums) {
            if (a == i) {
                count++;
            }else {
                count--;
                if (count == 0) {
                    a = i;
                    count = 1;
                }
            }
        }
        return a;
    }
}