/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */

var combine = function(n, k) {
    if (n < k || n < 1 || k < 1) return [];
    let ans = [];
    function helper (n, k, first, nums) {
        if (nums.length == k) {
            return ans.push(nums.slice());
        }
        for (let i = first; i < n + 1; i++) {
            nums.push(i)
            helper(n, k, i + 1, nums);
            nums.pop();
        }
    }
    helper(n, k, 1, []);
    return ans;
};



/**
 * 优化版(剪枝)
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */

var combine = function(n, k) {
    if (n < k || n < 1 || k < 1) return [];
    let ans = [];
    function helper (n, k, first, nums) {
        if (nums.length == k) {
            return ans.push(nums.slice());
        }
        for (let i = first; i <= n - (k - nums.length) + 1; i++) {
            nums.push(i)
            helper(n, k, i + 1, nums);
            nums.pop();
        }
    }
    helper(n, k, 1, []);
    return ans;
};

