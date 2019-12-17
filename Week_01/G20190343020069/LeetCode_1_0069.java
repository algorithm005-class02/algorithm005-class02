import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //暴力破解法 时间复杂度 O(n^2)
        // for (int i = 0 ; i < nums.length ; i++) {
        //     for (int j = i + 1 ; j < nums.length ; j++) {
        //         if(nums[j] == target - nums[i]){
        //             return new int [] { i, j };
        //         }
        //     }
        // }
        // throw new IllegalArgumentException("No two Sum Solution");

        //使用 hashmap 时间复杂度 O(n)
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int [] { map.get(complement) , i };
            }
            map.put(nums[i] , i);
        }
        throw new IllegalArgumentException("No two Sum Solution");
        
    }
}
// @lc code=end

/**
 * Main
 */
class Main {
    
    public static void main (String args[]) {
        //create instance
        Solution solution = new Solution();
        //Test cases
        int [] nums = { 2 , 3 , 4};
        int target = 6;
        //Launch alg
        int [] res = solution.twoSum(nums, target);
        //print out
        System.out.print(integerArrayToString(res));
    }

    // 类型转换 组装结果
    private static String integerArrayToString (int[] nums) {
        if (nums.length == 0) {
            return "[]";
        }
        String res = "";
        for (int index = 0 ; index < nums.length; index ++) {
            res += Integer.toString(nums[index])+",";
         }
        return "["+res.substring(0,res.length() - 1)+"]";
    }
}