/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
  let result = [];
  recursion(nums, 0, [], result);
  return result;
};

function recursion(nums, first, cur, result) {
  result.push(cur);
  for (let i = first; i < nums.length; i += 1) {
    recursion(nums, i + 1, cur.concat([nums[i]]), result);
  }
}
