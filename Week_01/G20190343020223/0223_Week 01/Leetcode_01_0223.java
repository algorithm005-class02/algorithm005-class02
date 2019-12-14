import java.util.Arrays;
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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {//验证是否存在这一key
                return new int[] { map.get(target - nums[i]), i };//返回key的下标值和
            } else {
                map.put(nums[i], i);
            }
        }
        return  nums;//只是为了确保函数有一个数组的返回值，但实际上真正的结果并不会从这里返回的
        //早在for循环里面就有返回值了；因为题目中说了必有答案存在，因而不会走到末尾的return这一步。

    }
}
// @lc code=end
/* 
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;//暴力解法也是可以的；
*/
