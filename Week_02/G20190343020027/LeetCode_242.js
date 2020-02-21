/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    let result = true;
    if (s.length !== t.length) {
        return false;
    }
    let sArr = s.split('').sort();
    let tArr = t.split('').sort();

    sArr.forEach((value, index) => {
        console.log(value);
        console.log(tArr[index]);
        if (value !== tArr[index]) {
            result =  false;
        }
    });
    return result;
};