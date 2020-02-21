/**
 * 解法一
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
  let res = [];
  for (let i = 0; i <= num; i++) {
      let temp = i;
      let count = 0;
      while(temp != 0) {
          temp &= (temp - 1)
          count++;
      }
      res.push(count)
  }
  return res;
};

/**
 * 解法二
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
  let ans = [0];
  for (let i = 1; i <= num; i++) {
      ans[i] = ans[i >> 1] + (i & 1)
  }
  return ans;
};

/**
 * 解法三：
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
  let ans = [0];
  for (let i = 1; i <= num; i++) {
      ans[i] = ans[i & (i - 1)] + 1
  }
  return ans;
};