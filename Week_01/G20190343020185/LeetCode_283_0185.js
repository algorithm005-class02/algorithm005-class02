/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
	//指针
    var s = 0;
	//交换
	var tmp = 0;
	//处理
    for (var i=0; i<nums.length; i++) {
        if(nums[i] != 0){
			tmp = nums[s];
			nums[s++] = nums[i];
			nums[i] = tmp;
        }
    }
    return nums;
};

export default moveZeroes;