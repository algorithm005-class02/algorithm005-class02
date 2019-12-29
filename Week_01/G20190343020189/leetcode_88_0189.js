// 88. Merge Sorted Array
var merge = function(nums1, m, nums2, n) {
  let [p1, p2] = [m - 1, n - 1];
  for (let i = m + n - 1; i >= 0; i--) {
    if (p2 < 0 || nums1[p1] > nums2[p2]) nums1[i] = nums1[p1--];
    else nums1[i] = nums2[p2--];
  }
};
