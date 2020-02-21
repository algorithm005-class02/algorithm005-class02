/**
 * @method "排序法"
 * @explain 对两个字符串进行排序,如果是异位词将产生两个相同的字符，如果字符串长度不一致则不可能相同。
 * @complexity 时间复杂度：O(nlogn),空间复杂度：O(1)
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    // 1.先判断特殊情况：字数不一致直接返回false
    if (s.length != t.length) return false;
    // 2.将字符串转化为数组并排序
    let sArr = s.split('').sort();
    let tArr = t.split('').sort();
    // 3.把排序好的数组合拼回字符串并看看是否一样
    return sArr.join('') == tArr.join('')
    
};
