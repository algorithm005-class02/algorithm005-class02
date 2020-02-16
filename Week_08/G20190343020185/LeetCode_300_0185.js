/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    if(nums.length === 0) return 0;
    var dp = [];
    dp[0] = 1;
    var res = 1;
    for(var i = 1; i < nums.length; i++){
        var max = 0;
        for(var j = 0; j < i; j++){
            if(nums[i] > nums[j]){
                max = max > dp[j] ? max : dp[j];
            }
        }
        dp[i] = max + 1;
        res = res > dp[i] ? res : dp[i];
    }
    return res;
};
