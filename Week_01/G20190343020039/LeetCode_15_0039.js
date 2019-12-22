/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
  let result = [];
  nums.sort((a, b) => a - b);
  for (let i = 0; i < nums.length; i += 1) {
    if (i > 0 && nums[i] === nums[i - 1]) {
      continue;
    }
    const target = -nums[i];
    let [left, right] = [i + 1, nums.length - 1];
    while (left < right) {
      const sum = nums[left] + nums[right];
      if (sum < target) {
        left += 1;
      } else if (sum > target) {
        right -= 1;
      } else {
        result.push([nums[i], nums[left], nums[right]]);

        while (nums[left] === nums[left + 1]) {
          left += 1;
        }
        left += 1;

        while (nums[right] === nums[right - 1]) {
          right -= 1;
        }
        right -= 1;
      }
    }
  }
  return result;
};

