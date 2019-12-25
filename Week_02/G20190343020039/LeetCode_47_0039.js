/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  let result = [];
  let m = counter(nums);
  recursion(nums, m, [], result);
  return result;
};

function recursion(nums, m, cur, result) {
  if (cur.length === nums.length) {
    result.push(cur.map(e => +e));
    return;
  }

  for (let num in m) {
    if (m[num] > 0) {
      cur.push(num);
      m[num] -= 1;

      recursion(nums, m, cur, result);

      cur.pop();
      m[num] += 1;
    }
  }
}

function counter(nums) {
  const m = {};
  for (let i = 0; i < nums.length; i += 1) {
    const num = nums[i];
    if (num in m) {
      m[num] += 1;
    } else {
      m[num] = 1;
    }
  }
  return m;
}
