var removeDuplicates = function(nums) {
    
    for (let i = 0; i < nums.length; i++) {
        if (nums.indexOf(nums[i]) !== i) {
            nums.splice(i,1)
            i--
        }
    }
};