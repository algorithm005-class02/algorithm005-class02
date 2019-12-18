/**
 * leetcode 26 removeDuplicates
 * 题意：
 * 01、给定排序数组
 * 02、原地删除重复出现的数组，每个元素只出现一次
 * 03、返回新数组的长度
 * 04、必须为O(1)的空间复杂度
 * 
 */
class Solution26 {

    public int removeDuplicates (int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length ; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

class Main26 {

    public static void main (String args[]) {
        Solution26 solution = new Solution26();
        //Test case
        int nums [] = {1,1,2};
        // int nums [] = {0,0,1,1,1,2,2,3,3,4};
        int res = solution.removeDuplicates(nums);
        System.out.print(integerArrayToString(nums,res));
    }

    /**
     * 处理最终结果数组
     * @param nums
     * @param res
     * @return
     */
    private static String integerArrayToString (int[] nums,int res) {
        if (res == 0) {
            return "[]";
        }
        String result = "";
        for (int index = 0; index < res; index ++) {
            int number = nums[index];
            result += Integer.toString(number) + ",";
        }
        return "["+result.substring(0,result.length() - 1)+"]";

    }
}