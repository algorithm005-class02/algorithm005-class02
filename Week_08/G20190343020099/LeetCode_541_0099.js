/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function(s, k) {
  let arr = s.split("");
  let l = 0, r = arr.length - 1;
  while (l <= r) {
      reverse(arr, l, l + k - 1);
      l += 2 * k;
  }
  return arr.join("");
};

function reverse (arr, l, r) {
  while (l < r) {
      [arr[l], arr[r]] = [arr[r], arr[l]];
      r--;
      l++;
  }
}