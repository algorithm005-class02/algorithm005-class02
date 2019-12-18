/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
    var i = 0;
    for (var j = 0; j < nums.length; j++) {
        if (nums[j] !== 0) {
            nums[i++] = nums[j]
        }
    }
    for (var p = i; p < nums.length; p++) {
        nums[p] = 0
    }

};

var nums = [0,1,0,3,12] 
moveZeroes(nums)
console.log("nums",nums)