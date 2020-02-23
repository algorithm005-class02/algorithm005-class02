/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
  let l = 0, r = str.length - 1;
  while (l <= r && str[l] == " ") l++;
  while (r >= l && str[r] == " ") r--;
  if (r < l) return 0;
  let MAX_VALUE = Math.pow(2, 31) - 1;
  let MIN_VALUE = -Math.pow(2, 31);
  let sign = 1;
  if (str[l] === "-") {
      sign = -1;
      l++;
  } else if (str[l] === "+") {
      l++;
  }
  let total = 0;
  while (l <= r) {
      let n = str.charCodeAt(l) - "0".charCodeAt();
      if (n > 9 || n < 0) break;
      total = total * 10 + n;
      if (sign == 1 && total > MAX_VALUE) return MAX_VALUE;
      if (sign == -1 && total > MAX_VALUE) return MIN_VALUE;
      l++;
  }
  if (sign == 1) return total;
  return -total;
};