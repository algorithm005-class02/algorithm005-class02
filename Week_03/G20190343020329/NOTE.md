学习笔记

二分查找：
class Solution {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end -start)/2;
            if (nums[mid] == target){
                return mid;
            }
            //后半部分有序
            if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(nums[mid] > target && target >= nums[start]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
总结：
二分查找关键点：
1数据具有单调性
2.具有上下边界
3.可通过index访问数据

贪心算法：
1存在局部最优
2每一步都可以用最优的解
3贪心算法具有局限性，只有少数场景采用贪心算法是最高效的

深度优先：
1一层一层进入到最底层，获取其中一个解。
广度优先：
1适合最短类型问题

分支，回溯：
1最终问题的解由其子问题的解组成