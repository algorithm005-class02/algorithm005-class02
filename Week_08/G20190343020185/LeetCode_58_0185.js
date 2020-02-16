/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    s = s.trim();
    var res = 0;
    for(var i = 0; i < s.length; i++){
        if(s.charAt(i) === ' ') res = 0;
        else res++;
    }
    return res;
};
