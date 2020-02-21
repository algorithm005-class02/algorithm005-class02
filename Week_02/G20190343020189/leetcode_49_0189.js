// 49. Group Anagrams

var groupAnagrams = function(strs) {
    let strToAnagrams = {};
    
    for (const s of strs) {
        const sortedStr = s.split('').sort().join('');
        if (!strToAnagrams[sortedStr]) strToAnagrams[sortedStr] = [s];
        else strToAnagrams[sortedStr].push(s);
    }
    
    return Object.keys(strToAnagrams).map(key => strToAnagrams[key]);
};