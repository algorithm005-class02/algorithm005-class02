/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  if (!nums) return 0;
  let j = 0;
  for (let i = 1; i < nums.length; i++) {
      if (nums[i] != nums[j] ) {
          nums[++j] = nums[i];
      }
  }
  return nums.length = j + 1;
};