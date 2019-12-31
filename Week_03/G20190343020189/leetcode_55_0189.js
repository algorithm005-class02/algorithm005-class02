// 55. Jump Game
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    if (!nums || !nums.length) return true;
    
    let maxReach = 0;
    for (let i = 0; i <= maxReach; i++) {
        maxReach = Math.max(maxReach, i + nums[i]);
        if (maxReach >= nums.length - 1) return true;
    }
    
    return false;
};

// compare with previous attempt
var canJump = function(nums) {
    // 最远可以够到哪里
    let maxReach = 0;
    
    for (let i = 0; i < nums.length; i++) {
        // 达不到当前位置
        if (maxReach < i) return false;
        // 擂台更新maxReach
        maxReach = Math.max(maxReach, i + nums[i]);
        // 检验是否已经可以达到最后一位了
        if (maxReach >= nums.length - 1) return true;
    }
};