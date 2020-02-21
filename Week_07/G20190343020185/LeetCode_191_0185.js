o/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    var s = 0;
    while(n!==0){
        s++;
        n=n&(n-1);
    }
    return s;
};
