/**
 * @method "计数法"
 * @explain 利用字母计数表来记录下每个字符串的字符出现次数，然后把字母计数表做成Key,通过就把值映射到对应的key里,最后用扩展运算符把哈希表的数组们重新合成一个数组。
 * @complexity 时间复杂度：O(NK),空间复杂度：O(n)
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
    // 1.做准备工作，创建一个哈希表
    let hash = new Map()
    for (let i = 0; i < strs.length; i++) {
        // 2.把字符串提出
        let str = strs[i]
        // 3.创建一个数组为26（对应26个字母）的数组（字母计数表），都填入0
        let arr = Array(26).fill(0)
        for (let j = 0; j < str.length; j++) {
            // 4.遍历字符串的每一个字符，作用是把每个字符的出现次数记录到字母计数表
            arr[str.charCodeAt(j) - 97]++
        }
        // 5.把字母计数表变成一个用做哈希键值的字符串
        let hashKey = arr.join();
        if (hash.has(hashKey)) {
            // 6.当哈希表中有这个键时，把当前的字符串插入到哈希表内对应的数组中
            let temp = hash.get(hashKey)
            temp.push(str)
            hash.set(hashKey, temp)
        } else {
            // 7.如果没有这个键则创建第一个
            hash.set(hashKey, [str])
        }
    }
    // 8.利用扩展运算符把哈希内的数组放到新数组里返回
    return [...hash.values()]
};
