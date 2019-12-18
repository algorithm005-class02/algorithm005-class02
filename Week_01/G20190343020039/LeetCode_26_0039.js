/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  let lastUniqIndex = 0;
  for (let i = 1; i < nums.length; i += 1) {
    if (nums[i] === nums[lastUniqIndex]) {
      continue;
    }
    lastUniqIndex += 1;
    nums[lastUniqIndex] = nums[i];
  }
  return lastUniqIndex + 1;
};
