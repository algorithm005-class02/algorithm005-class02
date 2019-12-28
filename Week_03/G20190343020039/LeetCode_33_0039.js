/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  let left = 0;
  let right = nums.length - 1;
  while (left <= right) {
    let mid = left + Math.floor((right - left) / 2);
    let num = (nums[mid] < nums[0]) === (target < nums[0])
      ? nums[mid]
      : target < nums[0] ? -Number.MAX_VALUE : Number.MAX_VALUE;
    if (num < target) {
      left = mid + 1;
    } else if (num > target) {
      right = mid - 1;
    } else {
      return mid;
    }
  }
  return -1;
};
