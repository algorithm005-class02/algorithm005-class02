/**
 * 解法一：暴力破解
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  let ans = [];
  let i = 0, j = 0;
  for (; i < m && j < n;) {
      if (nums1[i] < nums2[j]) {
          ans.push(nums1[i++]);
      }else {
          ans.push(nums2[j++]);
      }
  }
  while (i < m) {
      ans.push(nums1[i++])
  }
  while (j < n) {
      ans.push(nums2[j++])
  }
  i = 0;
  while (i < ans.length) {
      nums1[i] = ans[i++];
  }
};


/**
 * 解法二
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  let i = m - 1;
  let j = n - 1;
  let r = m + n - 1;
  while (i > -1 && j > -1) {
      if(nums1[i] > nums2[j]) {
          nums1[r--] = nums1[i--];
      }else {
          nums1[r--] = nums2[j--];
      }
  }
  while (j > -1) {
      nums1[j] = nums2[j--];
  }
};