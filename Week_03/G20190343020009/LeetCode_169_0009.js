/*暴力法 根据目标 最直接的方法
找到最多的 遍历 用字典统计 次数 再遍历字典拿到最多的那个
tc:n
sc:n
  */
var majorityElement = function (nums) {
  let countedNums = new Map()
  for (let i = 0; i < nums.length; i++) {
    let v = nums[i]
    if (countedNums.has(v)) {
      countedNums.set(v, countedNums.get(v) + 1)
    } else {
      countedNums.set(v, 1)
    }
  }
  // 统计出来了 找到最大的
  // 找map里值最大的键
  let times = 0
  let num = 0

  function getMax(value, key) {
    if (value > times) {
      num = key
      times = value
    }
  }
  countedNums.forEach(getMax)
  return num
} 

/* 分治算法 利用计算机的正确方式 设计一个命令 让计算机去重复执行 先剥离
先剥离到底层 剩下的肯定会有一个或者两个最多的数字
tc:nlogn
sc:logn
*/
var majorityElement = function (nums) {
  function countInRange(nums, num, lo, hi) {
    count = 0;
    for (i = lo; i <= hi; i++) {
      if (nums[i] == num) {
        count++;
      }
    }
    return count
  }

  function majorityEleme(nums, lo, hi) {
    // base case; the only element in an array of size 1 is the majority element.
    if (lo == hi) {
      return nums[lo];
    }

    // recurse on left and right halves of this slice.
    mid = ((hi - lo) >> 1) + lo;
    left = majorityEleme(nums, lo, mid);
    right = majorityEleme(nums, mid + 1, hi);

    // if the two halves agree on the majority element, return it.
    if (left == right) {
      return left;
    }
    // otherwise, count each element and return the "winner".
    leftCount = countInRange(nums, left, lo, hi);
    rightCount = countInRange(nums, right, lo, hi);

    return leftCount > rightCount ? left : right;
  }
  return majorityEleme(nums, 0, nums.length - 1);
}

/* 天解 充分利用题目条件 一题一解 可能没有
投票算法
 */

/* 排序 
既然是数字 那么还能排序
复杂度是排序的复杂度 nlogn 
排序没必要
 */