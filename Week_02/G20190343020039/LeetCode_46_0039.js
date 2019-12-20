/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  let result = [];
  recursion(nums, 0, result);
  return result;
};

function recursion(nums, first, result) {
  if (first === nums.length) {
    result.push(nums.slice());
  }

  for (let i = first; i < nums.length; i += 1) {
    [nums[first], nums[i]] = [nums[i], nums[first]];
    recursion(nums, first + 1, result);
    [nums[first], nums[i]] = [nums[i], nums[first]];
  }
}
