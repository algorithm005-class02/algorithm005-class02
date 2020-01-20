/**
 * 解法一：map
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  let map = new Map();
  for (let i = 0; i < nums.length; i++) {
      let count = (map.get(nums[i]) || 0) + 1;
      map.set(nums[i], count)
  }
  for (let [key, value] of map.entries()) {
      if (value > (nums.length / 2)) {
          return key;
      }
  }
  return null;
};


/**
 * 解法二：
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  nums.sort((a, b) => a - b);
  return nums[Math.floor(nums.length / 2)];
};

/**
 * 解法三
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  let major = nums[0];
  let count = 1;
  for (let i = 1; i < nums.length; i++) {
      if (major === nums[i]) {
          count++;
      }else if (count === 0) {
          major = nums[i];
          count = 1;
      }else {
          count--;
      }
  }
  return major;
};