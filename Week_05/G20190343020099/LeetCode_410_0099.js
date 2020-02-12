/**
 * @param {number[]} nums
 * @param {number} m
 * @return {number}
 */
var splitArray = function(nums, m) {
  function countGroup (mid) {
      let count = 1;
      let temp = 0;
      for (let num of nums) {
          temp += num;
          if (temp > mid) {
              // console.log(temp, mid, num)
              temp = num;
              count++;
          }
      }
      return count;
  }
  let l = Math.max(...nums);
  let r = nums.reduce((pre, curr) => pre += curr, 0);
  while (l < r) {
      let mid = Math.trunc((l + r) / 2);
      let count = countGroup(mid);
      if (count > m) {
          l = mid + 1;
      } else {
          r = mid;
      }
  }
  return l;
};

