/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n, obj = {}) {
    if (obj[n]) {
        return obj[n];
    }
    if (n === 1) {
        obj[1] = 1;
        return 1;
    }
    if (n === 2) {
        obj[2] = 2;
        return 2;
    }
    if (obj[n - 1] && obj[n - 2]) {
        obj[n] = obj[n - 1] + obj[n - 2];
        return obj[n];
    }
    return climbStairs(n - 1, obj) + climbStairs(n - 2, obj);
};