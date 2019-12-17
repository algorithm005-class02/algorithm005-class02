import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap map = new HashMap();
        int iindex = 0;
        int jindex = 0;
        int iindexnew = 0;
        for (int i = 0; i < nums.length; i++) {
            //解决重复元素值下标问题
            if(map.containsKey(nums[i])){
                iindexnew = (int)map.get(nums[i]);
            }
            // 将值和下标存入Map
            map.put(nums[i], i);
        }
        Arrays.sort(nums); // 升序排列
        int twonums[] = new int[2]; 
        for(int i = 0,j = nums.length - 1;i<j;){
            int sum = nums[i] + nums[j];
            if(sum < target){
                while(i < j && nums[i] == nums[++i]);
            }
            else if(sum > target){
                while(i < j && nums[j] == nums[--j]);
            }
            else if(sum == target){
                iindex = (int) map.get(nums[i]);
                jindex = (int) map.get(nums[j]);
                if(iindex == jindex){
                    iindex = iindexnew;
                }
                twonums[0] = iindex;
                twonums[1] = jindex;
                while(i < j && nums[i] == nums[++i]);
                while(i < j && nums[j] == nums[--j]);
            }
        }

        return twonums;
    }
}
// @lc code=end

