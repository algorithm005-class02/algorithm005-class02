/**
 * 解法一
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  for (let i = 0; i < k; i++) {
      nums.unshift(nums.pop())
  }
};



/**
 * 解法二
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  if (!nums || nums.length == 0) return;
  k = k % nums.length;
  function reverse(n, l, r) {
      while(l < r) {
          [n[l], n[r]] = [n[r], n[l]];
          l++;
          r--;
      }
  }
  reverse(nums, 0, nums.length - 1);
  reverse(nums, 0, k - 1);
  reverse(nums, k, nums.length -1);
};