// 45. Jump Game II

var jump = function(nums) {
  let start = 0,
    maxReach = 0,
    jump = 0;

  while (maxReach < nums.length - 1) {
    jump++;

    let nextMaxReach = maxReach;
    for (let i = start; i <= maxReach; i++) {
      nextMaxReach = Math.max(nextMaxReach, nums[i] + i);
    }

    start = maxReach + 1;
    maxReach = nextMaxReach;
  }

  return jump;
};
