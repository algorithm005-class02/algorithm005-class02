/* 数组  双指针操作
26. 删除排序数组中的重复项

思路 
整体上，是要把数组的后面往前面移动
细节上，需要把重复的覆盖掉
使用两个指针 
慢指针i代表的是 已经整理好的部分
快指针j遍历
时间复杂度O(n) 空间复杂度O(1)
*/
var removeDuplicates = function(nums) {
    if (nums.length === 0) {
        return 0
    }
    let i = 0
    for (let j = 1; j < nums.length; j++) {
        if (nums[i] != nums[j]) {
            nums[i + 1] = nums[j]
            i++
        }
    }
    return i + 1
};


