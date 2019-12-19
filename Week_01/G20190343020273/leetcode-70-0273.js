/**
 * @param {number} n
 * @return {number}
 */
// 数组
// var climbStairs = function (n) {
//     var dp=[]
//     dp[1] = 1
//     dp[2] = 2
//     for (var i = 3; i <= n; i++) {
//         dp[i] = dp[i - 1] + dp[i - 2]
//     }
//     return dp[n]
// };

//暴力法
var climbStairs = function (n) {
    if (n === 1) return 1
    if (n === 2) return 2
    return climbStairs(n - 1) + climbStairs(n - 2)

};

console.log(climbStairs(4))