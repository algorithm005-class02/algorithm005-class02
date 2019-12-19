/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  k = k % nums.length;
  reverse(nums, 0, nums.length - k - 1);
  reverse(nums, nums.length - k, nums.length - 1);
  reverse(nums, 0, nums.length - 1);
};

function reverse(nums, start, end) {
  while (start < end) {
    [nums[start], nums[end]] = [nums[end], nums[start]];
    start += 1;
    end -= 1;
  }
}
