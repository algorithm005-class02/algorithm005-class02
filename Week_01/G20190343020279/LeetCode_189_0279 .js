/**
 * @方法：“暴力枚举”
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    //临时变量（用来交互数字位置），前面的变量
    let temp,previous
    for (let i = 0; i < k; i++) {
        previous = nums[nums.length - 1]
        for (let j = 0; j <nums.length; j++) {
            temp = nums[j]
            nums[j] = previous
            previous = temp
        }
    }
    return nums;
};