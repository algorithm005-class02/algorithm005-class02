/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
var reverseString = function(s) {
    var tmp = '';
    for(var i = 0; i <= ((s.length - 1) >> 1); i++){
        tmp = s[i];
        s[i] = s[s.length - 1 - i];
        s[s.length - 1 - i] = tmp;
    }
    return s;
};
