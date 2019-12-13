/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    var s = 0;
    var t = 0;
    for (var i=0; i<nums.length; i++) {
        if(nums[i] == 0){
            t++;
        }
        //指针
        s = s>i?s:i;
        s = s>nums.length-1?nums.length-1:s;
        for(var j = s; j<nums.length;j++){
            if(nums[j] != 0){
                s=j;
                break;
            }
        }
        console.log(i+','+s);
        nums[i] = nums[s++];
    }
    for(var k = 0;k<t;k++){
        nums[nums.length-k-1] = 0;
    }
    return nums
};

export default moveZeroes;