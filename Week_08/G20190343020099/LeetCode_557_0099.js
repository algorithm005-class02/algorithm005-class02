/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let arr = s.split('');
    let reg = /[^\s]+/g;
    let start = 0, end = 0;
    while (reg.exec(s)) {
        end = reg.lastIndex;
        reverse(arr, start, end - 1);
        start = end + 1;
    }
    return arr.join('');
};

function reverse(arr, l, r) {
    while (l <= r) {
        [arr[l], arr[r]] = [arr[r], arr[l]];
        l++;
        r--;
    }
}