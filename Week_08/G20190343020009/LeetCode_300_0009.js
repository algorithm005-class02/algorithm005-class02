var lengthOfLIS = function (nums) {
  const dp = new Array(nums.length).fill(0)
  let len = 0
  for (let i = 0; i < nums.length; i++) {
    let ind = binarySearch(dp, 0, len, nums[i])
    if (ind < 0) ind = -ind
    dp[ind] = nums[i]
    if (ind === len) len++
  }
  return len
};

function binarySearch(arr, from, to, target) {
  if (to === 0) return -0
  if (target < arr[from]) return -from
  if (target > arr[to - 1]) return -to
  let l = from
  let r = to
  while (l < r) {
    const mid = Math.floor((l + r) / 2)
    if (target > arr[mid]) {
      l = mid + 1
    } else if (target < arr[mid]) {
      r = mid
    } else {
      l = mid
      r = mid
    }
  }
  return arr[l] === target ? l : -l
}