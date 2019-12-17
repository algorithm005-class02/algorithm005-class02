/**
 * 解法一：暴力求解 时间复杂度 O(n2) 空间复杂度 O(1)
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  let ans = 0;
  for (let i = 1; i < height.length - 1; i++) {
      let max_left = 0;
      for (let l = i - 1; l >= 0; l--) {
          max_left = Math.max(max_left, height[l])
      }
      let max_right = 0;
      for (let r = i + 1; r < height.length; r++) {
          max_right = Math.max(max_right, height[r]);
      }
      let min = Math.min(max_left, max_right);
      if (min > height[i]) {
          ans = ans + (min - height[i]);
      }
  }
  return ans;
};



/**
 * 解法二：动态编程， 时间复杂度 O(n) 空间复杂度 O(n)
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  if (!height || height.length < 3) return 0;
  let ans = 0;
  let max_left = [height[0]];
  for (let l = 1; l < height.length; l++) {
      max_left[l] = Math.max(max_left[l - 1], height[l]);
  }
  let max_right = [];
  max_right[height.length - 1] = height[height.length - 1];
  for (let r = height.length - 2; r >= 0; r--) {
      max_right[r] = Math.max(height[r], max_right[r + 1]);
  }
  for (let i = 1; i < height.length - 1; i++) {
      let min = Math.min(max_left[i], max_right[i]);
      if (min > height[i]) {
          ans = ans + (min - height[i]);
      }
  }
  return ans;
};


/**
 * 解法三：双指针法 时间复杂度 O(n) 空间复杂度 O(1)
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  let left = 0;
  let right = height.length - 1;
  let left_max = 0;
  let right_max = 0;
  let ans = 0;
  while (left < right) {
      left_max = Math.max(left_max, height[left]);
      right_max = Math.max(right_max, height[right])
      let min = Math.min(left_max, right_max);
      if (height[left] < height[right]) {
          if (min > height[left]) {
              ans = ans + (min - height[left])
          }
          left++;
      }else {
          if (min > height[right]) {
              ans = ans + (min - height[right])
          }
          right--;
      }
  }
  return ans;
};