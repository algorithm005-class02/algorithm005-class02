/**
 * @方法：“快慢双指针”  时间复杂度：O(n)
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    //判断数组是否空
    if (nums.length == 0 || nums == null) return 0
    //慢指针的下标（记录最后一个不重复的数字位置）
    let unique = 0
    for (let i = 0; i <  nums.length; i++) {
        //当遇到不重复的数字时
        if (nums[unique] != nums[i]) {
            //把当前不重复的数字覆盖到“新数组”后面(取原数组的前‘unique + 1’个数字组成概念上的新数组)，在赋值到新位置的同时unique自增指向新的最后一个不重复数字的位置。
            nums[++unique] = nums[i]
        }
    }
    //返回新数组长度
    return unique + 1
};